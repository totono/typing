package typing.controller;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import typing.Main;
import typing.utils.DBUtils;
import typing.utils.PasswordEncryption;

public class SignupController {
  @FXML
  private TextField register_username;
  @FXML
  private TextField register_password;
  @FXML
  private TextField register_fav_food1;
  @FXML
  private TextField register_fav_food2;
  @FXML
  private TextField register_fav_food3;

  @FXML
  private Button button_register;
  @FXML
  private Button button_back;

  @FXML
  private Label signup_status;

  public void backToMain(){
    Main m = new Main();
    m.changeScene("login.fxml","Login");
  }

  public void userSignup() {
    DBUtils.userRegister(register_username.getText(),PasswordEncryption.encryption(register_password.getText()));
    }

}
