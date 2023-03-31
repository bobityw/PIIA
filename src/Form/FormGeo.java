package Form;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class FormGeo {
	private double xStart;
	private double yStart;
	
	public FormGeo(double xStart, double yStart) {
		this.xStart = xStart;
		this.yStart = yStart;
	}
	public double getxStart() {
		return xStart;
	}
	public void setxStart(double xStart) {
		this.xStart = xStart;
	}
	public double getyStart() {
		return yStart;
	}
	
	public void move(double x, double y) {
		this.xStart = x;
		this.yStart = y;
	}
	
	public void setyStart(double yStart) {
		this.yStart = yStart;
	}
	
	public void setStrokeColor(GraphicsContext gc, Color color) {
		gc.setStroke(color);
		gc.setLineWidth(2.0);
	}
	
	public abstract boolean contained(double x, double y);
	
	public abstract void draw(GraphicsContext gc);
	
}
