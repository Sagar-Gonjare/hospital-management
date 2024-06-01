package org.dnyanyog.users;

import java.awt.event.ActionEvent;

import org.dnyanyog.addUser.AddUser;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UsersController {

  @FXML private Button patient;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button dashboard;
  
  @FXML private Button add;

  @FXML private Button edit;

  @FXML private Button search;

  @FXML private Button delete;

  public void patient(ActionEvent event) {
     new Users().show();
  }

  public void cases(ActionEvent event) {
    // new Cases().show();
	     new Users().show();

  }

  public void appointments(ActionEvent event) {
    // new AppointmentActions().show();
	     new Users().show();


  }

  public void dashboard(ActionEvent event) {
    // new Dashboard().show();
	     new Users().show();

  }

  public void add(ActionEvent event) {
    new AddUser().show();
  }

  public void edit(ActionEvent event) {}

  public void delete(ActionEvent event) {}

  public void search(ActionEvent event) {}
}
