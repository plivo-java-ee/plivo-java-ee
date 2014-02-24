/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.cdi.helper.simple;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.plivo.ee.helper.api.client.simple.CallRestAPI;
import org.plivo.ee.helper.api.response.call.Call;
import org.plivo.ee.helper.exception.PlivoException;

public class SimpleCaller implements Serializable {

	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(getClass().getName());
	private String authId;
	private String authToken;

	private Map<String, String> params;

	public SimpleCaller() {
	}

	public SimpleCaller(String number, String authId, String authToken) {
		setNumber(number);
		this.authId = authId;
		this.authToken = authToken;
	}

	public String simpleCall(String number, String to, String authId,
			String authToken, String answerUrl) throws PlivoException {
		number(number).to(to).authToken(authToken).authId(authId)
				.answerUrl(answerUrl);
		return call();
	}

	public String simpleCall(String number, String to, String authId,
			String authToken, String answerUrl, String fallbackUrl,
			String hangupUrl) throws PlivoException {
		number(number).to(to).authId(authId).authToken(authToken)
				.answerUrl(answerUrl).fallbackUrl(fallbackUrl)
				.hangupUrl(hangupUrl);
		return call();
	}

	public String call() throws PlivoException {
		CallRestAPI callRestAPI = new CallRestAPI(getAuthId(), getAuthToken());
		Call call = callRestAPI.makeCall(getParams());
		if (call != null && call.getRequestUUID() != null)
			return call.getRequestUUID();
		return null;
	}

	public Call call(String accountSid, String authToken,
			Map<String, String> params) throws PlivoException {
		authId(authId).authToken(authToken).setParams(params);
		CallRestAPI callRestAPI = new CallRestAPI(getAuthId(), getAuthToken());
		Call call = callRestAPI.makeCall(getParams());
		return call;
	}

	public Map<String, String> getParams() {
		if (params == null)
			this.params = new HashMap<String, String>();
		return params;
	}

	public SimpleCaller setParams(Map<String, String> params) {
		this.params = params;
		return this;
	}

	public SimpleCaller add(String key, String value) {
		getParams().put(key, value);
		return this;
	}

	public String get(String key) {
		return get(key);
	}

	public String getAuthId() {
		return authId;
	}

	public SimpleCaller setAuthId(String authId) {
		this.authId = authId;
		return this;
	}

	public String getAuthToken() {
		return authToken;
	}

	public SimpleCaller setAuthToken(String authToken) {
		this.authToken = authToken;
		return this;
	}

	public String getNumber() {
		return get("from");
	}

	public SimpleCaller setNumber(String number) {
		add("from", number);
		return this;
	}

	public String getTo() {
		return get("to");
	}

	public SimpleCaller setTo(String to) {
		add("to", to);
		return this;
	}

	public String getAnswerUrl() {
		return get("answer_url");
	}

	public SimpleCaller setAnswerUrl(String answerUrl) {
		add("answer_url", answerUrl);
		return this;
	}

	public String getHangupUrl() {
		return get("hangup_url");
	}

	public SimpleCaller setHangupUrl(String hangupUrl) {
		add("hangup_url", hangupUrl);
		return this;
	}

	public String getFallbackUrl() {
		return get("fallback_url");
	}

	public SimpleCaller setFallbackUrl(String fallbackUrl) {
		add("fallback_url", fallbackUrl);
		return this;
	}

	public String getAnswerMethod() {
		return get("answer_method");
	}

	public SimpleCaller setAnswerMethod(String answerMethod) {
		add("answer_method", answerMethod);
		return this;
	}

	public String getRingUrl() {
		return get("ring_url");
	}

	public SimpleCaller setRingUrl(String ringUrl) {
		add("ring_url", ringUrl);
		return this;
	}

	public String getRingMethod() {
		return get("ring_method");
	}

	public SimpleCaller setRingMethod(String ringMethod) {
		add("ring_method", ringMethod);
		return this;
	}

	public String getHangupMethod() {
		return get("hangup_method");
	}

	public SimpleCaller setHangupMethod(String hangupMethod) {
		add("hangup_method", hangupMethod);
		return this;
	}

	public String getFallbackMethod() {
		return get("fallback_method");
	}

	public SimpleCaller setFallbackMethod(String fallbackMethod) {
		add("fallback_method", fallbackMethod);
		return this;
	}

	public String getCallerNamed() {
		return get("caller_name");
	}

	public SimpleCaller setCallerNamed(String callerNamed) {
		add("caller_name", callerNamed);
		return this;
	}

	public String getSendSigits() {
		return get("send_digits");
	}

	public SimpleCaller setSendDigits(String sendDigits) {
		add("send_digits", sendDigits);
		return this;
	}

	public String getSendOnPreanswer() {
		return get("send_on_preanswer");
	}

	public SimpleCaller setSendOnPreanswer(String sendOnPreanswer) {
		add("send_on_preanswer", sendOnPreanswer);
		return this;
	}

	public String getTimeLimit() {
		return get("time_limit");
	}

	public SimpleCaller setTimeLimit(String timeLimit) {
		add("time_limit", timeLimit);
		return this;
	}

	public String getHangupOnRing() {
		return get("hangup_on_ring");
	}

	public SimpleCaller setHangupOnRing(String hangupOnRing) {
		add("hangup_on_ring", hangupOnRing);
		return this;
	}

	public String getMachineDetection() {
		return get("machine_detection");
	}

	public SimpleCaller setMachineDetection(String machineDetection) {
		add("machine_detection", machineDetection);
		return this;
	}

	public String getMachineDetectionTime() {
		return get("machine_detection_time");
	}

	public SimpleCaller setMachineDetectionTime(String machineDetectionTime) {
		add("machine_detection_time", machineDetectionTime);
		return this;
	}

	public String getSipHeaders() {
		return get("sip_headers");
	}

	public SimpleCaller setSipHeaders(String sipHeaders) {
		add("sip_headers", sipHeaders);
		return this;
	}

	public String getRingTimeout() {
		return get("ring_timeout");
	}

	public SimpleCaller setRingTimeout(String ringTimeout) {
		add("ring_timeout", ringTimeout);
		return this;
	}

	/*
	 * FAST METHODS
	 */
	public SimpleCaller number(String number) {
		return setNumber(number);
	}

	public SimpleCaller to(String to) {
		return setTo(to);
	}

	public SimpleCaller authId(String authId) {
		return setAuthId(authId);
	}

	public SimpleCaller authToken(String authToken) {
		return setAuthToken(authToken);
	}

	public SimpleCaller answerUrl(String answerUrl) {
		return setAnswerUrl(answerUrl);
	}

	public SimpleCaller hangupUrl(String hangupUrl) {
		return setHangupUrl(hangupUrl);
	}

	public SimpleCaller fallbackUrl(String fallbackUrl) {
		return setFallbackUrl(fallbackUrl);
	}

	public SimpleCaller param(String key, String value) {
		return add(key, value);
	}

	public SimpleCaller answerMethod(String answerMethod) {
		return setAnswerMethod(answerMethod);
	}

	public SimpleCaller ringUrl(String ringUrl) {
		return setRingUrl(ringUrl);
	}

	public SimpleCaller ringMethod(String ringMethod) {
		return setRingMethod(ringMethod);
	}

	public SimpleCaller hangupMethod(String hangupMethod) {
		return setHangupMethod(hangupMethod);
	}

	public SimpleCaller fallbackMethod(String fallbackMethod) {
		return setFallbackMethod(fallbackMethod);
	}

	public SimpleCaller callerNamed(String callerNamed) {
		return setCallerNamed(callerNamed);
	}

	public SimpleCaller sendDigits(String sendDigits) {
		return setSendDigits(sendDigits);
	}

	public SimpleCaller sendOnPreanswer(String sendOnPreanswer) {
		return setSendOnPreanswer(sendOnPreanswer);
	}

	public SimpleCaller timeLimit(String timeLimit) {
		return setTimeLimit(timeLimit);
	}

	public SimpleCaller hangupOnRing(String hangupOnRing) {
		return setHangupOnRing(hangupOnRing);
	}

	public SimpleCaller machineDetection(String machineDetection) {
		return setMachineDetection(machineDetection);
	}

	public SimpleCaller machineDetectionTime(String machineDetectionTime) {
		return setMachineDetectionTime(machineDetectionTime);
	}

	public SimpleCaller sipHeaders(String sipHeaders) {
		return setSipHeaders(sipHeaders);
	}

	public SimpleCaller ringTimeout(String ringTimeout) {
		return setRingTimeout(ringTimeout);
	}

}
