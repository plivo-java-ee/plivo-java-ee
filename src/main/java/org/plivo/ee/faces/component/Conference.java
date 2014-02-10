/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.faces.component;

import static org.plivo.ee.faces.component.api.util.Elements.Conference;
import static org.plivo.ee.faces.component.api.util.Elements.conference;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.muted;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.enterSound;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.exitSound;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.startConferenceOnEnter;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.endConferenceOnExit;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.stayAlone;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.waitSound;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.maxMembers;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.record;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.recordFileFormat;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.timeLimit;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.hangupOnStar;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.action;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.method;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callbackUrl;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.callbackMethod;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.digitsMatch;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.floorEvent;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.redirect;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.transcriptionType;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.transcriptionUrl;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.transcriptionMethod;
import static org.plivo.ee.faces.component.api.util.ElementsAttributes.relayDTMF;
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
@FacesComponent(conference)
public class Conference extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Conference.name());
		addAttribute(context, getAttributes(), muted.name());
		addAttribute(context, getAttributes(), enterSound.name());
		addAttribute(context, getAttributes(), exitSound.name());
		addAttribute(context, getAttributes(), startConferenceOnEnter.name());
		addAttribute(context, getAttributes(), endConferenceOnExit.name());
		addAttribute(context, getAttributes(), stayAlone.name());
		addAttribute(context, getAttributes(), waitSound.name());
		addAttribute(context, getAttributes(), maxMembers.name());
		addAttribute(context, getAttributes(), record.name());
		addAttribute(context, getAttributes(), recordFileFormat.name());
		addAttribute(context, getAttributes(), timeLimit.name());
		addAttribute(context, getAttributes(), hangupOnStar.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), callbackUrl.name());
		addAttribute(context, getAttributes(), callbackMethod.name());
		addAttribute(context, getAttributes(), digitsMatch.name());
		addAttribute(context, getAttributes(), floorEvent.name());
		addAttribute(context, getAttributes(), redirect.name());
		addAttribute(context, getAttributes(), transcriptionType.name());
		addAttribute(context, getAttributes(), transcriptionUrl.name());
		addAttribute(context, getAttributes(), transcriptionMethod.name());
		addAttribute(context, getAttributes(), relayDTMF.name());
		addText(context, getAttributes(), value.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, Conference.name());
	}
}