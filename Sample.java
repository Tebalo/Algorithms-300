	import edu.princeton.cs.algs4.StdDraw;
	import edu.princeton.cs.algs4.StdRandom;
	import edu.princeton.cs.algs4.Point2D;


	public class Sample {

	  public static void main(String[] args) {

	    StdDraw.setScale(0, +100); // size of grid
	   
	    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE); // color of the drawing pen

	    // draw a grid of size 100x100, and lines at step interval of 10
	    for(int r = 10; r < 100; r+=10)
	      StdDraw.line(r, 0, r, 99);
	    for(int r = 10; r < 100; r+=10)
	      StdDraw.line(0, r, 99, r);

        
	    StdDraw.setPenRadius(0.012);  // set pen radius thickness
	    StdDraw.setPenColor(StdDraw.BLACK); // set pen color

        // create three points with x and y coordinate a random integer in [10, 70)
        // Note that we will be using our point class, not this one
	    Point2D pt1 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));
        Point2D pt2 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));
        Point2D pt3 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));
	    Point2D pt4 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));
	    Point2D pt5 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));
	    Point2D pt6 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));
	    Point2D pt7 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));
	    Point2D pt8 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));
	    Point2D pt9 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));
	    Point2D pt10 = new Point2D(StdRandom.uniform(10, 70), StdRandom.uniform(10, 70));

	    
        // plot the points
        pt1.draw();
        pt4.draw(); 
        pt5.draw(); 
        pt6.draw(); 
        pt7.draw(); 
        pt8.draw(); 
        pt9.draw(); 
        pt10.draw();  
        StdDraw.point(pt2.x(), pt2.y()); // We will use this method to plot points
        StdDraw.point(pt3.x(), pt3.y()); // We will use this

        
        // Draw a circle at pt1 with radius equal to the distance to pt3
        StdDraw.setPenRadius(0.0005);
	    StdDraw.setPenColor(StdDraw.RED);
        double radius = pt1.distanceTo(pt3);
        StdDraw.circle(pt1.x(), pt1.y(), radius);

        // Draw a line between  pt2 and pt3
        StdDraw.setPenRadius(0.0025);
	    StdDraw.setPenColor(StdDraw.BLUE);
	    StdDraw.line(pt2.x(), pt2.y(), pt3.x(), pt3.y());
	    
	  }
	}