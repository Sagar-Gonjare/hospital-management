package org.dnyanyog.application;




import org.dnyanyog.addUser.AddUser;
import org.dnyanyog.appointments.Appointments;
import org.dnyanyog.common.StageMaster;
import org.dnyanyog.users.Users;

import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationMain extends Application {

	public static void main(String args[]) {
		launch(args);

	}

	public void start(Stage primaryStage) {
		StageMaster.setStage(primaryStage);
		new Appointments().show();
	}
}