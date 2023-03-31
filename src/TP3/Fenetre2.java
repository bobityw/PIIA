package TP3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Fenetre2 extends Application {
	public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle("New window");
	Group root = new Group();
	Scene scene = new Scene(root,300,200);
	Button btn = new Button("Clic");
	btn.setLayoutX(80);
	btn.setLayoutY(100);
	
	btn.setOnAction(new BoutonHandler());

	root.getChildren().add(btn);
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	class BoutonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			System.out.println("bouton click");
		}
	}
}


