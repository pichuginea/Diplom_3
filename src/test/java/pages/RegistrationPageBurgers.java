package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageBurgers {

	private WebDriver driver;

	public RegistrationPageBurgers (WebDriver driver) {
		this.driver = driver;
	}

	//Поле "Имя"
	private By nameField = By.xpath("//fieldset[1]//input");

	//Поле "Email"
	private By emailField = By.xpath("//fieldset[2]//input");

	//Поле "Пароль"
	private By passwordField = By.xpath("//input[@type = 'password']");

	//Кнопка "Зарегистрироваться"
	private By registrationButton = By.xpath("//*[text()='Зарегистрироваться']");

	//Кнопка "Войти"
	private By loginButton = By.xpath("//*[text()='Войти']");

	//Область с текстом ошибки
	private By errorLocator = By.xpath("//p[@class = 'input__error text_type_main-default']");

	@Step("Get error text")
	public String getErrorText() {
		return driver.findElement(errorLocator).getText();
	}

	@Step("User registration")
	public void register(String name, String email, String password){
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		clickRegistrationButton();
	}

	@Step("Click registration button")
	public void clickRegistrationButton() {
		driver.findElement(registrationButton).click();
	}

	@Step("Click login button")
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
}
