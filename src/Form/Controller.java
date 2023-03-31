package Form;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Controller {
	GraphicsContext gc;
	private double cWidth;
	private double cLength;
	Model model;
	FormGeo selectedShape;

	public Controller(GraphicsContext gc, Model model) {
		this.gc = gc;
		this.setcWidth(gc.getCanvas().getWidth());
		this.setcLength(gc.getCanvas().getHeight());
		this.model = model;

		FormGeo rectangle = new Rectangle(getcWidth()/4, getcLength()/6, 50, 80);
		FormGeo oval = new Oval(getcWidth()/2, getcLength()/2, 100);
		model.addForm(rectangle);
		model.addForm(oval);	
		System.out.println("Nombre de formes: " + model.nbOfShape());
	}

	public double getcWidth() {
		return cWidth;
	}

	public void setcWidth(double cWidth) {
		this.cWidth = cWidth;
	}

	public double getcLength() {
		return cLength;
	}

	public void setcLength(double cLength) {
		this.cLength = cLength;
	}
	
	public void draw() {
		gc.clearRect(0, 0,getcWidth() , getcLength());
		for(FormGeo shape : model.getListShape()) {
				shape.draw(gc);
			}
		}
	
	public FormGeo catchShape(double x, double y) {
		for(FormGeo shape : model.getListShape()) {
			if(shape.contained(x, y)) {
				selectedShape = shape;
				gc.setStroke(Color.RED);
				System.out.println("ok");
			}
		}
		return selectedShape;
	}
	
	public void moveShape(double x, double y) {
		if(selectedShape != null) {
			selectedShape.move(x,y);
			
            draw();
		}
		
	}
	
	public void releaseShape(double x, double y) {
		gc.setStroke(Color.BLACK);
		selectedShape = null;
	}
	
	public void clear() {
		gc.clearRect(0, 0, cWidth, cLength);
		model.getListShape().clear();
	}
	
	/*Temporary code*/
	public void newRectangle(double x, double y, double xEnd, double yEnd) {
		Rectangle r = new Rectangle(x,y,xEnd,yEnd);
		model.addForm(r);
		
		draw();
	}
	
	public void newOval(double x, double y, double radius) {
        Oval oval = new Oval(x - radius, y - radius, 2 * radius);
        model.addForm(oval);
        draw();
	}
	
}
