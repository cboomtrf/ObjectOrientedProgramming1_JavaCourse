package shapes;

public class Rectangle {

	//var
	private double width;
	private double height;
	private Point leftTop;
	private String name;
	
	//no-arg
	public Rectangle() {
		this(1, 1);
	}
	
	//some-arg
	public Rectangle(double w, double h) {
		this(new Point(0.0, 0.0), w, h);
	}
	
	//all-arg
	public Rectangle(Point leftTop, double w, double h) {
		this.leftTop = leftTop; // wel van buiten ophalen
		this.width = w; //wil ik niet van buiten kunnen ophalen
		this.height = h; //wil ik niet van buiten kunnen ophalen
	}
	
	//getter width
	public double getWidth() {
		return this.width;
	}
	
	//getter height
	public double getHeight() {
		return this.height;
	}
	
	//get point a
	public Point getLeftTop() {
		return this.leftTop;
	}
	
	//setter leftTop
	public void setLeftTop(Point p) {
		this.leftTop = p;
	}
	
	//get point bottomRight
	public Point getRightBottom() {
		//tel width en height bij ltop op.
		double returnPointX = this.leftTop.getX() + this.width;
		double returnPointY = this.leftTop.getY() + this.height;
		Point bottomRight = new Point(returnPointX, returnPointY);
		return bottomRight;
	}
	
	//behavior area
	public double getArea() {
		return this.width * this.height;
	}

	//behavior point
	public boolean containsPoint(Point aPoint) {
		// punt moet EN binnen width EN binnen height liggen
		return (aPoint.getX() <= (this.leftTop.getX() + this.width) 
				&& aPoint.getY() <= (this.leftTop.getY() + this.height));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
