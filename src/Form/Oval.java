package Form;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends FormGeo{
	private double radius;

	public Oval(double xStart, double yStart, double rayon) {
		super(xStart, yStart);
		this.radius = rayon;
	}

	@Override
	public boolean contained(double x, double y) {
		double xCenter = this.getxStart() + radius;
		double yCenter = this.getyStart() + radius;

        double distance = Math.sqrt(Math.pow(xCenter - x, 2) + Math.pow(yCenter - y, 2));
        return (distance <= radius);
	}

	public double getRayon() {
		return radius;
	}

	public void setRayon(double rayon) {
		this.radius = rayon;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLUEVIOLET);
		gc.fillOval(getxStart(), getyStart(), 2*getRayon(),2*getRayon());
	}
}
