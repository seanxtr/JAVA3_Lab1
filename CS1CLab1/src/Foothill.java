import java.util.*;

//------------------------------------------------------
public class Foothill
{
	// -------  main --------------
	public static void main(String[] args) throws Exception
	{
		int target = 72;
		ArrayList<Integer> dataSet = new ArrayList<Integer>();
		ArrayList<Sublist> choices = new ArrayList<Sublist>();
		//int k, j, numSets, max, kBest, masterSum;
		//boolean foundPerfect;

		dataSet.add(2); dataSet.add(12); dataSet.add(22);
		dataSet.add(5); dataSet.add(15); dataSet.add(25);
		dataSet.add(9); dataSet.add(19); dataSet.add(29);

		// code supplied by student
		choices.add(new Sublist(dataSet));
		
		int curNumber;
		int kBest = 0;
		
		outerloop:
		for(int i = 0; i < dataSet.size(); i++){
			
			curNumber = dataSet.get(i);
			//System.out.println("i:" + i + " " + curNumber);
			
			for(int k = 0; k < choices.size(); k++){
				
				//System.out.println("k:" + k + " " + choices.get(k).getSum());
				
				if (choices.get(k).getSum() + curNumber <= target)
					choices.add(choices.get(k).addItem(i));
				
				if (choices.get(k).getSum() + curNumber == target)
					break outerloop;
			}
		}
		
		// find the index of choice of largest sum
		int tempSum = Integer.MIN_VALUE;
		for(int k = 0; k < choices.size(); k++){
			curNumber = choices.get(k).getSum();
			if (curNumber > tempSum)
			{
				tempSum = curNumber;
				kBest = k;
			}
		}
		
		choices.get(kBest).showSublist();	
    }
}