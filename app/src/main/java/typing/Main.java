package typing;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Stage stg;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stg = primaryStage;
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Login");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	//シーンかえるやつ。いずれSceneControllerクラスを作ってそこにまとめたい
	public void changeScene(String fxml, String title) {
		try {
			BorderPane pane = (BorderPane)FXMLLoader.load(getClass().getResource(fxml));
			stg.setTitle(title);
			stg.getScene().setRoot(pane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args) {
		launch(args);
	}
}
