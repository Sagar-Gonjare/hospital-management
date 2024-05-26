package org.dnyanyog.dto.response;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder({"responseCode", "responseMessage", "data", "error"})

public class AddUserResponse {
	
	private int responseCode;
	
	private String responseMsg;
	
	private AddUserData data;
	

  public int getResponseCode() {
  return responseCode;}

  public void setResponseCode(int responseCode) {
  this.responseCode = responseCode;}

  public String getResponseMsg() {
  return responseMsg;}

  public void setResponseMsg(String responseMsg) {
  this.responseMsg = responseMsg;}

  public AddUserData getData() {
  return data;}

  public void setData(AddUserData data) {
  this.data = data;}

 
	
}


