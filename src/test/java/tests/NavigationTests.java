package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.util.concurrent.TimeUnit;

public class NavigationTests {

	private static final String EMAIL = "evgeny@ya.ru";
	private static final String PASSWORD = "evgeny";
	private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
	private WebDriver driver;
	private HomePageBurgers homePage;
	private ProfilePageBurgers profilePage;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		homePage = new HomePageBurgers(driver);
		LoginPageBurgers loginPage = new LoginPageBurgers(driver);
		profilePage = new ProfilePageBurgers(driver);
		homePage.clickLoginButton();
		loginPage.login(EMAIL, PASSWORD);
	}

	@Test
	@DisplayName("Navigate profile page")
	@Description("Check if profile page navigation works")
	public void navigateToProfilePage() {
		homePage.clickProfileButton();

		Assert.assertTrue(profilePage.isLogoutButtonDisplayed());
	}

	@Test
	@DisplayName("Navigate constructor tab")
	@Description("Check if profile page navigation to constructors tab works")
	public void navigateFromProfilePageToConstructorTab() {
		homePage.clickProfileButton();
		homePage.clickConstructorButton();

		Assert.assertTrue(homePage.isOrderButtonDisplayed());
	}

	@Test
	@DisplayName("Navigate logo")
	@Description("Check if profile page navigation to constructors tab works")
	public void navigateFromProfilePageToLogo() {
		homePage.clickProfileButton();
		homePage.clickLogo();

		Assert.assertTrue(homePage.isOrderButtonDisplayed());
	}

	@Test
	@DisplayName("Navigate to constructor tabs")
	@Description("Navigating to constructors tab one by one")
	public void navigateConstructorTabs() throws InterruptedException {
		homePage.clickSaucesTab();
		Assert.assertTrue(homePage.isSaucesDisplayed());
		homePage.clickFillingTab();
		Assert.assertTrue(homePage.isFillingDisplayed());
		Thread.sleep(1000);
		homePage.clickBunsTab();
		Assert.assertTrue(homePage.isBunsDisplayed());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
