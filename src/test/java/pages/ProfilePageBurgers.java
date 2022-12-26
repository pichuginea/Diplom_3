package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageBurgers {

	WebDriver driver;
	//Кнопка "Выход"
	private By logoutButton = By.xpath("//*[text()='Выход']");

	public ProfilePageBurgers(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click logout button")
	public void clickLogoutButton() {
		driver.findElement(logoutButton).click();
	}

	@Step("Check if logout is displayed")
	public boolean isLogoutButtonDisplayed() {
		return driver.findElement(logoutButton).isDisplayed();
	}
}
