

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class Whatsapp {
	
	@Test
	public void test1() throws InterruptedException, IOException
	{ 
				String profilename = "9110340549";
					
				/*--- Initiating the browser with the given whatsapp account ---*/	
				
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/chromedriver.exe");  
				 ChromeOptions options = new ChromeOptions();
				 options.addArguments("user-data-dir=C:\\Users\\venke\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
				 ChromeDriver driver = new ChromeDriver(options);				  
				 driver.navigate().to("https://web.whatsapp.com");  
				 System.out.println("Opened the app");
				 driver.manage().window().maximize(); 
				 System.out.println("maximised the window");
				 Thread.sleep(15000);
				 
				 /*--- Searching for the given profile ---*/
				 
				 driver.findElementByXPath("//div[@role='textbox']").click();
				 driver.findElementByXPath("//div[@role='textbox']").sendKeys(profilename);
				 System.out.println("Searched the profile name");
				 Thread.sleep(3000);
				 driver.findElementByXPath("//span[@title='Z']").click();
				 System.out.println("Clicked on the profile name");
				 Thread.sleep(3000);
					
				 int IsOnline = driver.findElementsByXPath("//span[@title='online']").size();
				 				 
				 for (int i=0;i==0;) 
				 {
					 DateTimeFormatter RandHour = DateTimeFormatter.ofPattern("HH"); 
					 String StrRandHour= RandHour.format(LocalDateTime.now()); 
					
					 while (IsOnline==0)
					 {
						 IsOnline = driver.findElementsByXPath("//span[@title='online']").size();	
					     driver.findElementByXPath("//*[@id='main']//*[@role='textbox']").click();
					 } 
					 
					 /*--- Calculating starting of the online time ---*/
					 
					 DateTimeFormatter myDate = DateTimeFormatter.ofPattern("M/dd/yyyy");  
					 DateTimeFormatter myOnlinetime = DateTimeFormatter.ofPattern("HH:mm:ss"); 
					 String myDate1 =myDate.format(LocalDateTime.now());  
					 String myOnlinetime1= myOnlinetime.format(LocalDateTime.now()); 			 
					 			 
					 while (IsOnline>=1)
					 {
						 IsOnline = driver.findElementsByXPath("//span[@title='online']").size();							
						 driver.findElementByXPath("//*[@id='main']//*[@role='textbox']").click();
					 }
					 
					 /*--- Calculating ending of the online time ---*/			 
					 DateTimeFormatter myOfflinetime = DateTimeFormatter.ofPattern("HH:mm:ss"); 
					 String myOfflinetime1 = myOfflinetime.format(LocalDateTime.now()); 
					 String filename= "C:\\Users\\venkatm\\Downloads\\whatsapp_"+profilename+".csv";
					 FileWriter fw = new FileWriter(filename,true); //the true will append the new data
					 fw.write(myDate1+","+myOnlinetime1+","+myOfflinetime1+"\r");//appends the string to the file
					 fw.close();
					 String filename2= "C:\\Users\\venkatm\\Downloads\\whatsapp_"+profilename+"_WithAccount.csv";
					 FileWriter fw2 = new FileWriter(filename2,true); //the true will append the new data
					 fw2.write(myDate1+","+myOnlinetime1+","+myOfflinetime1+"\r");//appends the string to the file
					 fw2.close(); 			 
					 System.out.println(profilename+" is whatsapp on :  " + myDate1+","+myOnlinetime1+","+myOfflinetime1);
				
				 }    

	}

}
