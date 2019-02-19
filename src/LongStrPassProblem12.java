import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LongStrPassProblem12
{
	public static void main(String[] args) 
	{
		System.out.println(solution("asdjkdasdjGasdasaddda8sdad9asdadrfdfsdertetttfsdfsfsdfsdf")); //a0bb //a0Ba //asdjkdasdjGasdasaddda8sdad9asdadrDfdfsdfsdfsfsdfsdf
	}

	static int solution (String pass)
	{
		boolean capitalFlag = false;
		StringBuffer subStr = new StringBuffer();
		char ch;
		String longPassStr = null;
		
		ArrayList<String> list = new ArrayList();
		
		for (int i = 0; i < pass.length(); i++) 
		{
			ch = pass.charAt(i);
			System.out.println(" ch "+ch);
			if(Character.isLetter(ch))
			{
				subStr = subStr.append(ch);
				System.out.println(" sub "+subStr);
				if(Character.isUpperCase(ch))
				{
					capitalFlag = true;
				}
			}
			else
			{
				if(capitalFlag)
				{
					list.add(subStr.toString());
				}
				subStr = new StringBuffer();
				capitalFlag = false;
			}
		}
		if(capitalFlag)
		{
			list.add(subStr.toString());	
		}

		Collections.sort(list, new Comparator<String>()
		{
			@Override
			public int compare(String s1, String s2)
			{
				 return s1.length()-s2.length();
			}
			
		});
		
		longPassStr = (String) list.get(list.size()-1);
		
		return (longPassStr != null) ? longPassStr.length() : -1;
	}

}
