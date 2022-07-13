import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import edu.princeton.cs.algs4.Point2D;
/**
*Filename: CSig.java
*@author Bopaki Tebalo
*@author Wapa Omogolo Edzani
*@version 0.1
*Descripton:
*
*
*/
public class CSig{
  
  /**
  *Default constructor
  */
  public CSig(){

  }
	/**
	*Description: Returns the index of the closest
	*(in terms of distance) point to the point at 
	*index pos.
	*@param points
	*@param pos 
	*@return closestPoint
	*/
	public static int closestPoint(ABag<CSI323Point> points, int pos){

	  CSI323Point point = points.get(pos);
	  double closestDis = point.distTo(points.get(0));
	  int position = 0;
    int index = 0;
      for(CSI323Point p : points){
         
          if(point.distTo(p) < closestDis && p != points.get(pos)){
          	 closestDis = point.distTo(p);
          	 index = position;

          }

          position++;
      }
      return index;
	}
    /**
    *Description: Returns a Bag object of circles.
    *For each point p in the given points, find 
    *its closest points, then create a circle with 
    *centre p and radius equal to the distance between
    *p and q,its closest point.
    *@param points
    *@return circles....
    */
	public static ABag<CSI323Circle> circles(ABag<CSI323Point> points){
    
       int p = 0;
       ABag<CSI323Circle> circles = new ABag<CSI323Circle>();
       for(CSI323Point p1 : points){
           double radius = p1.distTo(points.get(closestPoint(points,p)));
       	   circles.addFront(new CSI323Circle(p1, radius));
           p++;
       }
       return circles;
	}
  /**
  *Description: Draws a grid of size NxN and lins at intervals
  *efined by step.
  *Sample program shows how to do this.
  *@param N
  *@param step
  */
	public static void drawGrid(int N, int step){

      StdDraw.setScale(0, +N); // size of grid
      StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE); // color of the drawing pen

      for(int r = step; r < N; r+=step)
        StdDraw.line(r, 0, r, N-1);
      for(int r = step; r < N; r+=step)
        StdDraw.line(0, r, N-1, r); 
  }
  /**
  *Description:
  *@param points
  *
  *
  */
  public static void plotPoints(ABag<CSI323Point> points){
    StdDraw.setPenRadius(0.012);  // set pen radius thickness
    StdDraw.setPenColor(StdDraw.BLACK); // set pen color

    //Use an Iterator to iterate/traverse the bag.
    Iterator<CSI323Point> it = points.iterator();
    while(it.hasNext()){
      CSI323Point man = it.next();
      Point2D pt1 = new Point2D(man.x(),man.y());
      pt1.draw();
    }
    
  }
  /**
  *@param circles
  *Description: Draw circles.
  *
  */
  public static void drawCircles(ABag<CSI323Circle> circles){
   // Draw a circle at pt1 with radius equal to the distance to pt3
      StdDraw.setPenRadius(0.0005);
      StdDraw.setPenColor(StdDraw.RED);  

       //Use an Iterator to iterate/traverse the bag.
  Iterator<CSI323Circle> circle = circles.iterator();

      while(circle.hasNext()){
      CSI323Point pt1 = circle.next().centre();
      double radius = circle.next().radius();
      StdDraw.circle(pt1.x(),pt1.y(),radius);
    }   
  }
  /**
  *@param circles
  *Draw a line between centres of two pairs of circles that intersect
  *and returns the number of lines drawn
  */
  public static int drawLines(ABag<CSI323Circle> circles){

    // Draw a line between  pt2 and pt3
    StdDraw.setPenRadius(0.0025);
    StdDraw.setPenColor(StdDraw.BLUE);

    //Iterator<CSI323Circle> circle1 = circles.iterator();
    //Iterator<CSI323Circle> circle2 = circles.iterator();
    int count = 0;
    CSI323Point point;
    CSI323Point nextPoint;
    for(CSI323Circle circle1 : circles){

      for(CSI323Circle circle2 : circles){
    //while(circle1.hasNext()){
       //while(circle2.hasNext()){
         if(circle1.intersect(circle2)){
         point = circle1.centre();
         nextPoint = circle2.centre();
         StdDraw.line(point.x(),point.y(),nextPoint.x(),nextPoint.y());
         count++;
       }
     }
    }
    //StdOut.print(count/2);
    return count/2;
  }
  /**
  *Clear the file.
  */
  public void clear(){
    StdDraw.clear();
  }
  /**
  *Unit tests the <tt>CSig</tt> data type
  *
  */
  public static void main(String[] args){
    ABag<CSI323Point> bag = new ABag<CSI323Point>();
    while(!StdIn.isEmpty()){
      CSI323Point item = new CSI323Point(StdIn.readDouble(), StdIn.readDouble());
      bag.addFront(item);
     }
     drawGrid(1000, 20);

     plotPoints(bag);
     
     drawCircles(circles(bag));
     
     drawLines(circles(bag));

    }
}


 
