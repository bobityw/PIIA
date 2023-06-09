package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Test extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("BorderPane Test");
    BorderPane bp = new BorderPane();
    bp.setPadding(new Insets(10, 20, 10, 20));

    Button btnTop = new Button("Top");
    bp.setTop(btnTop);

    Button btnLeft = new Button("Left");
    bp.setLeft(btnLeft);

    Button btnCenter = new Button("Center");
    bp.setCenter(btnCenter);

    Button btnRight = new Button("Right");
    bp.setRight(btnRight);

    Button btnBottom = new Button("Bottom");
    bp.setBottom(btnBottom);

    Scene scene = new Scene(bp, 300, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

   