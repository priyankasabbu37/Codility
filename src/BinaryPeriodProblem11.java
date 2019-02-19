public class BinaryPeriodProblem11 
{
	static int solution(int n) 
	{
        int[] d = new int[30];
        int l = 0;
        int p=-1;
        
        while (n > 0) 
        {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        
        int z[] = new int[d.length];
        int k = 0;
        int j = l-1;
        while (j>=0)
        {
        	z[k] = d[j];
        	k++;
        	j--;
		}
        
        
        for (p = 1; p < 1 + l; ++p) 
        {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) 
            {
                if (z[i] != z[i + p]) 
                {
                    ok = false;
                    break;
                }
            }
            if (ok) 
            {
                return p;
            }
        }
        return p;
    }
	
	public static void main(String[] args)
	{
		System.out.println("\nEx1: " + solution(955));
        //System.out.println("\nEx2: " + solution(1651));
	}

}
