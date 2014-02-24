/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.extension.util;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String authId;
	private String authToken;
	private String number;

	public Account() {
	}

	public Account(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setField(String name, Object value)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		Field field = getClass().getDeclaredField(name);
		field.set(this, value);
	}

	public void isValid() throws Exception {
		if (getName() == null || getName().isEmpty())
			throw new Exception("Account Name is null or empty");

		if (getNumber() == null || getNumber().isEmpty())
			throw new Exception("Account Number [" + getName()
					+ "] is null or empty");

		if (getAuthId() == null || getAuthId().isEmpty())
			throw new Exception("Account AuthId [" + getName()
					+ "] is null or empty");

		if (getAuthToken() == null || getAuthToken().isEmpty())
			throw new Exception("Account AuthToken [" + getName()
					+ "] is null or empty");
	}

	@Override
	public String toString() {
		return "Account [" + (name != null ? "name=" + name + ", " : "")
				+ (authId != null ? "authId=" + authId + ", " : "")
				+ (authToken != null ? "authToken=" + authToken + ", " : "")
				+ (number != null ? "number=" + number : "") + "]";
	}
	
	
}
