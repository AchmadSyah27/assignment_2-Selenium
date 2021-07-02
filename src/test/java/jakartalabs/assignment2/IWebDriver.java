package jakartalabs.assignment2;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public interface IWebDriver {

	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public void createWebDriver();

	public void quitWebDriver(ITestResult itr);
}