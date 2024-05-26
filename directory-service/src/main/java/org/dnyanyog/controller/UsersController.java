package org.dnyanyog.controller;

import org.dnyanyog.dto.request.AddUserRequest;
import org.dnyanyog.dto.response.AddUserResponse;
import org.dnyanyog.service.UserService;
import org.dnyanyog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping (path="api/directory/v1/addUser", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<AddUserResponse> addUser(@RequestBody  AddUserRequest request) throws Exception{
		
	ResponseEntity<AddUserResponse> response =userServiceImpl.addUser(request);
	return response;
	}
}
