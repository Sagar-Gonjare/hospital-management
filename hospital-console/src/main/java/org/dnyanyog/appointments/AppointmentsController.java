package org.dnyanyog.appointments;

import java.awt.event.ActionEvent;

import org.dnyanyog.addUser.AddUser;
import org.dnyanyog.users.Users;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AppointmentsController {

	  @FXML private Button patient;

	  @FXML private Button cases;

	  @FXML private Button appointments;

	  @FXML private Button dashboard;
	  
	  @FXML private Button add;

	  @FXML private Button edit;

	  @FXML private Button search;

	  @FXML private Button delete;
	  @FXML
	  public void patient(ActionEvent event) {
	  }
	  @FXML
	  public void cases(ActionEvent event) {
	

	  }
	  @FXML
	  public void users(ActionEvent event) {
	    
	  }
	  @FXML
	  public void dashboard(ActionEvent event) {
	   

	  }
	  @FXML
	  public void add(ActionEvent event) {
	    new AddUser().show();
	  }

	  public void edit(ActionEvent event) {}

	  public void delete(ActionEvent event) {}

	  public void search(ActionEvent event) {}
	
}
