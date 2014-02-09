/*
 * Copyright 2013 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.ElementsAttributes.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.finishOnKey;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.maxLength;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.method;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.playBeep;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.timeout;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.transcribe;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.transcribeCallback;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Record;
import static org.plivo.ee.faces.component.api.util.Elements.record;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;


@FacesComponent(record)
public class Record extends Component {

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		start(context, Record.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), timeout.name());
		addAttribute(context, getAttributes(), finishOnKey.name());
		addAttribute(context, getAttributes(), maxLength.name());
		addAttribute(context, getAttributes(), transcribe.name());
		addAttribute(context, getAttributes(), transcribeCallback.name());
		addAttribute(context, getAttributes(), playBeep.name());
		end(context, Record.name());
	}

}