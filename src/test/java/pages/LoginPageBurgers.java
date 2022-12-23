package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageBurgers {

	private WebDriver driver;

	public LoginPageBurgers(WebDriver driver) {
		this.driver = driver;
	}

	//Поле "Email"
	private By emailField = By.xpath("//input[@type='text' and @name='name']");

	//Поле "Пароль"
	private By passwordField = By.xpath("//input[@type='password' and @name='Пароль']");

	//Кнопка "Войти"
	private By loginButton = By.xpath("//*[text() = 'Войти']");

	//Кнопка "Зарегистрироваться"
	private By registrationButton = By.xpath("//*[text() = 'Зарегистрироваться']");

	//Кнопка "Восстановить пароль"
	private By forgotPasswordButton = By.xpath("//*[text() = 'Восстановить пароль']");

	@Step("Click button by label {buttonText}")
	public void clickButtonByText(String buttonText) {
		driver.findElement(By.xpath(String.format("//*[text()='%s']", buttonText))).click();
	}

	@Step("Login")
	public void login (String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

}
