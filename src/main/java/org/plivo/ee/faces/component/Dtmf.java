/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.Elements.DTMF;
import static org.plivo.ee.faces.component.api.util.Elements.dtmf;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.async;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.value;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.addText;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;

@FacesComponent(dtmf)
public class Dtmf extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, DTMF.name());
		addAttribute(context, getAttributes(), async.name());
		addText(context, getAttributes(), value.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, DTMF.name());
	}

}