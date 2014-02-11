/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.producer.util;

public enum RequestParamsEnum
{
	ALegRequestUUID,
	ALegUUID,
	BillDuration,
	CallStatus,
	CallUUID,
	ConferenceAction,
	ConferenceDigitsMatch,
	ConferenceMemberID,
	ConferenceName,
	ConferenceUUID,
	DialAction,
	DialALegUUID,
	DialBLegBillDuration,
	DialBLegDuration,
	DialBLegFrom,
	DialBLegHangupCause,
	DialBLegStatus,
	DialBLegTo,
	DialBLegUUID,
	DialDigitsMatch,
	DialHangupCause,
	DialRingStatus,
	DialStatus,
	Digits,
	Direction,
	Duration,
	ForwardedFrom,
	From,
	HangupCause,
	MessageUUID,
	RecordingDuration,
	RecordingDurationMs,
	RecordingEndMs,
	RecordingID,
	RecordingStartMs,
	RecordUrl,
	RequestParameters,
	Text,
	To,
	Type,
	XPh;

   public String toProperty()
   {
      return Character.toLowerCase(
               this.name().charAt(0)) + (this.name().length() > 1 ? this.name().substring(1) : "");
   }
}
