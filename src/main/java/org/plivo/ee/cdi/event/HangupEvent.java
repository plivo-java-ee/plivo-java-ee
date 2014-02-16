/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.plivo.ee.cdi.event;

public class HangupEvent {

	private String callStatus;
	private String callerName;
	private String event;
	private String to;
	private String callUUID;
	private String totalCost;
	private String answerTime;
	private String direction;
	private String billRate;
	private String hangupCause;
	private String duration;
	private String billDuration;
	private String endTime;
	private String startTime;
	private String from;

	public HangupEvent() {
	}

	public HangupEvent(String callStatus, String callerName, String event,
			String to, String callUUID, String totalCost, String answerTime,
			String direction, String billRate, String hangupCause,
			String duration, String billDuration, String endTime,
			String startTime, String from) {
		this.callStatus = callStatus;
		this.callerName = callerName;
		this.event = event;
		this.to = to;
		this.callUUID = callUUID;
		this.totalCost = totalCost;
		this.answerTime = answerTime;
		this.direction = direction;
		this.billRate = billRate;
		this.hangupCause = hangupCause;
		this.duration = duration;
		this.billDuration = billDuration;
		this.endTime = endTime;
		this.startTime = startTime;
		this.from = from;
	}

	@Override
	public String toString() {
		return "HangupEvent ["
				+ (callStatus != null ? "callStatus=" + callStatus + ", " : "")
				+ (callerName != null ? "callerName=" + callerName + ", " : "")
				+ (event != null ? "event=" + event + ", " : "")
				+ (to != null ? "to=" + to + ", " : "")
				+ (callUUID != null ? "callUUID=" + callUUID + ", " : "")
				+ (totalCost != null ? "totalCost=" + totalCost + ", " : "")
				+ (answerTime != null ? "answerTime=" + answerTime + ", " : "")
				+ (direction != null ? "direction=" + direction + ", " : "")
				+ (billRate != null ? "billRate=" + billRate + ", " : "")
				+ (hangupCause != null ? "hangupCause=" + hangupCause + ", "
						: "")
				+ (duration != null ? "duration=" + duration + ", " : "")
				+ (billDuration != null ? "billDuration=" + billDuration + ", "
						: "")
				+ (endTime != null ? "endTime=" + endTime + ", " : "")
				+ (startTime != null ? "startTime=" + startTime + ", " : "")
				+ (from != null ? "from=" + from : "") + "]";
	}

	public String getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCallUUID() {
		return callUUID;
	}

	public void setCallUUID(String callUUID) {
		this.callUUID = callUUID;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public String getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getBillRate() {
		return billRate;
	}

	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}

	public String getHangupCause() {
		return hangupCause;
	}

	public void setHangupCause(String hangupCause) {
		this.hangupCause = hangupCause;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getBillDuration() {
		return billDuration;
	}

	public void setBillDuration(String billDuration) {
		this.billDuration = billDuration;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
