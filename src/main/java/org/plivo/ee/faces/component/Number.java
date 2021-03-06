/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.Elements.Number;
import static org.plivo.ee.faces.component.api.util.Elements.number;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.sendOnPreanswer;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.sendDigits;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.value;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.addText;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;
/*
 * @author <a href="mailto:fiorenzo.pizza@gmail.com">Fiorenzo Pizza</a>
 */
@FacesComponent(number)
public class Number extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Number.name());
		addAttribute(context, getAttributes(), sendDigits.name());
		addAttribute(context, getAttributes(), sendOnPreanswer.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Number.name());
	}

}