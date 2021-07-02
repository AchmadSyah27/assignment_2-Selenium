package jakartalabs.assignment2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonWebPage extends BasePage {

	/**
	 * @param driver
	 */
	public CommonWebPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public final String getCurrentUrlFromWebPage() {

		return getCurrentUrl();
	}

	public final void goToUrl(String url) {

		openUrl(url);
	}

	public final void openTab() {

		CreateTab();
	}

	public final void openWindow() {

		CreateWindow();
	}

	public final void switchTabOrWindow(int i) {

		SwitchDriver(i);
	}

	public final void runJavaScript(String script) {

		executeJs(script);
	}

	public final void acceptPopup() {

		acceptAlert();

	}
}