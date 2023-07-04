import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.testng.annotations.Test;

public class test {

	@Test
	public void aa()
	{
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // Or whatever IST is supposed to be
		System.out.println(formatter.format(LocalDateTime.now())); 
		
		 DateTimeFormatter myDate = DateTimeFormatter.ofPattern("M/dd/yyyy");  
		 DateTimeFormatter myOnlinetime = DateTimeFormatter.ofPattern("HH:mm:ss"); 
		 String myDate1 =myDate.format(LocalDateTime.now());  
		 String myOnlinetime1= myOnlinetime.format(LocalDateTime.now()); 			 
		 			 

		 /*--- Calculating ending of the online time ---*/			 
		 DateTimeFormatter myOfflinetime = DateTimeFormatter.ofPattern("HH:mm:ss"); 
		 String myOfflinetime1 = myOfflinetime.format(LocalDateTime.now()); 
	}
}
