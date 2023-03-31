package TP5;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Paint1 extends Application {
	
	Canvas drawArea ;
	Scene scene;
	GraphicsContext gc;
	double xStart;
	double yStart;
	double xEnd;
	double yEnd;
	Line line;
    ArrayList<Line> lines =  new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Drawing app");

		drawArea = new Canvas(600,600);

		gc= drawArea.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0,0,drawArea.getWidth(),drawArea.getHeight());
		
		BorderPane pane = new BorderPane();
		pane.setCenter(drawArea);
		
		scene = new Scene(pane, 600, 600);
		
		drawArea.setOnMousePressed(e->mousePressed(e));
		drawArea.setOnMouseReleased(e->mouseReleased(e));
		drawArea.setOnMouseDragged(e->mouseDragged(e));
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	void mousePressed(MouseEvent e) {
		xStart = e.getX();
		yStart = e.getY();
        line = new Line(xStart, yStart,xEnd, yEnd);
	}
	
	void mouseDragged(MouseEvent e) {
		xEnd = e.getX();
		yEnd = e.getY();
		
		draw();
	}
	
	void mouseReleased(MouseEvent e) {
		gc.setStroke(Color.BLACK);
        gc.strokeLine(xStart, yStart,xEnd, yEnd);
        lines.add(line);
	}
	
	public void draw() {
		gc.clearRect(0,0, drawArea.getWidth(), drawArea.getHeight());
		gc.setStroke(Color.BLUE);
        gc.strokeLine(xStart, yStart,xEnd, yEnd);
	}

}