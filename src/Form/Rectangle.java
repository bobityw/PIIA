package Form;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FormGeo{
	private double width;
	private double length;

	public Rectangle(double xStart, double yStart, double width, double length) {
		super(xStart, yStart);
		this.setWidth(width);
		this.setHeight(length);
	}

	@Override
	public boolean contained(double x, double y) {
	    return (x >= getxStart() && x <= getxStart() + getWidth() && y >= getyStart() && y <= getyStart() + getHeight());
	}


	public double getWidth() {
		return width;
	}

	public void setWidth(double largeur) {
		this.width = largeur;
	}

	public double getHeight() {
		return length;
	}

	public void setHeight(double longueur) {
		this.length = longueur;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLUEVIOLET);
		gc.fillRect(getxStart(), getyStart(), getWidth(), getHeight());
	}
	
	public void dessiner(GraphicsContext gc, Color color) {
		gc.setFill(color);
		gc.fillRect(getxStart(), getyStart(), getWidth(), getHeight());
	}

}
