
public class Problem9SaddelPoints {

	public static void main(String[] args) 
	{
		new Problem9SaddelPoints();
	}

	public Problem9SaddelPoints() 
	{
		/*
		 * int[][] matrix = { {4, 5, 6}, {7, 18, 9}, {5, 1, 3} };
		 */
/*
		int[][] matrix1 = { { 0, 1, 9, 3, -111, 18, 20, 28, 29, 31 }, 
							{ 7, 5, 8, 3, -7, 27, 96, 298, 3728, 987 }, 
							{ 9, 40, 97, 45, -768, 131, 87, 2526, 982, 888 },
							{ 4, 6, 7, 1, -99, 227, 384, 0, 512, 76 }, 
							{ 8, 19, 27, 11, -800, 76, 128, 1326, 3121, 999}};*/
		
		int[][] matrix1 = {
								{ 0, 1, 9, 3}, 
								{ 7, 5, 8, 3}, 
								{ 9, 2, 9, 4},
								{ 4, 6, 7, 1}, 
						  };
		
		
		
		int counter = printSaddlePoint(matrix1);
		System.out.println("Number of saddle points: " + counter);
	}

	private int printSaddlePoint(int[][] matrix) 
	{
		System.out.println("matrix.length" + matrix.length);
	
		int counter1 = 0, counter2 = 0;
		
		for (int i = 1; i < matrix.length - 1; i++) 
		{
			boolean isMinSadlePointPresentInRow = true;
			boolean isMaxSadlePointPresentInRow = true;

			int minimum = matrix[i][1];
			int maximum = matrix[i][1];

			int colIndexOfRowMinimum = 0;
			int colIndexOfRowMaximum = 0;
			
			for (int j = 1; j < matrix[0].length - 1; j++) {
				if (matrix[i][j] <= minimum) {
					minimum = matrix[i][j];
					colIndexOfRowMinimum = j;
				}
				if (matrix[i][j] >= maximum) {
					maximum = matrix[i][j];
					colIndexOfRowMaximum = j;
				}
				
			}

			
			for (int j = 1; j < matrix.length - 1; j++) {
				if (minimum < matrix[j][colIndexOfRowMinimum]) {
					isMinSadlePointPresentInRow = false;
					break;
				}
					
			}
			for (int j = 1; j < matrix.length - 1; j++) {
				if (maximum > matrix[j][colIndexOfRowMaximum]) {
					isMaxSadlePointPresentInRow = false;
					break;
				}
			}
		
			if (isMinSadlePointPresentInRow) {

				System.out.println("min in row and max in coloumn: "+minimum);
				counter1++;
			}
			
			if (isMaxSadlePointPresentInRow) {

				System.out.println("max in row and min in column: "+maximum);
				counter2++;
			}
		}
		return counter1+counter2;
	}
}
