package application;
    
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
 
public class Main extends Application {
	
	
    @Override
    public void start(Stage primaryStage) {
        try {
        	primaryStage.setTitle("버스 좌석 예매 프로그램");
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Main.fxml"));
        	
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
           
            MainController maincontroller = loader.getController();
            maincontroller.SetStage(primaryStage);
            
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();	//���� ó�� 
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
