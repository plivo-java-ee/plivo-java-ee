/*
 * Copyright 2013 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.ElementsAttributes.length;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.silence;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.minSilence;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Wait;
import static org.plivo.ee.faces.component.api.util.Elements.wait;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;

@FacesComponent(wait)
public class Wait extends Component {

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		start(context, Wait.name());
		addAttribute(context, getAttributes(), length.name());
		addAttribute(context, getAttributes(), silence.name());
		addAttribute(context, getAttributes(), minSilence.name());
		end(context, Wait.name());
	}

}