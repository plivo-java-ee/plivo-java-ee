/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Hangup;
import static org.plivo.ee.faces.component.api.util.Elements.hangup;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.reason;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.schedule;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;

@FacesComponent(hangup)
public class Hangup extends Component {

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		start(context, Hangup.name());
		addAttribute(context, getAttributes(), reason.name());
		addAttribute(context, getAttributes(), schedule.name());

		end(context, Hangup.name());
	}

}