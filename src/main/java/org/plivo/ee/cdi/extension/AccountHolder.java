package org.plivo.ee.cdi.extension;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.plivo.ee.cdi.extension.util.Account;

public class AccountHolder implements Serializable {

	private static final long serialVersionUID = 1L;

	private static AccountHolder INSTANCE;

	private Map<String, Account> accounts;

	public AccountHolder() {
		accounts = Collections.synchronizedMap(new HashMap<String, Account>());
	}

	public synchronized static AccountHolder getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AccountHolder();
		}
		return INSTANCE;
	}

	public Account getDefaultAccount() {
		if (this.accounts.get("default") == null) {
			Account defaultAccount = new Account("deafult");
			this.accounts.put("default", defaultAccount);
			return defaultAccount;
		}
		return this.accounts.get("default");
	}

	public Account getAccount(String name) {
		return this.accounts.get(name);
	}

	public Map<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<String, Account> accounts) {
		this.accounts = accounts;
	}

	public String getNumber() {
		return getDefaultAccount().getNumber();
	}

	public String getAuthId() {
		return getDefaultAccount().getAuthId();
	}

	public String getAuthToken() {
		return getDefaultAccount().getAuthToken();
	}

}
