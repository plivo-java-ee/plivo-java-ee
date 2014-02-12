/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.producer;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.plivo.ee.cdi.producer.util.RequestMap;

public abstract class AbstractRequestProducer {

	protected FacesContext facesContext() {
		return FacesContext.getCurrentInstance();
	}

	private ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	private Map<String, String> getRequestMap() {
		if (facesContext() != null && getExternalContext() != null
				&& getExternalContext().getRequestParameterMap() != null)
			return getExternalContext().getRequestParameterMap();
		return null;
	}

	protected Map<String, Object> getApplicationMap() {
		if (facesContext() != null && getExternalContext() != null
				&& getExternalContext().getApplicationMap() != null) {
			return facesContext().getExternalContext().getApplicationMap();
		}
		return null;
	}

	protected String get(String name) {
		if (getRequestMap() != null) {
			return getRequestMap().get(name);
		}
		return null;
	}

	protected RequestMap getRequestMapComplete(String filter) {
		boolean withFilter = (filter != null && !filter.isEmpty()) ? true
				: false;
		RequestMap requestMap = new RequestMap();
		if (getApplicationMap() != null) {
			for (String plivoParam : facesContext().getExternalContext()
					.getApplicationMap().keySet()) {
				requestMap.setValue(plivoParam, get(plivoParam));
				if (withFilter && !plivoParam.startsWith(filter)) {
					requestMap.getValues().remove(plivoParam);
				}
			}
		}
		return (!requestMap.getValues().isEmpty()) ? requestMap : null;
	}
}
