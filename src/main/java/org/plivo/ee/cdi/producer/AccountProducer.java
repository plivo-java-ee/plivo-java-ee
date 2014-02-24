/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.plivo.ee.cdi.extension.AccountHolder;
import org.plivo.ee.cdi.extension.util.Account;
import org.plivo.ee.cdi.helper.Caller;
import org.plivo.ee.cdi.helper.Sender;
import org.plivo.ee.cdi.producer.util.ELUtils;
import org.plivo.ee.inject.account.AccountNumber;
import org.plivo.ee.inject.account.AuthId;
import org.plivo.ee.inject.account.AuthToken;
import org.plivo.ee.inject.account.PlivoAccount;

public class AccountProducer extends AbstractRequestProducer {
	private AccountHolder accountHolder;

	public AccountProducer() {
		this.accountHolder = AccountHolder.getInstance();
	}

	@Produces
	@AccountNumber
	public String getNumber(InjectionPoint injectionPoint) {
		String accountName = injectionPoint.getAnnotated()
				.getAnnotation(AccountNumber.class).accountName();
		if (accountHolder != null) {
			if (accountName == null || accountName.isEmpty()
					|| accountName.equals("default"))
				return accountHolder.getNumber();
			else {
				if (ELUtils.isElExpression(accountName)) {
					accountName = ELUtils.resolveElExpression(accountName,
							facesContext());
				}
				if (accountName != null) {
					Account account = accountHolder.getAccount(accountName);
					if (account != null)
						return account.getNumber();
				}
			}
		}
		return null;
	}

	@Produces
	@AuthId
	public String getAuthId(InjectionPoint injectionPoint) {
		String accountName = injectionPoint.getAnnotated()
				.getAnnotation(AuthId.class).accountName();
		if (accountHolder != null) {
			if (accountName == null || accountName.isEmpty()
					|| accountName.toLowerCase().equals("default"))
				return accountHolder.getAuthId();
			else {
				if (ELUtils.isElExpression(accountName)) {
					accountName = ELUtils.resolveElExpression(accountName,
							facesContext());
				}
				if (accountName != null) {
					Account account = accountHolder.getAccount(accountName);
					if (account != null)
						return account.getAuthId();
				}
			}
		}
		return null;
	}

	@Produces
	@AuthToken
	public String getAuthToken(InjectionPoint injectionPoint) {
		String accountName = injectionPoint.getAnnotated()
				.getAnnotation(AuthToken.class).accountName();
		if (accountHolder != null) {
			if (accountName == null || accountName.isEmpty()
					|| accountName.toLowerCase().equals("default"))
				return accountHolder.getAuthToken();
			else {
				if (ELUtils.isElExpression(accountName)) {
					accountName = ELUtils.resolveElExpression(accountName,
							facesContext());
				}
				if (accountName != null) {
					Account account = accountHolder.getAccount(accountName);
					if (account != null)
						return account.getAuthToken();
				}
			}
		}
		return null;
	}

	@Produces
	@PlivoAccount
	public Account getPlivoAccount(InjectionPoint injectionPoint) {
		String accountName = injectionPoint.getAnnotated()
				.getAnnotation(PlivoAccount.class).accountName();
		if (accountHolder != null) {
			if (accountName == null || accountName.isEmpty()
					|| accountName.toLowerCase().equals("default"))
				return accountHolder.getDefaultAccount();
			else {
				if (ELUtils.isElExpression(accountName)) {
					accountName = ELUtils.resolveElExpression(accountName,
							facesContext());
				}
				if (accountName != null)
					return accountHolder.getAccount(accountName);
			}
		}
		return null;
	}

	@Produces
	@PlivoAccount
	public Caller getCaller(InjectionPoint injectionPoint) {
		String accountName = injectionPoint.getAnnotated()
				.getAnnotation(PlivoAccount.class).accountName();
		if (accountHolder != null) {
			if (accountName == null || accountName.isEmpty()
					|| accountName.toLowerCase().equals("default"))
				return new Caller(
						accountHolder.getDefaultAccount().getNumber(),
						accountHolder.getDefaultAccount().getAuthId(),
						accountHolder.getDefaultAccount().getAuthToken());
			else {
				Account account;
				if (ELUtils.isElExpression(accountName)) {
					accountName = ELUtils.resolveElExpression(accountName,
							facesContext());
				}
				if (accountName != null) {
					account = accountHolder.getAccount(accountName);
					if (account != null)
						return new Caller(account.getNumber(),
								account.getAuthId(), account.getAuthToken());
				}
			}
		}
		return null;
	}

	@Produces
	@PlivoAccount
	public Sender getSender(InjectionPoint injectionPoint) {
		String accountName = injectionPoint.getAnnotated()
				.getAnnotation(PlivoAccount.class).accountName();
		if (accountHolder != null) {
			if (accountName == null || accountName.isEmpty()
					|| accountName.toLowerCase().equals("default"))
				return new Sender(
						accountHolder.getDefaultAccount().getNumber(),
						accountHolder.getDefaultAccount().getAuthId(),
						accountHolder.getDefaultAccount().getAuthToken());
			else {
				Account account;
				if (ELUtils.isElExpression(accountName)) {
					accountName = ELUtils.resolveElExpression(accountName,
							facesContext());
				}
				if (accountName != null) {
					account = accountHolder.getAccount(accountName);
					if (account != null)
						return new Sender(account.getNumber(),
								account.getAuthId(), account.getAuthToken());
				}
			}
		}
		return null;
	}
}
