package jakartalabs.assignment2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	/**
	 * @param driver
	 */
	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	By email = By.id("loginEmailInput");
	By password = By.name("password");
	By signInBtn = By.xpath("//button[@type='submit' and text()='Sign in']");

//	By signInBtn = By.xpath("//button[@type='submit' and text()='Sign in']");

	public void login(String user, String pwd) {

		setText(email, user);
		setText(password, pwd);
		clickAndWait(signInBtn);

	}

}
