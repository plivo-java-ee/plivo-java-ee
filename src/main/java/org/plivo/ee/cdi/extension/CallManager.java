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

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.plivo.ee.cdi.event.HangupEvent;
import org.plivo.ee.cdi.extension.util.Account;

@ApplicationScoped
public class CallManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private CallScopedMap callScopedMap;
	private Map<String, Account> accounts;

	public CallManager() {
	}

	public void processEvent(@Observes HangupEvent event) {
		if (event instanceof HangupEvent) {
			getCallScopedMap().remove(event.getCallUUID());
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getVariable(String variableName) {
		Object value = null;
		if (getCallScopedMap().holdsValue(variableName)) {
			value = getCallScopedMap().getContextualInstance(variableName);
			return (T) value;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T getOrCreate(String callUUID, Object instance) {
		Object value = null;
		if (getCallScopedMap().holdsValue(callUUID)) {
			value = getCallScopedMap().getContextualInstance(callUUID);
			return (T) value;
		} else {
			getCallScopedMap().put(callUUID, instance);
			return (T) instance;
		}
	}

	public void setVariable(String variableName, Object value) {
		getCallScopedMap().put(variableName, value);
	}

	public CallScopedMap getCallScopedMap() {
		if (callScopedMap == null)
			this.callScopedMap = new CallScopedMap();
		return callScopedMap;
	}

	public void setBeanStore(CallScopedMap callScopedMap) {
		this.callScopedMap = callScopedMap;
	}

	public void setScopedMap(CallScopedMap callScopedMap) {
		this.callScopedMap = callScopedMap;
	}

	public Map<String, Account> getAccounts() {
		if (accounts == null)
			this.accounts = new HashMap<String, Account>();
		return accounts;
	}

	public Account getDefaultAccount() {
		if (getAccounts().get("default") == null) {
			Account defaultAccount = new Account("deafult");
			getAccounts().put("default", defaultAccount);
			return defaultAccount;
		}
		return getAccounts().get("default");
	}

	public Account getAccount(String account) {
		return getAccounts().get(account);
	}

	public void setAccounts(Map<String, Account> accounts) {
		this.accounts = accounts;
	}
}