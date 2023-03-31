package TP4;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.time.Instant;
import java.time.Duration;
import java.util.Random;

public class CalculPointageForme extends Application {

    private Instant startTime;
    private Point2D start;
    private Point2D end;
    private Circle targetCircle;
    private Rectangle rect;
    private Group group;
    private Random rand = new Random();

    @Override
    public void start(Stage primaryStage) {

        // Create rectangle
        rect = new Rectangle(rand.nextInt(200), rand.nextInt(200), 10, 10);
        rect.setFill(Color.BLUEVIOLET);

        // Create group and add shapes
        group = new Group();
        group.getChildren().add(rect);

        // Create 5 target circles
        for (int i = 0; i < 5; i++) {
            Circle circle = new Circle(rand.nextInt(200) + 50, rand.nextInt(200) + 50, 10, Color.RED);
            group.getChildren().add(circle);
        }

        // Add mouse events to calculate pointing time
        rect.setOnMousePressed(this::handleMousePressed);
        group.setOnMouseDragged(this::handleMouseDragged);
        group.setOnMouseReleased(this::handleMouseReleased);

        // Create scene and add group
        Scene scene = new Scene(group, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMousePressed(MouseEvent event) {
        // Set start point and time to mouse click position
        start = new Point2D(event.getX(), event.getY());
        startTime = Instant.now();
    }

    private void handleMouseDragged(MouseEvent event) {
        // Update end point to mouse drag position
        end = new Point2D(event.getX(), event.getY());
    }

    private void handleMouseReleased(MouseEvent event) {
        // Calculate pointing time and print to console
        Instant endTime = Instant.now();
        Duration pointingTime = Duration.between(startTime, endTime);
        System.out.println("Pointing time: " + pointingTime.toMillis() + " ms");
    }
    public static void main(String[] args) {
        launch(args);
    }
}