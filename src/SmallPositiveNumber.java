import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SmallPositiveNumber
{
		public int solution(int[] A) //A = [1, 3, 6, 4, 1, 2]
		{
			List<Integer> dataList = new ArrayList<Integer>();
			List<Integer> missingNumList = new ArrayList<Integer>();
			
			for (int i = 0; i < A.length; i++)
			{
				dataList.add(A[i]);
			}
			
			Collections.sort(dataList);
			
			int missInt  = 0;
			int smallInt = dataList.get(0);
			int maxInt   = dataList.get(dataList.size()-1);
			
			int j = 1;	
			
			if(!dataList.contains(1))
			{
				return 1;
			}
			else
			{
				for (Integer integer : dataList) 
				{
					int tempNum = maxInt-j;
					
					if(!dataList.contains(tempNum) && tempNum >= smallInt+1)
					{
						missInt = tempNum;
						missingNumList.add(missInt);
					}
					j++;
				}	
			}
			
			if(missingNumList.isEmpty())
			{
				missingNumList.add(maxInt+1);
			}
			Collections.sort(missingNumList);
			
			return missingNumList.get(0);
		}
			
		public static void main(String[] args) {
			
			int []A = {1,888888,56456456,6};
			SmallPositiveNumber solution = new SmallPositiveNumber();
			System.out.println(solution.solution(A));
		}
}