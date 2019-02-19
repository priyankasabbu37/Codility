import java.util.SortedSet;
import java.util.TreeSet;

public class MaxBinaryGap 
{
	 public int solution(int N)
	 {
		 int a,count = 0,binGapCount = 0;
		 StringBuffer binStr = new StringBuffer();
		 SortedSet <Integer> set = new TreeSet<Integer>();
		 
		 while(N > 0)
         {
            a = N % 2;
            if(a == 0)
            {
                count++;
            }
            else
            {
            	binGapCount++;
            	set.add(count);
            	count=0;
            }
            binStr = binStr.append(a);
            N = N / 2;
         }
		 
		 String finalStr = binStr.reverse().toString();
		 
		 if(finalStr.lastIndexOf("0") >= 1 && finalStr.substring(1).contains("0") && binGapCount ==1)
		 {
			 return 0;
		 }
		 else
		 {
			return set.last();
		 }
	 }
	 public static void main(String[] args) 
	 {
		 MaxBinaryGap binaryGap = new MaxBinaryGap();
		 System.out.println(binaryGap.solution(529));//1041
	 }
}
