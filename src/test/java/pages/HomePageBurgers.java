package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageBurgers {

	private WebDriver driver;

	public HomePageBurgers(WebDriver driver) {
		this.driver = driver;
	}

	//Кнопка "Личный Кабинет"
	private By profileButton = By.xpath("//*[text()='Личный Кабинет']");

	//Кнопка "Оформить заказ"
	private By orderButton = By.xpath("//*[text()='Оформить заказ']");

	@Step("Click button by label {buttonText}")
	public void clickButtonByText(String buttonText) {
		driver.findElement(By.xpath(String.format("//*[text()='%s']", buttonText))).click();
	}

	@Step("Check order button is displayed")
	public boolean isOrderButtonDisplayed() {
		return driver.findElement(orderButton).isDisplayed();
	}
}
