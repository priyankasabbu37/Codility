import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class OddOccurrencesInArray 
{
	public int solution(int[] A)
	{
		Map<Integer, Integer> dataMap = new HashMap<>();
		
		for (int i = 0; i < A.length; i++) 
		{
			int count = 1;
			if(dataMap.containsKey(A[i]))
			{ 
				int temp = dataMap.get(A[i]);
				count+=temp;
				dataMap.put(A[i],count);
			}
			else
			{
				dataMap.put(A[i],count);
			}
		}
		
		Iterator<Entry<Integer, Integer>> iterator = dataMap.entrySet().iterator();
		while (iterator.hasNext()) 
		{
			Map.Entry<Integer,Integer> entry =  (Entry<Integer, Integer>) iterator.next();
			if(entry.getValue()==1)
			{
				return entry.getKey();
			}
		}
		return 0;
	}
	public static void main(String[] args) 
	{
		int [] A = {2,0,1};
		OddOccurrencesInArray  occurrencesInArray = new OddOccurrencesInArray();
		System.out.println(occurrencesInArray.solution(A));
	}
}
