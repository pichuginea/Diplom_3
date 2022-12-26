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

public class RegistrationTests {

	private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
	private WebDriver driver;
	private HomePageBurgers homePage;
	private LoginPageBurgers loginPage;
	private RegistrationPageBurgers registrationPage;
	private String name = System.currentTimeMillis() + "name";
	private String email = System.currentTimeMillis() + "@ya.ru";
	private String password = System.currentTimeMillis() + "password";

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		homePage = new HomePageBurgers(driver);
		loginPage = new LoginPageBurgers(driver);
		registrationPage = new RegistrationPageBurgers(driver);
		homePage.clickLoginButton();
		loginPage.clickRegistrationButton();
	}

	@Test
	@DisplayName("User registration")
	@Description("Basic test for positive user registration")
	public void positiveUserRegistration() throws InterruptedException {
		registrationPage.register(name, email, password);
		Thread.sleep(1000);
		loginPage.login(email, password);

		Assert.assertTrue(homePage.isOrderButtonDisplayed());
	}

	@Test
	@DisplayName("Failed user registration")
	@Description("Check user is not registered when password has < 6 symbols")
	public void negativeUserRegistration() {
		registrationPage.register(name, email, "12345");

		Assert.assertEquals("Некорректный пароль", registrationPage.getErrorText());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
