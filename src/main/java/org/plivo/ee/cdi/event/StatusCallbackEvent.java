/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.plivo.ee.cdi.event;

public class StatusCallbackEvent {

	private String dialAction;
	private String dialBLegStatus;
	private String dialALegUUID;
	private String dialBLegUUID;
	private String dialDigitsMatch;
	private String dialBLegHangupCause;
	private String dialBLegDuration;
	private String dialBLegBillDuration;
	private String dialBLegFrom;
	private String dialBLegTo;

	public StatusCallbackEvent() {
	}

	public StatusCallbackEvent(String dialAction, String dialBLegStatus,
			String dialALegUUID, String dialBLegUUID, String dialDigitsMatch,
			String dialBLegHangupCause, String dialBLegDuration,
			String dialBLegBillDuration, String dialBLegFrom, String dialBLegTo) {
		this.dialAction = dialAction;
		this.dialBLegStatus = dialBLegStatus;
		this.dialALegUUID = dialALegUUID;
		this.dialBLegUUID = dialBLegUUID;
		this.dialDigitsMatch = dialDigitsMatch;
		this.dialBLegHangupCause = dialBLegHangupCause;
		this.dialBLegDuration = dialBLegDuration;
		this.dialBLegBillDuration = dialBLegBillDuration;
		this.dialBLegFrom = dialBLegFrom;
		this.dialBLegTo = dialBLegTo;
	}

	@Override
	public String toString() {
		return "StatusCallbackEvent ["
				+ (dialAction != null ? "dialAction=" + dialAction + ", " : "")
				+ (dialBLegStatus != null ? "dialBLegStatus=" + dialBLegStatus
						+ ", " : "")
				+ (dialALegUUID != null ? "dialALegUUID=" + dialALegUUID + ", "
						: "")
				+ (dialBLegUUID != null ? "dialBLegUUID=" + dialBLegUUID + ", "
						: "")
				+ (dialDigitsMatch != null ? "dialDigitsMatch="
						+ dialDigitsMatch + ", " : "")
				+ (dialBLegHangupCause != null ? "dialBLegHangupCause="
						+ dialBLegHangupCause + ", " : "")
				+ (dialBLegDuration != null ? "dialBLegDuration="
						+ dialBLegDuration + ", " : "")
				+ (dialBLegBillDuration != null ? "dialBLegBillDuration="
						+ dialBLegBillDuration + ", " : "")
				+ (dialBLegFrom != null ? "dialBLegFrom=" + dialBLegFrom + ", "
						: "")
				+ (dialBLegTo != null ? "dialBLegTo=" + dialBLegTo : "") + "]";
	}

	public String getDialAction() {
		return dialAction;
	}

	public void setDialAction(String dialAction) {
		this.dialAction = dialAction;
	}

	public String getDialBLegStatus() {
		return dialBLegStatus;
	}

	public void setDialBLegStatus(String dialBLegStatus) {
		this.dialBLegStatus = dialBLegStatus;
	}

	public String getDialALegUUID() {
		return dialALegUUID;
	}

	public void setDialALegUUID(String dialALegUUID) {
		this.dialALegUUID = dialALegUUID;
	}

	public String getDialBLegUUID() {
		return dialBLegUUID;
	}

	public void setDialBLegUUID(String dialBLegUUID) {
		this.dialBLegUUID = dialBLegUUID;
	}

	public String getDialDigitsMatch() {
		return dialDigitsMatch;
	}

	public void setDialDigitsMatch(String dialDigitsMatch) {
		this.dialDigitsMatch = dialDigitsMatch;
	}

	public String getDialBLegHangupCause() {
		return dialBLegHangupCause;
	}

	public void setDialBLegHangupCause(String dialBLegHangupCause) {
		this.dialBLegHangupCause = dialBLegHangupCause;
	}

	public String getDialBLegDuration() {
		return dialBLegDuration;
	}

	public void setDialBLegDuration(String dialBLegDuration) {
		this.dialBLegDuration = dialBLegDuration;
	}

	public String getDialBLegBillDuration() {
		return dialBLegBillDuration;
	}

	public void setDialBLegBillDuration(String dialBLegBillDuration) {
		this.dialBLegBillDuration = dialBLegBillDuration;
	}

	public String getDialBLegFrom() {
		return dialBLegFrom;
	}

	public void setDialBLegFrom(String dialBLegFrom) {
		this.dialBLegFrom = dialBLegFrom;
	}

	public String getDialBLegTo() {
		return dialBLegTo;
	}

	public void setDialBLegTo(String dialBLegTo) {
		this.dialBLegTo = dialBLegTo;
	}

}
