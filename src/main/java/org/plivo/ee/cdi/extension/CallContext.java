/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.plivo.ee.cdi.extension;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Bean;

import org.plivo.ee.cdi.event.HangupEvent;
import org.plivo.ee.cdi.extension.CallScopeContextHolder.CallScopedInstance;
import org.plivo.ee.inject.context.CallScoped;
import org.plivo.ee.inject.notification.CallUUID;

public class CallContext implements Context {

	private CallScopeContextHolder callScopeContextHolder;

	public CallContext() {
		this.callScopeContextHolder = CallScopeContextHolder.getInstance();
	}

	public <T> T get(final Contextual<T> contextual) {
		return null;
	}

	public <T> T get(final Contextual<T> contextual,
			final CreationalContext<T> creationalContext) {
		Bean bean = (Bean) contextual;
		T t = (T) bean.create(creationalContext);
		CallScopedInstance customInstance = new CallScopedInstance();
		customInstance.bean = bean;
		customInstance.ctx = creationalContext;
		customInstance.instance = t;
		String callSid = getCallUUID(t);
		callScopeContextHolder.putBean(callSid, customInstance);
		return t;
	}

	private String getCallUUID(Object instance) {
		try {
			Field[] fields = instance.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(CallUUID.class)) {
					Object value = field.get(instance);
					return (String) value;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Class<? extends Annotation> getScope() {
		return CallScoped.class;
	}

	public boolean isActive() {
		return true;
	}

	public void passivate(@Observes HangupEvent event) {
		if (event instanceof HangupEvent) {
			if (callScopeContextHolder.getBeans().containsKey(event.getCallUUID())) {
				callScopeContextHolder.destroyBean(event.getCallUUID());
			}
		}
	}

}
