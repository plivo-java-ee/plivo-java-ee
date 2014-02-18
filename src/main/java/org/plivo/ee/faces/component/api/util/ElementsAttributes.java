/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */package org.plivo.ee.faces.component.api.util;

/*
 * @author <a href="mailto:fiorenzo.pizza@gmail.com">Fiorenzo Pizza</a>
 */
public enum ElementsAttributes {

	// Conference Attributes
	muted, enterSound, exitSound, startConferenceOnEnter, endConferenceOnExit, stayAlone, waitSound, maxMembers, record, recordFileFormat, timeLimit, hangupOnStar, action, method, callbackUrl, callbackMethod, digitsMatch, floorEvent, redirect, transcriptionType, transcriptionUrl, transcriptionMethod, relayDTMF,

	timeout, callerId, callerName, confirmSound, confirmKey, dialMusic, sipHeaders,

	sendDigits, sendOnPreanswer,

	digitTimeout, async, retries, finishOnKey, numDigits, playBeep, validDigits, invalidDigitsSound, log,

	src, dst, type,

	reason, schedule,

	loop,

	fileFormat, maxLength, recordSession, startOnDialAnswer,

	voice, language,

	length, silence, minSilence,

	value;
}
