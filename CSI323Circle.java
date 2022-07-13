/**
*Filename:CSI323Circle.java
*@author Bopaki Tebalo.
*@author Wapa Omogolo Edzani.
*Description:The{@code CSI323Circle} class represents a centre and a radius of a circle.
*It supports calculation of intersection between two circles and has getter methods to 
*return the centre and radius of a
*circle.
*/
public class CSI323Circle{
   //declare CSI323Point for the centre and double for radius of the circle
	 CSI323Point centre;
	 double radius;
    /**
    *@param centre, the x and y coordinate that makes the central point of the circle.
    *@param radius the distance to the circumference.
    *
    */
  	public CSI323Circle(CSI323Point centre, double radius){
		   this.centre = new CSI323Point(centre.x(),centre.y());
		   this.radius = radius;
	  } 
    /**
    *@return centre of the circle(x and y coordinate)
    */
    public CSI323Point centre(){ return centre;}

    /**
    *@return radius of the circle.
    */
    public double radius(){return radius;}

    /**
    *@return true, if this circle intersect with the given,
    *otherCircle. Note that it does not matter whether it is
    *one point(just touching) or two. We do not care about 
    *the intersection points, only whether they intersect at 
    *all.
    */
    public boolean intersect(CSI323Circle otherCircle){
       
       double distance = this.centre.distTo(otherCircle.centre());//calcalate the distance between this circle centre and the other circle centre.
       double twoRad = otherCircle.radius() + this.radius();//Find the sum of the 2 circle radii.

       return distance <= twoRad;
    }

    /**
    *@return String representing a circle in the form
    *“[(2.0, 12.0), 3.45]”. (2.0, 12.0) is the centre and 
    *3.45 is the radius.
    */
    public String toString(){
       return "["+"("+String.format("%.2f",centre.x())+","+
       String.format("%.2f",centre.y())+","+String.format("%.2f",radius())+
       ")"+"]"+".";
    }
}

