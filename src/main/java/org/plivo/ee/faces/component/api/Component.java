/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.plivo.ee.faces.component.api;

import static org.plivo.ee.faces.component.api.util.Constants.FAMILY;
import static org.plivo.ee.faces.component.api.util.Constants.RENDER_TYPE;

import javax.faces.component.UIOutput;

public class Component extends UIOutput {

	@Override
	public String getFamily() {
		return FAMILY;
	}

	@Override
	public String getRendererType() {
		return RENDER_TYPE;
	}

}
