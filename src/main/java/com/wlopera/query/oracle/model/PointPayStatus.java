package com.wlopera.query.oracle.model;

import java.io.Serializable;

import com.google.gson.JsonObject;

@SuppressWarnings("serial")
public class PointPayStatus implements Serializable {

	private String trabsferId;
	private String paymentId;
	private JsonObject request;
	private JsonObject response;
	private JsonObject requestPP;
	private JsonObject responsePP;
	private JsonObject requestPPJob;
	private JsonObject responsePPJob;
	private String nextDate;
	private String nextTime;
	private String status;
	private String description;
	private String insertUserId;
	private String insertDateId;
	private String iupdateUserId;
	private String updateDateId;

	public String getTrabsferId() {
		return trabsferId;
	}

	public void setTrabsferId(String trabsferId) {
		this.trabsferId = trabsferId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public JsonObject getRequest() {
		return request;
	}

	public void setRequest(JsonObject request) {
		this.request = request;
	}

	public JsonObject getResponse() {
		return response;
	}

	public void setResponse(JsonObject response) {
		this.response = response;
	}

	public JsonObject getRequestPP() {
		return requestPP;
	}

	public void setRequestPP(JsonObject requestPP) {
		this.requestPP = requestPP;
	}

	public JsonObject getResponsePP() {
		return responsePP;
	}

	public void setResponsePP(JsonObject responsePP) {
		this.responsePP = responsePP;
	}

	public JsonObject getRequestPPJob() {
		return requestPPJob;
	}

	public void setRequestPPJob(JsonObject requestPPJob) {
		this.requestPPJob = requestPPJob;
	}

	public JsonObject getResponsePPJob() {
		return responsePPJob;
	}

	public void setResponsePPJob(JsonObject responsePPJob) {
		this.responsePPJob = responsePPJob;
	}

	public String getNextDate() {
		return nextDate;
	}

	public void setNextDate(String nextDate) {
		this.nextDate = nextDate;
	}

	public String getNextTime() {
		return nextTime;
	}

	public void setNextTime(String nextTime) {
		this.nextTime = nextTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(String insertUserId) {
		this.insertUserId = insertUserId;
	}

	public String getInsertDateId() {
		return insertDateId;
	}

	public void setInsertDateId(String insertDateId) {
		this.insertDateId = insertDateId;
	}

	public String getIupdateUserId() {
		return iupdateUserId;
	}

	public void setIupdateUserId(String iupdateUserId) {
		this.iupdateUserId = iupdateUserId;
	}

	public String getUpdateDateId() {
		return updateDateId;
	}

	public void setUpdateDateId(String updateDateId) {
		this.updateDateId = updateDateId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PointPayStatus [trabsferId=");
		builder.append(trabsferId);
		builder.append(", paymentId=");
		builder.append(paymentId);
		builder.append(", request=");
		builder.append(request);
		builder.append(", response=");
		builder.append(response);
		builder.append(", requestPP=");
		builder.append(requestPP);
		builder.append(", responsePP=");
		builder.append(responsePP);
		builder.append(", requestPPJob=");
		builder.append(requestPPJob);
		builder.append(", responsePPJob=");
		builder.append(responsePPJob);
		builder.append(", nextDate=");
		builder.append(nextDate);
		builder.append(", nextTime=");
		builder.append(nextTime);
		builder.append(", status=");
		builder.append(status);
		builder.append(", description=");
		builder.append(description);
		builder.append(", insertUserId=");
		builder.append(insertUserId);
		builder.append(", insertDateId=");
		builder.append(insertDateId);
		builder.append(", iupdateUserId=");
		builder.append(iupdateUserId);
		builder.append(", updateDateId=");
		builder.append(updateDateId);
		builder.append("]");
		return builder.toString();
	}

}
