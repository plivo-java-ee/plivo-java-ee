/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.extension;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;

import org.plivo.ee.cdi.extension.util.Account;
import org.plivo.ee.cdi.extension.util.KeyValue;

/**
 * @author Gavin King
 * @link http://in.relation.to/13053.lace
 * 
 * @author Fiorenzo Pizza
 */
public class AccountConfigurationExtension implements Extension {
	static String PROPERTIES_FILE = "accounts.properties";
	static String ACCOUNT_KEY = "accounts";
	Logger logger = Logger.getLogger(getClass().getName());

	public void bind(@Observes AfterBeanDiscovery event, BeanManager beanManager) {
		{
			logger.info("AccountConfigurationExtension starting up");
			InputStream stream = this.getClass().getClassLoader()
					.getResourceAsStream(PROPERTIES_FILE);
			Map<String, Account> accounts = new HashMap<String, Account>();
			Properties props = new Properties();
			if (stream != null) {
				try {
					props.load(stream);
					if (props.containsKey(ACCOUNT_KEY)) {
						String value = (String) props.get(ACCOUNT_KEY);
						String[] names = value.split(",");
						for (String name : names) {
							Account account = new Account(name.trim()
									.toLowerCase());
							accounts.put(account.getName(), account);
						}
					}
					for (Object k : props.keySet()) {
						String key = (String) k;
						if (!key.equals(ACCOUNT_KEY)) {
							KeyValue keyValue = from(key,
									props.getProperty(key));
							if (keyValue != null)
								in(keyValue, accounts);
						}
					}
					getCallManager(beanManager).setAccounts(accounts);
					for (String accKey : accounts.keySet()) {
						logger.info(accounts.get(accKey).toString());
						// twilioAccounts.get(accKey).isValid();
					}

				} catch (Exception e) {
					logger.info(e.getMessage());
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
					}
				}
			} else {
				logger.info("no file acounts.properties in class path");
			}
			logger.info("AccountConfigurationExtension exit");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CallManager getCallManager(BeanManager beanManager) {
		Bean phBean = (Bean) beanManager.getBeans(CallManager.class).iterator()
				.next();
		CreationalContext cc = beanManager.createCreationalContext(phBean);
		CallManager bean = (CallManager) beanManager.getReference(phBean,
				CallManager.class, cc);
		return bean;
	}

	private static KeyValue from(String key, String value) {
		if (key != null && !key.isEmpty() && key.contains(".")) {
			String[] s = key.split("\\.");
			KeyValue keyValue = new KeyValue(s[1].trim().toLowerCase(),
					s[2].trim(), value.trim());
			return keyValue;
		}
		return null;

	}

	private static void in(KeyValue keyValue, Map<String, Account> accounts)
			throws Exception {
		if (accounts.containsKey(keyValue.getAccount())) {
			Account account = accounts.get(keyValue.getAccount());
			account.setField(keyValue.getKey(), keyValue.getValue());
		} else {
			throw new Exception("account " + keyValue.getAccount()
					+ " doesn't exist on the map");
		}
	}
}
