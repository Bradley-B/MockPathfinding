

public class Figure {
	
	private double xPos = 0;
	private double yPos = 0;
	private double rotation = 0; // in radians
	private int distanceTraveled = 0;
	
	public Figure(int xStart, int yStart) {
		xPos = xStart;
		yPos = yStart;
		rotation = Math.PI/2; //facing "up"
	}
	
	public void move(int deltaDistance) {
		double rotation = this.rotation;
		xPos-=deltaDistance*Math.cos(rotation);
		yPos-=deltaDistance*Math.sin(rotation);
		distanceTraveled+=deltaDistance;
	}
	
	public void rotate(double radians) {
		rotation+=radians;
	}
	
	public double getDistanceTravelled() {
		return distanceTraveled;
	}
	
	public double getRotation() {
		return rotation;
	}
	
	public double getX() {
		return xPos;
	}
	
	public double getY() {
		return yPos;
	}
}
