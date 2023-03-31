package TP4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GridLayoutExemple1 extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("un test");
		
		Label label1 = new Label("Bonjour!!");
		Label label2 = new Label("Comment allez-vous?");
		Label label3 = new Label("Enchant�!!");
		/*
		GridPane grid = new GridPane();
		
		grid.add(label1, 0, 0);
		grid.add(label2, 1, 0);
		grid.add(label3, 0, 1, 2, 1);
		
		grid.setPrefSize(300, 300);
		grid.setAlignment(Pos.CENTER);
		grid.setMargin(label1,new Insets(20, 20, 20, 20));
		*/
		HBox hbox = new HBox();
		hbox.getChildren().add(label1);
		hbox.getChildren().add(label3);
		hbox.setPrefWidth(150);
		hbox.setAlignment(Pos.TOP_RIGHT);
		hbox.setPadding(new Insets(30,30,30,30));
		
		
		VBox vbox = new VBox(); // ou directement new VBox(hbox, label2);
		vbox.setPrefSize(300, 300);
		vbox.setPadding(new Insets(20,20,20,20));
		vbox.setSpacing(15);
		vbox.getChildren().add(hbox);
		vbox.getChildren().add(label2);
		// VBox sous une seule colonne
		// HBox sous une seule ligne
		

		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);

		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
