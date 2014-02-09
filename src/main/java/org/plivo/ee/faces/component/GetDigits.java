/*
 * Copyright 2013 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.ElementsAttributes.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.method.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.timeout.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.finishOnKey.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.numDigits.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.redirect.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.playBeep.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.validDigits.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.invalidDigitsSound.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.log.action;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.GetDigits;
import static org.plivo.ee.faces.component.api.util.Elements.getDigits;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;

@FacesComponent(getDigits)
public class GetDigits extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, GetDigits.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), timeout.name());
		addAttribute(context, getAttributes(), finishOnKey.name());
		addAttribute(context, getAttributes(), numDigits.name());
		addAttribute(context, getAttributes(), redirect.name());
		addAttribute(context, getAttributes(), playBeep.name());
		addAttribute(context, getAttributes(), validDigits.name());
		addAttribute(context, getAttributes(), invalidDigitsSound.name());
		addAttribute(context, getAttributes(), log.name());

	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, GetDigits.name());
	}

}