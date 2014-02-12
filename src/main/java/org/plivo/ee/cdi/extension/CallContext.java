/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.plivo.ee.cdi.extension;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.plivo.ee.inject.context.CallScoped;
import org.plivo.ee.inject.notification.CallUUID;

public class CallContext implements Context {

	private final BeanManager beanManager;

	public CallContext(BeanManager beanManager) {
		this.beanManager = beanManager;
	}

	public <T> T get(final Contextual<T> contextual) {
		return null;
	}

	public <T> T get(final Contextual<T> contextual,
			final CreationalContext<T> creationalContext) {
		assertActive();
		Bean<T> bean = (Bean<T>) contextual;
		T beanInstance = bean.create(creationalContext);
		String callSid = getCallSid(beanInstance);
		T toReturn = getCallManager().getOrCreate(callSid, beanInstance);
		if (!toReturn.equals(beanInstance)) {
			contextual.destroy(beanInstance, creationalContext);
		}
		return toReturn;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CallManager getCallManager() {
		Bean phBean = (Bean) beanManager.getBeans(CallManager.class).iterator()
				.next();
		CreationalContext cc = beanManager.createCreationalContext(phBean);
		CallManager bean = (CallManager) beanManager.getReference(phBean,
				CallManager.class, cc);
		return bean;
	}

	private String getCallSid(Object instance) {
		try {
			Field[] fields = instance.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(CallUUID.class)) {
					Object value = field.get(instance);
					return (String) value;
				}
			}
			if (CallScopedInterface.class.isAssignableFrom(instance.getClass())) {
				CallScopedInterface callScoped = (CallScopedInterface) instance;
				if (callScoped != null && callScoped.getUUID() != null) {
					return callScoped.getUUID();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void assertActive() {
		if (!isActive()) {
			throw new ContextNotActiveException(
					"CallScoped context with scope annotation "
							+ "@CallScoped is not active with respect to the current thread");
		}
	}

	public Class<? extends Annotation> getScope() {
		return CallScoped.class;
	}

	public boolean isActive() {
		return true;
	}

}
