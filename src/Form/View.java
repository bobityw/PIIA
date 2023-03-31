package Form;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class View extends Application{
	Canvas drawArea;
	Scene scene;
	GraphicsContext gc;
	Controller controller;
	Model model;
	final int SIZE = 700;
	double x,y, currentX,currentY;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Form");
		model = new Model();
		drawArea = new Canvas(SIZE,SIZE);
		gc = drawArea.getGraphicsContext2D();
		
		controller = new Controller(gc, model);
		BorderPane bp = new BorderPane();
		MenuBar menu = new MenuBar();
		Menu menu1 = new Menu("File");
		Menu menu2 = new Menu("Help");

		MenuItem menu1Item1 = new MenuItem("New");
		MenuItem menu1Item2 = new MenuItem("Exit");
		
		menu1.getItems().add(menu1Item1);
		menu1.getItems().add(menu1Item2);
		
		/*Action*/
		menu1Item1.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				controller.clear();
			}
		});
		
		menu1Item2.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				primaryStage.close();
			}
		});
		
		menu.getMenus().add(menu1);
		menu.getMenus().add(menu2);
		VBox vbox = new VBox();

		Button cursor = new Button("Cursor");
		Button move = new Button("Move shape");
		Button rect = new Button("Draw rectangle");
		Button oval = new Button("Draw oval");
		
		cursor.setLayoutX(80);
		cursor.setLayoutY(100);
		move.setLayoutX(80);
		move.setLayoutY(100);
		rect.setLayoutX(80);
		rect.setLayoutY(100);
		oval.setLayoutX(80);
		oval.setLayoutY(100);
		
		cursor.setOnAction(event -> cursorMode());
		move.setOnAction(event -> moveShape());
		rect.setOnAction(event -> drawRectangle());
		oval.setOnAction(event-> drawOval());
		
		vbox.getChildren().add(cursor);
		vbox.getChildren().add(move);
		vbox.getChildren().add(rect);
		vbox.getChildren().add(oval);
		vbox.setSpacing(10);
	    vbox.setPadding(new Insets(5, 10, 20, 10));
		vbox.setStyle("-fx-background-color:gray");
		bp.setTop(menu);
		bp.setLeft(vbox);
		bp.setCenter(drawArea);
		scene = new Scene(bp, SIZE,SIZE);
		
		controller.draw();

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void cursorMode() {
		 drawArea.setOnMousePressed(null);
		 drawArea.setOnMouseDragged(null);
		 drawArea.setOnMouseReleased(null);
	}

	public void moveShape() {
		drawArea.setOnMousePressed(e ->{
			x = e.getX();
			y = e.getY();
			controller.catchShape(x,y);
			
	        drawArea.setOnMouseReleased(null);
		});
		
		drawArea.setOnMouseDragged(e -> {
			if(isWithinBounds(x,y,e.getX(),e.getY())) {
				controller.moveShape(e.getX(), e.getY());
			}

		});
	}
	
    public void drawRectangle() {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        drawArea.setOnMousePressed(event -> {
            x = event.getX();
            y = event.getY();
        });

        drawArea.setOnMouseDragged(event -> {
            currentX = event.getX();
            currentY = event.getY();

            if(isWithinBounds(x,y,currentX,currentY)) {
                controller.draw();

                gc.strokeRect(x, y, currentX - x, currentY - y);
            }

        });

        drawArea.setOnMouseReleased(event -> {
            currentX = event.getX();
            currentY = event.getY();
            if (isWithinBounds(x, y, currentX, currentY)) {
                controller.newRectangle(x, y, currentX - x, currentY - y);
            }
        });
    }
    
    private void drawOval() {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        drawArea.setOnMousePressed(e -> {
            x = e.getX();
            y = e.getY();
        });

        drawArea.setOnMouseDragged(e -> {
            double currentX = e.getX();
            double currentY = e.getY();

            controller.draw();

            double radius = Math.sqrt(Math.pow(currentX - x, 2) + Math.pow(currentY - y, 2));
            gc.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
        });

        drawArea.setOnMouseReleased(e -> {
            double currentX = e.getX();
            double currentY = e.getY();

            double radius = Math.sqrt(Math.pow(currentX - x, 2) + Math.pow(currentY - y, 2));
            controller.newOval(x,y,radius);
        });

    }
    
    public boolean isWithinBounds(double x1, double y1, double x2, double y2) {
    	double cWidth = drawArea.getWidth();
    	double cHeight = drawArea.getHeight();
        return x1 >= 0 && y1 >= 0 && x2 <= cWidth && y2 <= cHeight;
    }
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
