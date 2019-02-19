

public class CyclicRotation 
{
	public int[] solution(int[] A, int K)
	{
		
		for (int i = 0; i < K; i++) 
		{
			
			int [] x = new int[A.length];
			for (int j = 0; j < A.length; j++) 
			{
				if(j==0)
				{
					x[0]=A[A.length-1];	
					//System.out.println( x[0]+"  ff ");
				}
				else
				{
					x[j]=A[j-1];	
					System.out.println(x[j]+"  x of j");
				}
			}
			A = x;
		}
		for (int i : A)
		{
			
			System.err.print(i+" ");
		}
		
		return A;
	}
	
	public static void main(String[] args) 
	{
		int []A = {1,2,3,4};
		int K = 4;
		
		CyclicRotation rotation = new CyclicRotation();
		rotation.solution(A, K);
	}

}
