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

	//Кнопка лого "Stellar Burgers"
	private By logoButton = By.xpath("//*[@class = 'AppHeader_header__logo__2D0X2']");

	//Заголовок "Булки"
	private By headingBuns = By.xpath("//*[@id=\"root\"]//h2[1]");

	//Заголовок "Соусы"
	private By headingSauces = By.xpath("//*[@id=\"root\"]//h2[2]");

	//Заголовок "Начинки"
	private By headingFilling = By.xpath("//*[@id=\"root\"]//h2[3]");

	//Вкладка "Булки"
	private By tabBuns = By.xpath("//section[1]/div[1]/div[1]/span");

	//Вкладка "Соусы"
	private By tabSauces = By.xpath("//section[1]/div[1]/div[2]/span");

	//Вкладка "Начинки"
	private By tabFilling = By.xpath("//section[1]/div[1]/div[3]/span");

	@Step("Click button by label {buttonText}")
	public void clickButtonByText(String buttonText) {
		driver.findElement(By.xpath(String.format("//*[text()='%s']", buttonText))).click();
	}

	@Step("Is element with text {elementText} displayed")
	public boolean isElementWithTextDisplayed(String elementText) {
		return 	driver.findElement(By.xpath(String.format("//*[text()='%s']", elementText))).isDisplayed();
	}

	@Step("Click logo button")
	public void clickLogo() {
		driver.findElement(logoButton).click();
	}

	@Step("Check Buns heading is displayed")
	public boolean isBunsDisplayed() {
		return driver.findElement(headingBuns).isDisplayed();
	}

	@Step("Check Sauces heading is displayed")
	public boolean isSaucesDisplayed() {
		return driver.findElement(headingSauces).isDisplayed();
	}

	@Step("Check Filling heading is displayed")
	public boolean isFillingDisplayed() {
		return driver.findElement(headingFilling).isDisplayed();
	}

	@Step("Click Buns tab")
	public void clickBunsTab() {
		driver.findElement(tabBuns).click();
	}
	@Step("Click Sauces tab")
	public void clickSaucesTab() {
		driver.findElement(tabSauces).click();
	}

	@Step("Click Filling tab")
	public void clickFillingTab() {
		driver.findElement(tabFilling).click();
	}
}
