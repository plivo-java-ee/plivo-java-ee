/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Response;
import static org.plivo.ee.faces.component.api.util.Elements.response;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;

/*
 * @author <a href="mailto:fiorenzo.pizza@gmail.com">Fiorenzo Pizza</a>
 */
@FacesComponent(response)
public class Response extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Response.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, Response.name());
	}

}