package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageBurgers {

	WebDriver driver;

	public ProfilePageBurgers (WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click button by label {buttonText}")
	public void clickButtonByText(String buttonText) {
		driver.findElement(By.xpath(String.format("//*[text()='%s']", buttonText))).click();
	}

	@Step("Is element with text {elementText} displayed")
	public boolean isElementWithTextDisplayed(String elementText) {
		return 	driver.findElement(By.xpath(String.format("//*[text()='%s']", elementText))).isDisplayed();
	}


}
