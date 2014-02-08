/*
 * Copyright 2013 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.ElementsAttributes.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.method;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.hangupOnStar;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.timeLimit;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.timeout;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callerId;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callerName;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.confirmSound;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.confirmKey;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.dialMusic;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callbackUrl;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callbackMethod;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.redirect;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.digitsMatch;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.sipHeaders;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.value;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.addText;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Dial;
import static org.plivo.ee.faces.component.api.util.Elements.dial;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;

@FacesComponent(dial)
public class Dial extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Dial.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), hangupOnStar.name());
		addAttribute(context, getAttributes(), timeLimit.name());
		addAttribute(context, getAttributes(), timeout.name());
		addAttribute(context, getAttributes(), callerId.name());
		addAttribute(context, getAttributes(), callerName.name());
		addAttribute(context, getAttributes(), confirmSound.name());
		addAttribute(context, getAttributes(), confirmKey.name());
		addAttribute(context, getAttributes(), dialMusic.name());
		addAttribute(context, getAttributes(), callbackUrl.name());
		addAttribute(context, getAttributes(), callbackMethod.name());
		addAttribute(context, getAttributes(), redirect.name());
		addAttribute(context, getAttributes(), digitsMatch.name());
		addAttribute(context, getAttributes(), sipHeaders.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Dial.name());
	}

}