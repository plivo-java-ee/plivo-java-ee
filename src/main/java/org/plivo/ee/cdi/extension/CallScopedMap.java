/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.extension;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CallScopedMap implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> beanStore;

	public synchronized void put(String name, Object instance) {
		getBeanStore().put(name, instance);
	}

	public Object getContextualInstance(String name) {
		return getBeanStore().get(name);
	}

	public Set<String> getVariableNames() {
		return getBeanStore().keySet();
	}

	public synchronized void putAll(Map<String, Object> variables) {
		getBeanStore().putAll(variables);
	}

	public Map<String, Object> getAll() {
		return getBeanStore();
	}

	public synchronized void clear() {
		getBeanStore().clear();
	}

	public boolean holdsValue(String name) {
		if (name == null || name.trim().isEmpty())
			return false;
		return getBeanStore().containsKey(name);
	}

	public synchronized void remove(String name) {
		if (getBeanStore().containsKey(name)) {
			getBeanStore().remove(name);
		}
	}

	public synchronized Map<String, Object> getAllAndClear() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>(beanStore);
		beanStore.clear();
		return hashMap;
	}

	public Map<String, Object> getBeanStore() {
		if (beanStore == null) {
			beanStore = new ConcurrentHashMap<String, Object>();
		}
		return beanStore;
	}

}
