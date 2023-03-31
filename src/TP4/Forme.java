package TP4;

import java.time.Instant;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Forme extends Application {
	private double x;
	private double y;
	long last_time=Instant.now().toEpochMilli();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Forme");
		Group forms = new Group();

		for(int i=0; i < 3; i++) {
			float x = (float)(Math.random()*300);
			float y = (float)(Math.random()*300);
			Circle circle = new Circle();
			circle.setCenterX(x); 
			circle.setCenterY(y); 
			circle.setRadius(10.0f); 
			circle.setFill(Color.RED);
			forms.getChildren().add(circle);
		}
		
		for(int i=0; i <= 3; i++) {
			float x = (float)(Math.random()*400);
			float y = (float)(Math.random()*400);
			Rectangle rectangle = new Rectangle();
			rectangle.setX(x); 
			rectangle.setY(y); 
			rectangle.setWidth(10); 
			rectangle.setHeight(10);
			rectangle.setFill(Color.BLUEVIOLET);
			forms.getChildren().add(rectangle);
		}
		
		Group root = new Group();
		
		Scene scene = new Scene(root, 500, 500);
		scene.setFill(Color.web("#EBD4FF"));

		
		root.getChildren().add(forms);
		scene.setOnMousePressed(event -> afficheTemps());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
    void afficheTemps() {
		System.out.println("Response time: "+ (Instant.now().toEpochMilli() - last_time));
		last_time = Instant.now().toEpochMilli();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
