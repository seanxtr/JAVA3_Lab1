
// for NumberFormat and timing
import java.text.*;
import java.util.*;

public class TimeDemo {
	public static void main(String[] args) throws Exception
	{

	   // for formatting output neatly
	   NumberFormat tidy = NumberFormat.getInstance(Locale.US);
	   tidy.setMaximumFractionDigits(4);
	   
	   // how we time our algorithms -------------------------
	   long startTime, stopTime; 
	   startTime = System.nanoTime();

	   // run the algorithm

	   // how we determine the time elapsed -------------------
	   stopTime = System.nanoTime();

	   // report algorithm time
	   System.out.println("\nAlgorithm Elapsed Time: "
	      + tidy.format( (stopTime - startTime) / 1e9)
	      + " seconds.");
	}
}
