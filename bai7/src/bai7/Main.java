package bai7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static Stage rootStage; //Dùng để chuyển scene

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("studentList/studentList.fxml"));

        rootStage.setTitle("bai7");
        rootStage.setScene(new Scene(root, 400, 600));
        rootStage.show();
    }

}