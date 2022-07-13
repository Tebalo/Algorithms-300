import java.lang.Math;

/**
*Filename: CSI323Point.java
*@author Bopaki Tebalo
*@author Wapa Omogolo Edzani
*@version 0.1
*Description:The{@code CSI323Point} class represents a x and y coordinates in a graph.
*It supports calculation between points and has getter methods to return x and y coordinates of a
*point.
*/
public class CSI323Point{
	double x;
    double y;
    /**
    *@param x coordinate of the point
    *@param y coordinate of the point
    *Description: Takes in the x and y coordinate to create a point.
    */
	public CSI323Point(double x,double y){
		this.x = x;
		this.y = y;
	}
	/**
	*@return x coordinate of the point.
	*/
	public double x(){
		return x;
	}
	/**
	*@return y coordinate of the point.
	*/
	public double y(){
		return y;
	}
	/**
	*@param otherPoint to calculate distance from to this point.
	*@return distance: The eucledian distance between this
	*point and the given point, otherPoint. 
	*/
	public double distTo(CSI323Point otherPoint){
        double distance;
        
        //extract the x and y coordinate from otherPoint.
        double x2 = otherPoint.x();
        double y2 = otherPoint.y();
        //extract the x and y coordinates from this point.
        double x1 = this.x();
        double y1 = this.y();
        //find the difference between x coordinates and of y coordinates from this point and the otherPoint.
        double hDist = (x2-x1);
        double vDist = (y2-y1);
        //calculate that difference to the power of 2.
        double hSquare = Math.pow(hDist,2);
        double vSquare = Math.pow(vDist,2);
        //add the 2.					
        double hPlusV = hSquare + vSquare;
        //find the square Root.
        distance = Math.sqrt(hPlusV);
		return distance;
	}
	/**
	*@return String representing a point in the form
    *“(2.0, 12.0)”.
    */
	public String toString(){
		return String.format("%.2f",this.x())+","+
       String.format("%.2f",this.y());
	}
}