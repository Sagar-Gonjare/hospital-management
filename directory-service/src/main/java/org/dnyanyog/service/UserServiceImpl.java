package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.request.AddUserRequest;
import org.dnyanyog.dto.response.AddUserData;
import org.dnyanyog.dto.response.AddUserResponse;
import org.dnyanyog.encryption.EncryptionService;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class UserServiceImpl implements UserService {

  @Autowired AddUserResponse addUserResponse;

  @Autowired UserRepo userRepo;

  @Autowired Users users;

  @Autowired EncryptionService encryptionService;

  // add user

  public ResponseEntity<AddUserResponse> addUser(AddUserRequest request) throws Exception {

    if (userRepo.findByUserName(request.getUserName()) != null) {
      AddUserResponse response = new AddUserResponse();
      response.setResponseCode(HttpStatus.CONFLICT.value());
      response.setResponseMsg("Username is already exist");
      return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    //		addUserResponse=new AddUserResponse();
    //		addUserResponse.setData(new AddUserData());
    if (request.getConfirmPassword() == request.getPassword()) {
      Users usersTable =
          Users.getInstance()
              .setUserName(request.getUserName())
              .seteMail(request.geteMail())
              .setMobileNumber(request.getMobileNumber())
              .setPassword(encryptionService.Encrypt(request.getPassword()))
              .setRole(request.getRole())
              .setStatus("Active");
      users = userRepo.saveAndFlush(users);

      addUserResponse.setResponseCode(HttpStatus.CREATED.value());
      addUserResponse.setResponseMsg("User record created successfully");
      addUserResponse.getData().setUserName(users.getUserName());
      addUserResponse.getData().setUserId(request.getUserId());
      addUserResponse.getData().setUserName(users.getUserName());
      addUserResponse.getData().setPassword(users.getPassword());
      addUserResponse.getData().setStatus(users.getStatus());
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(addUserResponse);
  }
}
