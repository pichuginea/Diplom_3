package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPageBurgers {

	private WebDriver driver;
	//Кнопка "Войти"
	private By loginButton = By.xpath("//*[text()='Войти']");

	public PasswordRecoveryPageBurgers(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click login button")
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
}
