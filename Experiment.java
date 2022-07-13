import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
/**
*S9/E22-Partial Terms of.... A friend asks Lois to be a surrogate
*mother for her, and Lois agrees. However, when the friend unexpectedly dies,
*Lois isn't sure what to do. The family gets into
*Filename:CSI323Circle.java
*@author Bopaki Tebalo.
*@author Wapa Omogolo Edzani.
*Description:The{@code Experiment} class represents a unit test that generate 50 points, each point of
*random integer between 150 and 850. The class counts how many lines will be used to connect those points
*whose circles intersect. Draws points, circles and lines of each and every set of 50 points and keeps
*track of the set that gives the largest number of lines drawn. This experiment is repeated 1000 times
*and the point set that has produced the highest number of lines between points is written to a file
*bestPointset.txt
*/
public class Experiment{

    private static CSig ig;//declare variable ig, DataType CSig
    /**
    *Unit tests{@code ABag} datatype
    *@param args the command-line arguments
    */
	public static void main(String[] args) {

    ABag<CSI323Point> points = new ABag<CSI323Point>();//Declare and Create a bag of points.
    ABag<CSI323Point> highestDraws = new ABag<CSI323Point>();//Declare and Create a bag that will hold points with the highest draws.
    ig = new CSig(); //create object CSig to allow us to steal/call its methods.
    ABag<CSI323Circle> circle = ig.circles(points);//create a bag of cirlces, we would like to draw the circles it more efficient that way. 
    
    int repeat = 1;//initialise repeat to 1;

    while(repeat <= 1000){//automate the experiment to repeat 1000 times.
         
         int i = 1;//initialise i to 1
         while(i <= 50){//repeat 50 times to generate points random 50 coordinates and add them to points bag.
             points.addFront(new CSI323Point(StdRandom.uniform(150, 850), StdRandom.uniform(150, 850)));//add a coordinate to the bag.
             i++;//increment the loop.
         } 
         ig.drawGrid(1000, 20);//draw the grid of size 1000x100 at the step defined by 20.

         ig.plotPoints(points);//plot the points from the point bag.
     
         ig.drawCircles(ig.circles(points));//draw the circles from circles bag.
     
         int count = ig.drawLines(ig.circles(points));//Draw lines between circles that intersect and return the number of lines drawn to count of type int.

         ig.clear();//Clear the file after drawing to prepare it for the next point set.


         int high = 0; //highest lines drawn.
         
         if(count > high){
             highestDraws = points;//keep track of the highest lines drawn for the current set, save them in the highest draw bag.
             high = count;//update the highest lines drawn.
         }  
         points = new ABag<CSI323Point>();//empties the bag to prepare it for a new set of points.

         repeat++;//increment by 1.
    }

    for(CSI323Point s : highestDraws){//traverse the bag.
         StdOut.println(s.x()+" "+s.y());//The set that produced the highest number of lines written to a file called bestPointset.txt
        }  
        System.exit(0);
        //BouncingBall play = new BouncingBall();
        //play.draw();
  }
}