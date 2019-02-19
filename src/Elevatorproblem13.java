import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class Elevatorproblem13
{
	public int solution(int[] A, int[] B, int M, int X, int Y)
	{
        if (A == null || B == null || A.length == 0 || B.length == 0 || X < 1 || Y < 1) 
        {
            return 0;
        }
        
        int res = 0;
        
        Queue<Trip> tripQueue = new LinkedList<>();
        
        for (int i = 0; i < A.length; i++) 
        {
            if (A[i] > Y) 
            {
                throw new RuntimeException("Over Limit...");
            }
            tripQueue.add(new Trip(A[i], B[i]));
        }
        while (!tripQueue.isEmpty()) 
        {
            res += helper(tripQueue, M, X, Y);
        }
        return res;
    }
	
	int helper(Queue<Trip> tripQueue, int M, int X, int Y)
	{
        BitSet floors = new BitSet(M);
        
        while (!tripQueue.isEmpty() && X > 0 && (Y - tripQueue.peek().weight) >= 0) 
        {
            Trip trip = tripQueue.poll();
            X -= 1;
            Y -= trip.weight;
            floors.set(trip.floor);
        }
        return floors.cardinality() + 1;
    }
	
	class Trip 
	{
        int weight;
        int floor;

        public Trip(int weight, int floor) {
            this.weight = weight;
            this.floor = floor;
        }
    }
	
	public static void main(String[] args) {
	
		int[] A = new int[] {40,40,100, 80, 20};
        int[] B = new int[] {3,3,2,2,3};
        int M = 5;
        int X = 2;
        int Y = 200;
        
        Elevatorproblem13 e = new Elevatorproblem13();
        System.out.println(e.solution(A, B, M, X, Y));
	}
}
