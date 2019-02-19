
public class Task4 
{
    static int countSquares(int a, int b)
    {
        /*int cnt = 0; 
 
        for (int i = a; i <= b; i++)
        {
            for (int j = 1; j * j <= i; j++)
            {
                if (j * j == i)
                {
                    cnt++;
                    System.out.println(i +" sqrt of "+j);
                }
            }
        }
        
        return cnt;*/
        
        return (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
        
        
    }
 
    public static void main(String[] args)
    {
        int a = 4, b = 17;
        Task4 obj = new Task4();
        System.out.print("Count of squares is " + obj.countSquares(a, b));
    }
}
