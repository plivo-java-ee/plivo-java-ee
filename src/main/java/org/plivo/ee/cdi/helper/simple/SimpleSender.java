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

import org.plivo.ee.helper.api.client.simple.MessageRestAPI;
import org.plivo.ee.helper.api.response.message.MessageResponse;
import org.plivo.ee.helper.exception.PlivoException;

public class SimpleSender implements Serializable {

	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(getClass().getName());
	private String authId;
	private String authToken;

	private Map<String, String> params;

	public SimpleSender() {
	}

	public SimpleSender(String number, String authId, String authToken) {
		setNumber(number);
		this.authId = authId;
		this.authToken = authToken;
	}

	public String simpleSend(String number, String dst, String authId,
			String authToken, String text) throws PlivoException {
		number(number).dst(dst).authToken(authToken).authId(authId).text(text);
		return send();
	}

	public String simpleSend(String number, String dst, String authId,
			String authToken, String text, String url) throws PlivoException {
		number(number).dst(dst).authId(authId).authToken(authToken).text(text)
				.url(url);
		return send();
	}

	public String send() throws PlivoException {
		MessageRestAPI messageRestAPI = new MessageRestAPI(getAuthId(),
				getAuthToken());
		MessageResponse messageResponse = messageRestAPI
				.sendMessage(getParams());
		if (messageResponse != null
				&& messageResponse.getMessageUuids() != null
				&& messageResponse.getMessageUuids().size() > 0)
			return messageResponse.getMessageUuids().get(0);
		return null;
	}

	public MessageResponse send(String accountSid, String authToken,
			Map<String, String> params) throws PlivoException {
		authId(authId).authToken(authToken).setParams(params);
		MessageRestAPI messageRestAPI = new MessageRestAPI(getAuthId(),
				getAuthToken());
		MessageResponse messageResponse = messageRestAPI
				.sendMessage(getParams());
		return messageResponse;
	}

	public Map<String, String> getParams() {
		if (params == null)
			this.params = new HashMap<String, String>();
		return params;
	}

	public SimpleSender setParams(Map<String, String> params) {
		this.params = params;
		return this;
	}

	public SimpleSender add(String key, String value) {
		getParams().put(key, value);
		return this;
	}

	public String get(String key) {
		return get(key);
	}

	public String getAuthId() {
		return authId;
	}

	public SimpleSender setAuthId(String authId) {
		this.authId = authId;
		return this;
	}

	public String getAuthToken() {
		return authToken;
	}

	public SimpleSender setAuthToken(String authToken) {
		this.authToken = authToken;
		return this;
	}

	public String getNumber() {
		return get("src");
	}

	public SimpleSender setNumber(String number) {
		add("src", number);
		return this;
	}

	public String getText() {
		return get("text");
	}

	public SimpleSender setText(String text) {
		add("text", text);
		return this;
	}

	public String getUrl() {
		return get("url");
	}

	public SimpleSender setUrl(String url) {
		add("url", url);
		return this;
	}

	public String getDst() {
		return get("dst");
	}

	public SimpleSender setDst(String dst) {
		add("dst", dst);
		return this;
	}

	public String getType() {
		return get("type");
	}

	public SimpleSender setType(String type) {
		add("type", type);
		return this;
	}

	public String getMethod() {
		return get("method");
	}

	public SimpleSender setMethod(String method) {
		add("method", method);
		return this;
	}

	public SimpleSender setLog(String log) {
		add("log", log);
		return this;
	}

	public String getLog() {
		return get("log");
	}

	/*
	 * FAST METHODS
	 */
	public SimpleSender number(String number) {
		return setNumber(number);
	}

	public SimpleSender text(String text) {
		return setText(text);
	}

	public SimpleSender dst(String dst) {
		return setDst(dst);
	}

	public SimpleSender authId(String authId) {
		return setAuthId(authId);
	}

	public SimpleSender authToken(String authToken) {
		return setAuthToken(authToken);
	}

	public SimpleSender url(String url) {
		return setUrl(url);
	}

	public SimpleSender param(String key, String value) {
		return add(key, value);
	}

	public SimpleSender type(String type) {
		return setType(type);
	}

	public SimpleSender method(String method) {
		return setMethod(method);
	}

	public SimpleSender log(String log) {
		return setLog(log);
	}

}
