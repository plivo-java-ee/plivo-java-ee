/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.Elements.Message;
import static org.plivo.ee.faces.component.api.util.Elements.message;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callbackMethod;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callbackUrl;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.dst;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.src;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.type;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.value;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.addText;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;

@FacesComponent(message)
public class Message extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Message.name());
		addAttribute(context, getAttributes(), src.name());
		addAttribute(context, getAttributes(), dst.name());
		addAttribute(context, getAttributes(), type.name());
		addAttribute(context, getAttributes(), callbackUrl.name());
		addAttribute(context, getAttributes(), callbackMethod.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Message.name());
	}

}