import java.util.Random;

public class Main {
    
    public static void main(String[] args) 
    {
       // for (int i = 0; i < 100; ++i) {
            //int[] ts = {5, -2, 3, 8,6};
            int[] ts = {-5, -5, -5, -42,6, 12};
            Solution s = new Solution();
            int s1 = s.solution1(ts);
           // int s2 = s.solution2(ts);
           // if (s1 != s2) {
                //System.out.println("!!!");
                //System.out.println(Arrays.toString(ts));
                System.out.println(s1);
             //   System.out.println(s2);
             //   return;
            //}
        //}
    }

    static class Solution
    {
        int solution1(int[] T)
        {
        	boolean isWintr = true;
        	
            int cnt = 1;
            int winMax = T[0];
            int sumMax = Integer.MIN_VALUE;
            
            for (int i = 1; i < T.length; i++)
            {
                int temp = T[i];
                
                if (isWintr) 
                {
                    if (temp > winMax) 
                    {
                    	isWintr = false;
                        cnt = i;
                    }
                }
                else 
                {
                    if (temp <= winMax) 
                    {
                    	isWintr = true;
                        winMax = sumMax;
                    }
                }
                sumMax = Math.max(sumMax, temp);
            }
            if (isWintr) 
            {
            	cnt = T.length;
            }
            return cnt;
        }
        
        /*int solution2(int[] T) {
            int counter = 1;
            int summerCounter = 0;
            int winterMax = T[0];
            int summerMax = Integer.MIN_VALUE;
            for (int i = 1; i < T.length; i++) {
                int elem = T[i];
                if (elem <= winterMax) {
                    if (summerCounter > 0) {
                        counter += summerCounter;
                        summerCounter = 0;
                        winterMax = summerMax;
                    }
                    counter++;
                }
                else {
                    summerMax = Math.max(summerMax, elem);
                    summerCounter++;
                }
            }
            return counter;
        }*/
    }
}
