/*
 * Copyright 2013 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.ElementsAttributes.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.from;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.method;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.statusCallBack;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.to;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.value;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.addText;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Sms;
import static org.plivo.ee.faces.component.api.util.Elements.sms;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;


@FacesComponent(sms)
public class User extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, User.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), to.name());
		addAttribute(context, getAttributes(), from.name());
		addAttribute(context, getAttributes(), statusCallBack.name());
		addText(context, getAttributes(), value.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, User.name());
	}

}