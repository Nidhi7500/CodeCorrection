package mail;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
public class ZipAndSendMail {



	//mvn exec: java -Dexec.mainClass="mail.ZipAndSendMail"
	
	//mvn -Dexec.test.failure.ignore=true test exec: java -Dexec.mainClass="mail.ZipAndSendMail"
	


	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;
	static String[] toEmails = { "bhanotnidhi26@gmail.com" };
	static String fromUser = "bhanotnidhi26@gmail.com";// imap on, other devices on, no recovery phe
	static String password = "gkxoooynmgviatxv";

	public static void main(String[] args) throws Exception
	{
	//report folder - extent reports
		
	String reportFolder="C:\\Users\\nidhi\\eclipse-workspace\\TestngProject1\\Reports1";
	// find latest folder

	File dir = new File(reportFolder);
	File[] files = dir.listFiles();
	File lastModified = Arrays.stream(files).filter(File::isDirectory).max(Comparator.comparing(File::lastModified)).orElse(null);
	System.out.println(lastModified.getName ());

	//zip
	Zip.zipDir(reportFolder+"\\"+lastModified.getName(), reportFolder+"\\"+lastModified.getName()+".zip");
	
	//mail
	Mail javaEmail = new Mail();
	javaEmail.setMailServerProperties();

	
	
	javaEmail.createEmailMessage(
	"Automation Test Reports",
	// subject
	"Please find the reports in attachment.",
	// body
	reportFolder+"\\"+lastModified.getName()+".zip", // attachment path
	"Reports.zip", // name of attachment 
	toEmails// receivers
	);
	javaEmail.sendEmail(fromUser, password);

	}

}
