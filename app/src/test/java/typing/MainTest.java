package typing;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;

import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.api.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import typing.utils.DBUtils;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;


public class MainTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root,600,400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Before
    public void setUp() throws Exception{}

    @After
    public void tearDown() throws Exception{
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void action_input_correct_cred() {

        clickOn("#input_username").write("test");
        clickOn("#input_password").write("12345");
        clickOn("#button_login");

        FxAssert.verifyThat("#login_status", LabeledMatchers.hasText("Login success!"));
    }
       
    @Test
    public void action_input_wrong_cred() {
        clickOn("#input_username").write("test");
        clickOn("#input_password").write("00000");
        clickOn("#button_login");

        FxAssert.verifyThat("#login_status", LabeledMatchers.hasText("Wrong username or password"));

    }

    @Test
    public void action_moveto_signup(){
        clickOn("#button_signup");
        FxAssert.verifyThat(window("Sign Up"), WindowMatchers.isShowing());
    }

    @Test
    public void action_can_signup() {
        Random rand = new Random();
        String s = String.valueOf(rand.nextInt(10000));

        clickOn("#button_signup");
        clickOn("#register_username").write(s);
        clickOn("#register_password").write(s);
        clickOn("#button_register");
        assertEquals(true,DBUtils.isUserExists(s));

    }


}