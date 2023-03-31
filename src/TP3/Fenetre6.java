package TP3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Fenetre6 extends Application {
	public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle("New window");
	Group root = new Group();
	Scene scene = new Scene(root,300,200);
	Button btn1 = new Button("Clic");
	Button btn2 = new Button("Clic");
	btn1.setLayoutX(80);
	btn1.setLayoutY(100);
	btn2.setLayoutX(80);
	btn2.setLayoutY(100);
	
	btn1.setOnAction(event -> System.out.print("bouton click"));
	btn2.setOnAction(event -> System.out.print("click again"));
	root.getChildren().add(btn1);
	root.getChildren().add(btn2);
	primaryStage.setScene(scene);
	primaryStage.show();
	}
}


