/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.ElementsAttributes.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.finishOnKey;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.method;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.numDigits;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.timeout;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Gather;
import static org.plivo.ee.faces.component.api.util.Elements.gather;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;


@FacesComponent(gather)
public class GetDigits extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, GetDigits.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), timeout.name());
		addAttribute(context, getAttributes(), finishOnKey.name());
		addAttribute(context, getAttributes(), numDigits.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, GetDigits.name());
	}

}