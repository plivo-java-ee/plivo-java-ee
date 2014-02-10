/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.ElementsAttributes.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.method;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.fileFormat;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.redirect;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.timeout;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.maxLength;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.playBeep;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.finishOnKey;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.recordSession;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.startOnDialAnswer;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.transcriptionType;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.transcriptionUrl;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.transcriptionMethod;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callbackUrl;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callbackMethod;
import static org.plivo.ee.faces.component.api.util.TagUtils.addAttribute;
import static org.plivo.ee.faces.component.api.util.TagUtils.end;
import static org.plivo.ee.faces.component.api.util.TagUtils.start;
import static org.plivo.ee.faces.component.api.util.Elements.Record;
import static org.plivo.ee.faces.component.api.util.Elements.record;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.plivo.ee.faces.component.api.Component;
/*
 * @author <a href="mailto:fiorenzo.pizza@gmail.com">Fiorenzo Pizza</a>
 */
@FacesComponent(record)
public class Record extends Component {

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		start(context, Record.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), fileFormat.name());
		addAttribute(context, getAttributes(), redirect.name());
		addAttribute(context, getAttributes(), timeout.name());
		addAttribute(context, getAttributes(), maxLength.name());
		addAttribute(context, getAttributes(), playBeep.name());
		addAttribute(context, getAttributes(), finishOnKey.name());
		addAttribute(context, getAttributes(), recordSession.name());
		addAttribute(context, getAttributes(), startOnDialAnswer.name());
		addAttribute(context, getAttributes(), transcriptionType.name());
		addAttribute(context, getAttributes(), transcriptionUrl.name());
		addAttribute(context, getAttributes(), transcriptionMethod.name());
		addAttribute(context, getAttributes(), callbackUrl.name());
		addAttribute(context, getAttributes(), callbackMethod.name());
		end(context, Record.name());
	}
}