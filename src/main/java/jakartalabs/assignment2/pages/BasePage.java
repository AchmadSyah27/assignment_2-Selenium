package jakartalabs.assignment2.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

	/**
	 * @param driver
	 * @param explicitWait
	 */
	public BasePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}

	public void clickAndWait(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		driver.get().findElement(locator).click();

	}

	public void setText(By locator, String text) {
		explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.get().findElement(locator).sendKeys(text);

	}

	public final String getText(By locator) {
		explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.get().findElement(locator).getText();

	}

	protected final void openUrl(String url) {

		driver.get().get(url);

	}

	protected final String getCurrentUrl() {

		return driver.get().getCurrentUrl();

	}

	protected final void SwitchDriver(int i) {

		Set<String> handles = driver.get().getWindowHandles();

		ArrayList<String> handlelist = new ArrayList<String>(handles);

		driver.get().switchTo().window(handlelist.get(i));
	}

	protected final void CreateWindow() {
		driver.get().switchTo().newWindow(WindowType.WINDOW);
	}

	protected final void CreateTab() {
		driver.get().switchTo().newWindow(WindowType.TAB);

	}

	protected final void executeJs(String script) {

		JavascriptExecutor jse = (JavascriptExecutor) driver.get();

		jse.executeScript(script);
	}

	protected final void acceptAlert() {

		driver.get().switchTo().alert().accept();

	}

	protected final void contextClick(By locator) {

		Actions action = new Actions(driver.get());

		action.contextClick(driver.get().findElement(locator)).perform();
	}

	public void hoverMouse(By locator) {

		Actions actions = new Actions(driver.get());
		explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
		actions.moveToElement(driver.get().findElement(locator));
	}
}