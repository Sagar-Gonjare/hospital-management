package org.dnyanyog.addUser;

import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddUserController {
	 @FXML private Button patient;

	  @FXML private Button cases;

	  @FXML private Button appointments;

	  @FXML private Button dashboard;
	  

	  @FXML private Button save;

	  @FXML private Button cancel;
	  @FXML
	    private void patient(ActionEvent event) {
	        // handle the button click
	    }

	  public void cases(ActionEvent event) {
	    // new Cases().show();

	  }

	  public void appointments(ActionEvent event) {
	    // new AppointmentActions().show();

	  }

	  public void dashboard(ActionEvent event) {
	    // new Dashboard().show();
	  }

	  public void save(ActionEvent event) {
		    // new AppointmentActions().show();

		  }

		  public void cancel(ActionEvent event) {
		    // new Dashboard().show();
		  }
}
