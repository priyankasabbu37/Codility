import java.util.Arrays;

public class Task3 
{
	public static int maxOverlapIntervalCount(int[] A, int[] B,int n)
	{
		int maxOverlap     = 0;
		int currentOverlap = 0;
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int i = 0;
		int j = 0; 
		
		while(i < n && j < n)
		{
			if(A[i] < B[j])
			{
				currentOverlap++;
				maxOverlap = Math.max(maxOverlap, currentOverlap);
				i++;
			}
			else
			{
				currentOverlap--;
				j++;
			}
		}
		
		return maxOverlap;
	}
	
	public static void main(String[] args)
	{
		int []A = {0, 1, 3, 4};
		int []B = {2, 5, 6, 7};
		int n = A.length;
		System.out.println(maxOverlapIntervalCount(A,B,n));
	}
}
