import java.util.*;

//------------------------------------------------------
public class Foothill
{
	// -------  main --------------
	public static void main(String[] args) throws Exception
	{
		// build the dataset
		int target = 72;
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
Sublist------------------
Sum: 72
 array[0] = 2
 array[2] = 22
 array[3] = 5
 array[4] = 15
 array[6] = 9
 array[7] = 19
*/

