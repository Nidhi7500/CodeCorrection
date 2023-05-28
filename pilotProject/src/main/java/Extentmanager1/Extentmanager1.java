package Extentmanager1;


	

	import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
	public class Extentmanager1 {

		

		
				static ExtentReports report;
				public static ExtentReports getReports()
				{
					if (report==null) {
						report= new ExtentReports();
						Date d = new Date();
						System.out.println(d.toString().replaceAll(":", "-"));
						String ReportsFolder= d.toString().replaceAll(":", "-")+"//ScreenShots//";
						
						String ScreenShotFolderPath= "C:\\Users\\nidhi\\WORKSPACE2\\pilotProject"+"\\Reports1\\" + ReportsFolder;
						
						String ReportFolderName = "C:\\Users\\nidhi\\WORKSPACE2\\pilotProject"+"\\Reports1\\" +d.toString().replaceAll(":", "-");
					File f = new File(ScreenShotFolderPath);
						
						
						f.mkdirs();
						
						ExtentSparkReporter sparkReporter = new ExtentSparkReporter(ReportFolderName);
						sparkReporter.config().setReportName("login test");
						sparkReporter.config().setDocumentTitle("Test Cases");
						sparkReporter.config().setTheme(Theme.DARK);
						sparkReporter.config().setEncoding("utf-8");
						
						report.attachReporter(sparkReporter);
					}
					return report;
				}
			
		}




