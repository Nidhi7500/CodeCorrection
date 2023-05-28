package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class Listener implements  ITestListener{


	public void onTestFailure(ITestResult result)
	{
		System.out.println("------TestFailed-----");
		System.out.println("Test failed: "+result.getName());
		System.out.println(result.getStatus());
		System.out.println(result.getThrowable().getMessage());
		//System.out.println(result.getAttribute("reporter"));
			ExtentTest test = (ExtentTest) result.getAttribute("reporter");
			test.log(Status.FAIL,result.getThrowable().getMessage());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("------TestPassed-------");
		System.out.println("Test Passed: "+result.getName());
	//	System.out.println(result.getAttribute("reporter"));
		ExtentTest test = (ExtentTest) result.getAttribute("reporter");
		test.log(Status.PASS,"Test Passed"+result.getName());
	}
	public void onTestSkipped(ITestResult result)
	{
		ExtentTest test = (ExtentTest) result.getAttribute("reporter");
		test.log(Status.SKIP,"Test skipped"+result.getName());
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
