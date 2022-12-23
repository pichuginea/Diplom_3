package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageBurgers {

	private WebDriver driver;

	public RegistrationPageBurgers (WebDriver driver) {
		this.driver = driver;
	}

	//Поле "Email"
	private By emailField = By.xpath("//input[@type='text' and @name='name']");

	@Step("Click button by label {buttonText}")
	public void clickButtonByText(String buttonText) {
		driver.findElement(By.xpath(String.format("//*[text()='%s']", buttonText))).click();
	}

}
