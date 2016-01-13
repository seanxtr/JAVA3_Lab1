/*
 * Program that calculates subset of numbers sums up to meet
 * the target value
 * 
 * Written by Tianrong Xiao, 2016-01-12
 * for Lab1 partA of CS1C Winter 2016 Foothill college
 */
import java.util.*;

public class Foothill
{
	public static void main(String[] args) throws Exception
	{
		// build the dataset
		int target = 125;
		ArrayList<Integer> dataSet = new ArrayList<Integer>();
		ArrayList<Sublist> choices = new ArrayList<Sublist>();

		dataSet.add(2); dataSet.add(12); dataSet.add(22);
		dataSet.add(5); dataSet.add(15); dataSet.add(25);
		dataSet.add(9); dataSet.add(19); dataSet.add(29);

		// code supplied by student
		choices.add(new Sublist(dataSet));
		
		int curNumber;
		int curChoicesNum;
		int kBest = 0;
		
		System.out.printf("Target: %d%n", target);
		
		// outter loop to go thru all possible numbers
		outerloop:
		for(int i = 0; i < dataSet.size(); i++){
			curNumber = dataSet.get(i);
			curChoicesNum = choices.size();
			
			// inner loop to go thru all existing choices
			for(int k = 0; k < curChoicesNum ; k++){
				
				// check if new sum within the target
				if (choices.get(k).getSum() + curNumber <= target)
					choices.add(choices.get(k).addItem(i));
				
				// check if new sum meet the target
				if (choices.get(k).getSum() + curNumber == target)
					break outerloop;
			}
		}
		
		// find the index of choice of largest sum
		int tempSum = Integer.MIN_VALUE;
		for(int k = 0; k < choices.size(); k++){
			curNumber = choices.get(k).getSum();
			if (curNumber > tempSum){
				tempSum = curNumber;
				kBest = k;
			}
		}
		
		// output the result
		choices.get(kBest).showSublist();	
    }
}

/************ Run ***************
Target: 72
Sublist------------------
Sum: 72
 array[0] = 2
 array[2] = 22
 array[3] = 5
 array[4] = 15
 array[6] = 9
 array[7] = 19
*/

/************ Run ***************
Target: 150
Sublist------------------
Sum: 138
 array[0] = 2
 array[1] = 12
 array[2] = 22
 array[3] = 5
 array[4] = 15
 array[5] = 25
 array[6] = 9
 array[7] = 19
 array[8] = 29
*/

/************ Run ***************
Target: 50
Sublist------------------
Sum: 50
 array[0] = 2
 array[1] = 12
 array[2] = 22
 array[3] = 5
 array[6] = 9
*/

/************ Run ***************
Target: 0
Sublist------------------
Sum: 0
*/

/************ Run ***************
Target: 125
Sublist------------------
Sum: 124
 array[0] = 2
 array[1] = 12
 array[2] = 22
 array[4] = 15
 array[5] = 25
 array[7] = 19
 array[8] = 29
*/