package jakartalabs.assignment2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	/**
	 * @param driver
	 */
	public HomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	String menuXpath = "//a[contains(text(),'%s')]";
	String buttonXpath = "//button[contains(text(),'%s')]";
	String inputXpath = "//input[contains(@id,'%s')]";

	String divXpath = "//*[contains(@class,'%s')]";

	public void clickOnMenu(String menuName) {

		By finalMenuXpath = By.xpath(String.format(menuXpath, menuName));
		clickAndWait(finalMenuXpath);

	}

	public void clickOnButton(String buttonName) {

		By finalButtonXpath = By.xpath(String.format(buttonXpath, buttonName));
		clickAndWait(finalButtonXpath);

	}

	public void clickOnDiv(String divName) {

		By finalDivXpath = By.xpath(String.format(divXpath, divName));
		clickAndWait(finalDivXpath);

	}
}