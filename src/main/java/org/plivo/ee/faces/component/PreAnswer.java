/*
 * Copyright 2013 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.Elements.PreAnswer;
import static org.plivo.ee.faces.component.api.util.Elements.preAnswer;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;

@FacesComponent(preAnswer)
public class PreAnswer extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, PreAnswer.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, PreAnswer.name());
	}

}