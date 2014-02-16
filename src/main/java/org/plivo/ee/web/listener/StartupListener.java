package org.plivo.ee.web.listener;

/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.plivo.ee.cdi.extension.CallManager;

@WebListener
public class StartupListener implements ServletContextListener {

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	CallManager callManager;

	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("context destroyed");
	}

	public void contextInitialized(ServletContextEvent sce) {
		logger.info("context Initialized");
		if (callManager == null) {
			logger.info("callManager is null!!!");
			return;
		} else {
			logger.info("default account is already configured");
		}
		logger.log(Level.INFO, "Plivo-java-ee {0} is on!",
				org.plivo.ee.faces.component.api.util.Constants.VERSION);
	}
}
