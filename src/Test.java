import java.util.Calendar;
import java.util.Date;

public class Test 
{
	public static void main(String[] args) {
		
		Date date    = new Date();
		Calendar cal = Calendar.getInstance();

		System.out.println(date);
		
		cal.setTime(date);
		/*cal.add(Calendar.DATE, 0);
		cal.add(Calendar.HOUR, 0);
		cal.add(Calendar.SECOND, 0);
		*/
		System.out.println("End scheduleNextSqlReportRun() Time: "+cal.getTime());	
		
	}
}
