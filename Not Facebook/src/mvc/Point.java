package mvc;
//added for clock
public class Point {
	private double xc = 0, yc = 0;
	public Point(double xc, double yc) {
		this.xc = xc;
		this.yc = yc;
	}

	public double getXc() { return xc; }
	public double getYc() { return yc; }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(xc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(yc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(xc) != Double.doubleToLongBits(other.xc))
			return false;
		if (Double.doubleToLongBits(yc) != Double.doubleToLongBits(other.yc))
			return false;
		return true;
	}

	// map this from CRT coordinates to canvas coordinates
	public Point transform(int canvasSize) {
		return new Point(canvasSize / 2 * this.xc + canvasSize / 2, canvasSize/2 - canvasSize/2 * this.yc);
	}
}