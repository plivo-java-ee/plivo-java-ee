/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.ElementsAttributes.language;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.loop;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.value;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.voice;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.addText;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Say;
import static org.plivo.ee.faces.component.api.util.Elements.say;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;


@FacesComponent(say)
public class Speak extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Speak.name());
		addAttribute(context, getAttributes(), voice.name());
		addAttribute(context, getAttributes(), language.name());
		addAttribute(context, getAttributes(), loop.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Speak.name());
	}

}