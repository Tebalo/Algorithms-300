import java.lang.Math;
import edu.princeton.cs.algs4.StdDraw;
public class BouncingBall{
	public BouncingBall(){}
	public static void main(String[] args) {
	 StdDraw.setXscale(-1.0,1.0);
	  StdDraw.setYscale(-1.0,1.0);
	  double rx = .480, ry = .860;
	  double vx = .015, vy = .023;
      double radius = .05;
      int dt = 20;

      while(true){
      	if(Math.abs(rx + vx) + radius > 1.0) vx = -vx;
      	if(Math.abs(ry + vy) + radius > 1.0) vy = -vy;
      	rx = rx + vx;
      	ry = ry + vy;
      	StdDraw.clear();
      	StdDraw.filledCircle(rx,ry, radius);
      	StdDraw.show(dt);
      }
	}
}