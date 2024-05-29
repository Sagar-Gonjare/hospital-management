package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.request.UserRequest;
import org.dnyanyog.dto.response.UserData;
import org.dnyanyog.dto.response.UserResponse;
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
public class UserServiceImpl {

  @Autowired UserResponse response;

  @Autowired UserRepo userRepo;

  @Autowired Users users;

  @Autowired EncryptionService encryptionService;

  // add user

  public ResponseEntity<UserResponse> addUser(UserRequest request) throws Exception {

    if (userRepo.findByUserName(request.getUserName()) != null) {
      UserResponse response = new UserResponse();
      response.setResponseCode(HttpStatus.CONFLICT.value());
      response.setResponseMsg("Username is already exist");
      return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    response = new UserResponse();
    response.setData(new UserData());
    //  userResponse (request.getConfirmPassword() == request.getPassword()) {
    if (userRepo.findByUserName(request.getUserName()) == null) {
      Users usersTable =
          Users.getInstance()
              .setUserName(request.getUserName())
              .seteMail(request.geteMail())
              .setMobileNumber(request.getMobileNumber())
              .setPassword(encryptionService.Encrypt(request.getPassword()))
              .setRole(request.getRole())
              .setStatus("Active");
      usersTable = userRepo.save(usersTable);

      response.setResponseCode(HttpStatus.CREATED.value());
      response.setResponseMsg("User record created successfully");

      UserData userData =
          UserData.getInstace()
              .setUserName(usersTable.getUserName())
              .setUserId(usersTable.getUserId())
              .setRole(usersTable.getRole())
              .setUserName(usersTable.getUserName())
              .setPassword(usersTable.getPassword())
              .setStatus(usersTable.getStatus());
      response.setData(userData);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  public ResponseEntity<UserResponse> updateUser(UserRequest request) throws Exception {
    Optional<Users> user = userRepo.findByUserId(request.getUserId());

    if (user.isPresent()) {

      Users updateUser = user.get();
      if (request.geteMail() != null) {
        updateUser.seteMail(request.geteMail());
      }
      if (request.getMobileNumber() != null) {
        updateUser.setMobileNumber(request.getMobileNumber());
      }
      if (request.getPassword() != null) {
        updateUser.setPassword(encryptionService.Encrypt(request.getPassword()));
      }
      if (request.getRole() != null) {
        updateUser.setRole(request.getRole());
      }
      if (request.getStatus() != null) {
        updateUser.setStatus(request.getStatus());
      }

      UserData userData =
          UserData.getInstace()
              .setUserName(updateUser.getUserName())
              .setUserId(updateUser.getUserId())
              .setRole(updateUser.getRole())
              .setUserName(updateUser.getUserName())
              .setPassword(updateUser.getPassword())
              .setStatus(updateUser.getStatus());
      userRepo.save(updateUser);

      response = new UserResponse();
      response.setResponseCode(HttpStatus.CREATED.value());
      response.setResponseMsg("User updated");
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } else {
      response = new UserResponse();
      response.setResponseCode(HttpStatus.NOT_FOUND.value());
      response.setResponseMsg("User not found");
      return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
  }
  
  public UserResponse deleteUser (Long userId) {
	  Optional <Users> user= userRepo.findByUserId(userId);
	  response= new UserResponse();
	  if (user.isPresent()) {
		  Users deletedUser= user.get();
		  deletedUser.setStatus("Inactive");
		  userRepo.saveAndFlush(deletedUser);
		  response.setResponseCode(HttpStatus.OK.value());
		  response.setResponseMsg("User marked as Inactive");
	  }else{
		  response.setResponseCode(HttpStatus.NOT_FOUND.value());
		  response.setResponseMsg("User not found");
	  }
	  return response;
  }
}
