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

public class AuthenticationTests {

	private WebDriver driver;

	private HomePageBurgers homePage;
	private LoginPageBurgers loginPage;
	private ProfilePageBurgers profilePage;
	private RegistrationPageBurgers registrationPage;
	private PasswordRecoveryPageBurgers passwordRecoveryPage;

	private static final String EMAIL = "evgeny@ya.ru";
	private static final String PASSWORD = "evgeny";

	private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		homePage = new HomePageBurgers(driver);
		loginPage = new LoginPageBurgers(driver);
		profilePage = new ProfilePageBurgers(driver);
		registrationPage = new RegistrationPageBurgers(driver);
		passwordRecoveryPage = new PasswordRecoveryPageBurgers(driver);
	}

	@Test
	@DisplayName("User login via home page")
	@Description("Basic test for positive user authentication via home page")
	public void loginViaHomePage() {
		homePage.clickLoginButton();
		loginPage.login(EMAIL, PASSWORD);

		Assert.assertTrue(homePage.isOrderButtonDisplayed());
	}

	@Test
	@DisplayName("User login via profile page")
	@Description("Basic test for positive user authentication via profile page")
	public void loginViaProfilePage() {
		homePage.clickProfileButton();
		loginPage.login(EMAIL, PASSWORD);
		Assert.assertTrue(homePage.isOrderButtonDisplayed());
	}

	@Test
	@DisplayName("User login via registration page")
	@Description("Basic test for positive user authentication via registration page")
	public void loginViaRegistrationPage() {
		homePage.clickLoginButton();
		loginPage.clickRegistrationButton();
		registrationPage.clickLoginButton();
		loginPage.login(EMAIL, PASSWORD);

		Assert.assertTrue(homePage.isOrderButtonDisplayed());
	}

	@Test
	@DisplayName("User login via password recovery page")
	@Description("Basic test for positive user authentication via password recovery page")
	public void loginViaPasswordRecoveryPage() {
		homePage.clickLoginButton();
		loginPage.clickPwRecoveryButton();
		passwordRecoveryPage.clickLoginButton();
		loginPage.login(EMAIL, PASSWORD);

		Assert.assertTrue(homePage.isOrderButtonDisplayed());
	}

	@Test
	@DisplayName("User logout via profile page")
	@Description("Basic test for positive user logout via profile page")
	public void logoutViaProfilePage() {
		homePage.clickProfileButton();
		loginPage.login(EMAIL, PASSWORD);
		homePage.clickProfileButton();
		profilePage.clickLogoutButton();

		Assert.assertTrue(loginPage.isLoginButtonDisplayed());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
