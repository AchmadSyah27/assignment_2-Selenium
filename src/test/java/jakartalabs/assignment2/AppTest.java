package jakartalabs.assignment2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.AssertJUnit;

import jakartalabs.assignment2.pages.BasePage;
import jakartalabs.assignment2.pages.CommonWebPage;
import jakartalabs.assignment2.pages.HomePage;
import jakartalabs.assignment2.pages.LoginPage;

/**
 * Unit test for simple AppEnums.
 */
public class AppTest extends BaseWebTest {

	BasePage BasePage = new BasePage(driver, explicitWait);
	HomePage HomePage = new HomePage(driver, explicitWait);
	LoginPage LoginPage = new LoginPage(driver, explicitWait);
	CommonWebPage CommonWebPage = new CommonWebPage(driver, explicitWait);

	@Test
	public void verifyUsernameAndPrice() throws InterruptedException {

		CommonWebPage.goToUrl("https://staging.engineer.ai/");
		HomePage.clickOnButton(AppEnums.ButtonNames.chooseABase.toString());
		BasePage.clickAndWait(By.xpath("//*[@class='closeButton']//*[@class='icon-cancel']"));
		BasePage.clickAndWait(By.xpath("//*[@class='natashaMsgPanel']"));
		BasePage.clickAndWait(By.xpath("//div[@class='closePanel']//em[@class='icon-cancel']"));
		BasePage.clickAndWait(By.xpath("//app-home-template-card[1]//div[1]//div[1]//div[2]//button[1]//em[1]"));

		// email and password
		String email = "jogidemo321@gmail.com";
		String password = "builder123";

		// Click Sign In
		HomePage.clickOnButton(AppEnums.ButtonNames.signIn.toString());

		// Login by input email and password
		LoginPage.login(email, password);

		// Wait element present/visible
		explicitWait.get()
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wizardDot']//span[1]")));
		explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[normalize-space()='Will you need audio management features?']")));

		// Click Plan Delivery button
		HomePage.clickOnDiv(AppEnums.ButtonNames.planDelivery.toString());

		// Click Done button
		HomePage.clickOnButton(AppEnums.ButtonNames.done.toString());

		// Enter and save Project Name
		String projectName = "Assignment2-Marco";
		BasePage.setText(By.xpath("//input[@placeholder='eg. Booking.com']"), projectName);
		HomePage.clickOnButton(AppEnums.ButtonNames.save.toString());

		// Verify Project Name
		String verifyProjectName = BasePage.getText(By.xpath("//p[@class='strip-head']"));
		AssertJUnit.assertEquals(verifyProjectName, projectName);

		// Save value from Total Cost
		String totalCost = BasePage.getText(By.xpath("//p[@class='ng-star-inserted']//strong[contains(text(),'₹')]"));

		// Go to Dashboard page
		HomePage.clickOnDiv(AppEnums.MenuNames.userProfile.toString());
		BasePage.clickAndWait(By.xpath("//span[normalize-space()='Dashboard']"));

		// verify Project Name on Dashboard page
		String verifyProjectNameOnDashboard = BasePage.getText(By.xpath(
				"/html/body/app/div/div[1]/div[2]/main/app-dashboard/div/div[2]/div/app-dashboard-main/div/div/div[3]/app-completed-cards/div[2]/div[1]/div[1]/div[1]"));
		AssertJUnit.assertEquals(verifyProjectNameOnDashboard, projectName + "\nLast edited: less than a minute ago");

		// verify Total Cost on Dashboard page
		String verifyTotalCost = BasePage.getText(By.xpath(
				"/html/body/app/div/div[1]/div[2]/main/app-dashboard/div/div[2]/div/app-dashboard-main/div/div/div[3]/app-completed-cards/div[2]/div[1]/div[3]/div[1]/div"));
		AssertJUnit.assertEquals(verifyTotalCost, totalCost.replaceAll(" ", ""));

	}
}