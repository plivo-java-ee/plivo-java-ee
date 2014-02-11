/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.producer;

import javax.enterprise.inject.Produces;

import org.plivo.ee.cdi.producer.util.RequestMap;
import org.plivo.ee.cdi.producer.util.RequestParamsEnum;
import org.plivo.ee.inject.notification.ALegRequestUUID;
import org.plivo.ee.inject.notification.ALegUUID;
import org.plivo.ee.inject.notification.BillDuration;
import org.plivo.ee.inject.notification.CallStatus;
import org.plivo.ee.inject.notification.CallUUID;
import org.plivo.ee.inject.notification.ConferenceAction;
import org.plivo.ee.inject.notification.ConferenceDigitsMatch;
import org.plivo.ee.inject.notification.ConferenceMemberID;
import org.plivo.ee.inject.notification.ConferenceName;
import org.plivo.ee.inject.notification.ConferenceUUID;
import org.plivo.ee.inject.notification.DialALegUUID;
import org.plivo.ee.inject.notification.DialAction;
import org.plivo.ee.inject.notification.DialBLegBillDuration;
import org.plivo.ee.inject.notification.DialBLegDuration;
import org.plivo.ee.inject.notification.DialBLegFrom;
import org.plivo.ee.inject.notification.DialBLegHangupCause;
import org.plivo.ee.inject.notification.DialBLegStatus;
import org.plivo.ee.inject.notification.DialBLegTo;
import org.plivo.ee.inject.notification.DialBLegUUID;
import org.plivo.ee.inject.notification.DialDigitsMatch;
import org.plivo.ee.inject.notification.DialHangupCause;
import org.plivo.ee.inject.notification.DialRingStatus;
import org.plivo.ee.inject.notification.DialStatus;
import org.plivo.ee.inject.notification.Digits;
import org.plivo.ee.inject.notification.Direction;
import org.plivo.ee.inject.notification.Duration;
import org.plivo.ee.inject.notification.ForwardedFrom;
import org.plivo.ee.inject.notification.From;
import org.plivo.ee.inject.notification.HangupCause;
import org.plivo.ee.inject.notification.MessageUUID;
import org.plivo.ee.inject.notification.RecordUrl;
import org.plivo.ee.inject.notification.RecordingDuration;
import org.plivo.ee.inject.notification.RecordingDurationMs;
import org.plivo.ee.inject.notification.RecordingEndMs;
import org.plivo.ee.inject.notification.RecordingID;
import org.plivo.ee.inject.notification.RecordingStartMs;
import org.plivo.ee.inject.notification.RequestParameters;
import org.plivo.ee.inject.notification.Text;
import org.plivo.ee.inject.notification.To;
import org.plivo.ee.inject.notification.Type;
import org.plivo.ee.inject.notification.XPh;

public class RequestParameterProducer extends AbstractRequestProducer {

	@Produces
	@RequestParameters
	public RequestMap getTwilioRequestParams() {
		return getRequestMapComplete(null);
	}

	@Produces
	@ALegRequestUUID
	public String getALegRequestUUID() {
		return get(RequestParamsEnum.ALegRequestUUID.name());
	}

	@Produces
	@ALegUUID
	public String getALegUUID() {
		return get(RequestParamsEnum.ALegUUID.name());
	}

	@Produces
	@BillDuration
	public String getBillDuration() {
		return get(RequestParamsEnum.BillDuration.name());
	}

	@Produces
	@CallStatus
	public String getCallStatus() {
		return get(RequestParamsEnum.CallStatus.name());
	}

	@Produces
	@CallUUID
	public String getCallUUID() {
		return get(RequestParamsEnum.CallUUID.name());
	}

	@Produces
	@ConferenceAction
	public String getConferenceAction() {
		return get(RequestParamsEnum.ConferenceAction.name());
	}

	@Produces
	@ConferenceDigitsMatch
	public String getConferenceDigitsMatch() {
		return get(RequestParamsEnum.ConferenceDigitsMatch.name());
	}

	@Produces
	@ConferenceMemberID
	public String getConferenceMemberID() {
		return get(RequestParamsEnum.ConferenceMemberID.name());
	}

	@Produces
	@ConferenceName
	public String getConferenceName() {
		return get(RequestParamsEnum.ConferenceName.name());
	}

	@Produces
	@ConferenceUUID
	public String getConferenceUUID() {
		return get(RequestParamsEnum.ConferenceUUID.name());
	}

	@Produces
	@DialAction
	public String getDialAction() {
		return get(RequestParamsEnum.DialAction.name());
	}

	@Produces
	@DialALegUUID
	public String getDialALegUUID() {
		return get(RequestParamsEnum.DialALegUUID.name());
	}

	@Produces
	@DialBLegBillDuration
	public String getDialBLegBillDuration() {
		return get(RequestParamsEnum.DialBLegBillDuration.name());
	}

	@Produces
	@DialBLegDuration
	public String getDialBLegDuration() {
		return get(RequestParamsEnum.DialBLegDuration.name());
	}

	@Produces
	@DialBLegFrom
	public String getDialBLegFrom() {
		return get(RequestParamsEnum.DialBLegFrom.name());
	}

	@Produces
	@DialBLegHangupCause
	public String getDialBLegHangupCause() {
		return get(RequestParamsEnum.DialBLegHangupCause.name());
	}

	@Produces
	@DialBLegStatus
	public String getDialBLegStatus() {
		return get(RequestParamsEnum.DialBLegStatus.name());
	}

	@Produces
	@DialBLegTo
	public String getDialBLegTo() {
		return get(RequestParamsEnum.DialBLegTo.name());
	}

	@Produces
	@DialBLegUUID
	public String getDialBLegUUID() {
		return get(RequestParamsEnum.DialBLegUUID.name());
	}

	@Produces
	@DialDigitsMatch
	public String getDialDigitsMatch() {
		return get(RequestParamsEnum.DialDigitsMatch.name());
	}

	@Produces
	@DialHangupCause
	public String getDialHangupCause() {
		return get(RequestParamsEnum.DialHangupCause.name());
	}

	@Produces
	@DialRingStatus
	public String getDialRingStatus() {
		return get(RequestParamsEnum.DialRingStatus.name());
	}

	@Produces
	@DialStatus
	public String getDialStatus() {
		return get(RequestParamsEnum.DialStatus.name());
	}

	@Produces
	@Digits
	public String getDigits() {
		return get(RequestParamsEnum.Digits.name());
	}

	@Produces
	@Direction
	public String getDirection() {
		return get(RequestParamsEnum.Direction.name());
	}

	@Produces
	@Duration
	public String getDuration() {
		return get(RequestParamsEnum.Duration.name());
	}

	@Produces
	@ForwardedFrom
	public String getForwardedFrom() {
		return get(RequestParamsEnum.ForwardedFrom.name());
	}

	@Produces
	@From
	public String getFrom() {
		return get(RequestParamsEnum.From.name());
	}

	@Produces
	@HangupCause
	public String getHangupCause() {
		return get(RequestParamsEnum.HangupCause.name());
	}

	@Produces
	@MessageUUID
	public String getMessageUUID() {
		return get(RequestParamsEnum.MessageUUID.name());
	}

	@Produces
	@RecordingDuration
	public String getRecordingDuration() {
		return get(RequestParamsEnum.RecordingDuration.name());
	}

	@Produces
	@RecordingDurationMs
	public String getRecordingDurationMs() {
		return get(RequestParamsEnum.RecordingDurationMs.name());
	}

	@Produces
	@RecordingEndMs
	public String getRecordingEndMs() {
		return get(RequestParamsEnum.RecordingEndMs.name());
	}

	@Produces
	@RecordingID
	public String getRecordingID() {
		return get(RequestParamsEnum.RecordingID.name());
	}

	@Produces
	@RecordingStartMs
	public String getRecordingStartMs() {
		return get(RequestParamsEnum.RecordingStartMs.name());
	}

	@Produces
	@RecordUrl
	public String getRecordUrl() {
		return get(RequestParamsEnum.RecordUrl.name());
	}

	@Produces
	@Text
	public String getText() {
		return get(RequestParamsEnum.Text.name());
	}

	@Produces
	@To
	public String getTo() {
		return get(RequestParamsEnum.To.name());
	}

	@Produces
	@Type
	public String getType() {
		return get(RequestParamsEnum.Type.name());
	}

	@Produces
	@XPh
	public RequestMap getXPh() {
		return getRequestMapComplete("X-PH-");
	}
}
