/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.web.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.plivo.ee.cdi.event.HangupEvent;
import org.plivo.ee.inject.notification.AnswerTime;
import org.plivo.ee.inject.notification.BillDuration;
import org.plivo.ee.inject.notification.BillRate;
import org.plivo.ee.inject.notification.CallStatus;
import org.plivo.ee.inject.notification.CallUUID;
import org.plivo.ee.inject.notification.CallerName;
import org.plivo.ee.inject.notification.Direction;
import org.plivo.ee.inject.notification.Duration;
import org.plivo.ee.inject.notification.EndTime;
import org.plivo.ee.inject.notification.From;
import org.plivo.ee.inject.notification.HangupCause;
import org.plivo.ee.inject.notification.StartTime;
import org.plivo.ee.inject.notification.To;
import org.plivo.ee.inject.notification.TotalCost;

@RequestScoped
@Named
public class HangupController implements Serializable {

	Logger logger = Logger.getLogger(getClass().getName());

	private static final long serialVersionUID = 1L;

	@Inject
	@CallStatus
	private String callStatus;
	@Inject
	@CallerName
	private String callerName;
	@Inject
	@org.plivo.ee.inject.notification.Event
	private String event;
	@Inject
	@To
	private String to;
	@Inject
	@CallUUID
	private String callUUID;
	@Inject
	@TotalCost
	private String totalCost;
	@Inject
	@AnswerTime
	private String answerTime;
	@Inject
	@Direction
	private String direction;
	@Inject
	@BillRate
	private String billRate;
	@Inject
	@HangupCause
	private String hangupCause;
	@Inject
	@Duration
	private String duration;
	@Inject
	@BillDuration
	private String billDuration;
	@Inject
	@EndTime
	private String endTime;
	@Inject
	@StartTime
	private String startTime;
	@Inject
	@From
	private String from;

	@Inject
	Event<HangupEvent> hangupEventProducer;

	public void hangup() {
		HangupEvent hangupEvent = new HangupEvent(callStatus, callerName,
				event, to, callUUID, totalCost, answerTime, direction,
				billRate, hangupCause, duration, billDuration, endTime,
				startTime, from);
		logger.info(hangupEvent.toString());
		hangupEventProducer.fire(hangupEvent);
	}

}
