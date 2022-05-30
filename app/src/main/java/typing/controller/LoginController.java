package typing.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import typing.Main;
import typing.utils.DBUtils;


public class LoginController {
	
	@FXML
	private Button button_login;
	@FXML
	private Hyperlink button_signup;
	@FXML
	private Button button_offlinemode;
	
	@FXML
	private TextField input_username;
	@FXML
	private TextField input_password;
	
	@FXML
	private Label login_status;

	public void UserClickedSignup(){
		Main m = new Main();
		m.changeScene("signup.fxml","Sign Up");
	};
	
	public void userClickedOfflineMode() {}
	
	public void userLogin(ActionEvent event) throws IOException{
			if(DBUtils.isCorrectCred(input_username.getText(), input_password.getText())) {
				login_status.setText("Login success!");
			} else {
				login_status.setText("Wrong username or password");
			}
	}

}
