/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.helper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.plivo.ee.cdi.helper.simple.SimpleSender;
import org.plivo.ee.inject.account.AccountNumber;
import org.plivo.ee.inject.account.AuthId;
import org.plivo.ee.inject.account.AuthToken;

@Named
@RequestScoped
public class Sender extends SimpleSender {

	private static final long serialVersionUID = 1L;

	@Inject
	public Sender(@AccountNumber String number, @AuthId String authId,
			@AuthToken String authToken) {
		super(number, authId, authToken);
	}

	public Sender() {
	}
}
