/*
 * Copyright 2013 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.ElementsAttributes.method;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.value;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.addText;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Redirect;
import static org.plivo.ee.faces.component.api.util.Elements.redirect;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;


@FacesComponent(redirect)
public class Redirect extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Redirect.name());
		addAttribute(context, getAttributes(), method.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Redirect.name());
	}

}