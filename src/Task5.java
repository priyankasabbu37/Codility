import java.util.ArrayDeque;
import java.util.Deque;

public class Task5 
{
	public static int stackProblem(String s)
	{
		String[] splitStringBySpace = s.split(" ");

		Deque<String> stack = new ArrayDeque<String>();

		try 
		{
			for (String str : splitStringBySpace)
			{
				if (isNumeric(str)) 
				{
					stack.push(str);
				}
				else if ("DUP".equals(str)) 
				{
					stack.push(stack.getFirst());
				}
				else if ("POP".equals(str)) 
				{
					stack.pop();
				}
				else if ("+".equals(str)) 
				{
					String first = stack.pop();
					String second = stack.pop();
					stack.push((Integer.valueOf(second) + Integer.valueOf(first))+"");

				} 
				else if ("-".equals(str)) 
				{
					String first = stack.pop();
					String second = stack.pop();
					stack.push((Integer.valueOf(second) - Integer.valueOf(first))+"");
				}
			}
		}
		catch (Exception e) 
		{
			return -1;
		}
		return Integer.valueOf((stack.getFirst().length() > 1 ? stack.getFirst().substring(1) : stack.getFirst()));

		/*for (String number : stack) 
		{
			System.out.println(number);
		}
		System.out.println(stack.getFirst());*/
	}
	
	public static boolean isNumeric(String str) 
	{
		try
		{
			double d = Double.parseDouble(str);
		}
		catch (NumberFormatException e) 
		{
			return false;
		}
		return true;
	}
	public static void main(String[] args) 
	{
		System.out.println(stackProblem("3 DUP 5 - -"));//5 6 + - // 13 DUP 4 POP 5 DUP + DUP + - // 3 DUP 5 - -
	}
}
