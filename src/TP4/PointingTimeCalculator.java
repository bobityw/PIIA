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

public class PointingTimeCalculator extends Application {
    
    private Point2D start;
    private Point2D end;
    private Circle startCircle;
    private Circle endCircle;
    private Rectangle rect;
    private Group group;
    
    @Override
    public void start(Stage primaryStage) {
        
        // Create start and end circles
        startCircle = new Circle(50, 50, 10, Color.GREEN);
        endCircle = new Circle(200, 200, 10, Color.RED);
        
        // Create rectangle
        rect = new Rectangle(0, 0, 100, 100);
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(2);
        
        // Create group and add shapes
        group = new Group();
        group.getChildren().addAll(rect, startCircle, endCircle);
        
        // Add mouse events to calculate pointing time
        group.setOnMousePressed(this::handleMousePressed);
        group.setOnMouseDragged(this::handleMouseDragged);
        group.setOnMouseReleased(this::handleMouseReleased);
        
        // Create scene and add group
        Scene scene = new Scene(group, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void handleMousePressed(MouseEvent event) {
        // Set start point to mouse click position
        start = new Point2D(event.getX(), event.getY());
    }
    
    private void handleMouseDragged(MouseEvent event) {
        // Update end point to mouse drag position
        end = new Point2D(event.getX(), event.getY());
        
        // Update rectangle dimensions
        double minX = Math.min(start.getX(), end.getX());
        double minY = Math.min(start.getY(), end.getY());
        double width = Math.abs(start.getX() - end.getX());
        double height = Math.abs(start.getY() - end.getY());
        rect.setX(minX);
        rect.setY(minY);
        rect.setWidth(width);
        rect.setHeight(height);
    }
    
    private void handleMouseReleased(MouseEvent event) {
        // Calculate pointing time and print to console
        long pointingTime = System.currentTimeMillis();
        Point2D target = new Point2D(endCircle.getCenterX(), endCircle.getCenterY());
        double distance = start.distance(target);
        System.out.println("Pointing time: " + (System.currentTimeMillis() - pointingTime) + " ms");
        System.out.println("Distance: " + distance + " pixels");
    }
    
    public static void main(String[] args) {
       Application.launch(args);
    }
}
