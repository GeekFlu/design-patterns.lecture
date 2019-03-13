package mx.com.geekflu.design.pattern.factory;

public class Factory {
	
	public static void main(String[] args) {
		Point cp = Point.Factory.newCartesianPoint(5, 6);
		Point pp = Point.Factory.newPolarPoint(34.5, 23.5);
		
		System.out.println("cp : " + cp);
		System.out.println("pp : " + pp);
	}

}

class Point {
	private double x, y;

	private Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	public static class Factory{
		
		public static Point newCartesianPoint(double x, double y) {
			return new Point(x, y);
		}
		
		public static Point newPolarPoint(double rho, double theta) {
			return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
		}
	}


	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

