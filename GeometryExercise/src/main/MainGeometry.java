/** 
 * @author Carina Boom (MIW 10 - studentnumber 500793324)
 */
package main;

import shapes.*;
import java.util.Scanner;

public class MainGeometry {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//give details of defined rectangles.
		//testRectangles();
		
		//give details of defined circles.
		//testCircles();
		
		//find a defined array of points in a defined circle.
		//testObjectArray();
		
		//find a user-entered point in a defined circle or rectangle.
		testPointInObject();
		
		//close scanner
		input.close();
	}
	
	public static void testObjectArray() {
		//nieuwe cirkel for testing points array.
		Point coord = new Point(3.2, 8.5);
		Circle myTestCircle = new Circle(coord, 5.8);
		//create array of objects.
		Point[] listOfPoints = initializeListOfPoints();
		//Point newPoint = listOfPoints[1]; geeft GARBAGE FOR COLLECTION.
		
		//for loop to check if point in array is in the circle.
		for (int i = 0; i < listOfPoints.length; i++) {
			System.out.println("Punt " + (i+1) + " ligt in de cirkel: " + myTestCircle.containsPoint(listOfPoints[i]));
		}
		System.out.println();
		//alternative to do the same except the listnumber.
		for (Point p : listOfPoints) {
			System.out.println("Het punt ligt in de cirkel: " + myTestCircle.containsPoint(p));
		}
	}
	
	public static Point[] initializeListOfPoints() {
		Point[] listOfPoints = new Point[4];
		listOfPoints[0] = new Point(4,1);
		listOfPoints[1] = new Point(6,7);
		listOfPoints[2] = listOfPoints[0];
		listOfPoints[3] = new Point(5,8); //VERGEET NIET ARRAYOBJECT AAN TE MAKEN. null pointer exception.
		return listOfPoints;
	}
	
	public static void testPointInObject() {
		//point & queried circle/rectangle creation.
		Point coord = new Point(3.2, 8.5);
		Circle myFunnyCircle = new Circle(coord, 5.8);
		myFunnyCircle.setName("myFunnyCircle");
		Rectangle myFunnyRectangle = new Rectangle(coord, 1.5, 2.5);
		myFunnyRectangle.setName("myFunnyRectangle");
		Point coord2 = myFunnyRectangle.getRightBottom();

		System.out.println("The area of " + myFunnyCircle.getName() + " is " + myFunnyCircle.getArea() + 
				" and the center point is " + coord.getX() + " - " + coord.getY());
		//distance to center circle containsPoint
		System.out.print("Enter a coordinate to check if it is inside the circle MyFunnyCircle: ");
		double inputX = input.nextDouble();
		double inputY = input.nextDouble();
		Point inputPoint = new Point(inputX, inputY);
		System.out.println("Your entered coordinate is: " + myFunnyCircle.containsPoint(inputPoint));
		
		System.out.println("");
		
		System.out.println("The area of " + myFunnyRectangle.getName() + " is " + myFunnyRectangle.getArea() + ".\n"
				+ "The left top point is " + coord.getX() + " - " + coord.getY() 
				+ " and the right bottom point is " + coord2.getX() + " - " + coord2.getY() + ".");
		//distance to leftTop rectangle containsPoint
		System.out.print("Enter a coordinate to check if it is inside the rectangle myFunnyRectangle: ");
		inputX = input.nextDouble();
		inputY = input.nextDouble();
		Point inputRectPoint = new Point(inputX, inputY);
		System.out.println("Your entered coordinate is: " + myFunnyRectangle.containsPoint(inputRectPoint));	
	}
	
	public static void testRectangles() {

		System.out.println("Test Rectangle object: ");
		Point leftTopRect = new Point(0.1, 0.1);
		Rectangle myRectangle0 = new Rectangle(leftTopRect, 5.0, 5.0);
		System.out.println("The area of " + myRectangle0 + " is " + myRectangle0.getArea());
		System.out.println();

		System.out.print("Give width and height of a new rectangle: ");
		double width = input.nextDouble();
		double height = input.nextDouble();
		Rectangle inputRectangle = new Rectangle(width,height);

		System.out.println("The area of " + inputRectangle + " is " + inputRectangle.getArea());

	}

	public static void testCircles() {
		
		Circle myCircle0 = new Circle();
		Circle myCircle1 = new Circle(5);

		Point myFunnyCenter = new Point(3.2, 8.5);
		Circle myCircle2 = new Circle(myFunnyCenter, 5.8);
		System.out.println("Test Circle objects: ");
		System.out.println("The area of " + myCircle0 + " is " + myCircle0.getArea());

		System.out.println("The area of " + myCircle1 + " is " + myCircle1.getArea());

		System.out.println("The area of " + myCircle2 + " is " + myCircle2.getArea());
		System.out.println();

		System.out.print("Give a radius of a new circle: ");
		double radius = input.nextDouble();
		Circle inputCircle = new Circle(radius);

		System.out.println("The area of " + inputCircle + " is " + inputCircle.getArea());
		
	}
}
