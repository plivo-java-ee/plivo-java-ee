/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.extension;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;

@SuppressWarnings("rawtypes")
public class CallScopeContextHolder implements Serializable {

	private static final long serialVersionUID = 1L;

	private static CallScopeContextHolder INSTANCE;

	private Map<String, CallScopedInstance> beans;

	public CallScopeContextHolder() {
		beans = Collections
				.synchronizedMap(new HashMap<String, CallScopedInstance>());
	}

	public synchronized static CallScopeContextHolder getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CallScopeContextHolder();
		}
		return INSTANCE;
	}

	public Map<String, CallScopedInstance> getBeans() {
		return beans;
	}

	public CallScopedInstance getBean(String name) {
		return getBeans().get(name);
	}

	public <T> T getOrCreate(String name, CallScopedInstance callScopedInstance) {
		if (getBeans().containsKey(name))
			return (T) callScopedInstance;
		if (name != null && !name.trim().isEmpty()
				&& callScopedInstance != null)
			getBeans().put(name, callScopedInstance);
		return (T) callScopedInstance;
	}

	public void putBean(String name, CallScopedInstance callScopedInstance) {
		getBeans().put(name, callScopedInstance);
	}

	public void destroyBean(String name) {
		CallScopedInstance callScopedInstance = getBean(name);
		callScopedInstance.bean.destroy(callScopedInstance.instance,
				callScopedInstance.ctx);
		getBeans().remove(name);
	}

	public static class CallScopedInstance<T> {
		Bean<T> bean;
		CreationalContext<T> ctx;
		T instance;
	}

}