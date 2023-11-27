package praktikum.ru.po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.GlobalVariables.*;

public class LogInPagePO {

    // поле драйвера
    private WebDriver driver;

    // поле логин
    public static final By EMAIL = By.xpath("(//input[@name = 'name'])");

    //конструктор класса
    public LogInPagePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открывает страницу Входа")
    public void openLoginPage()  {
        driver.get(LOGIN_URL);
        new WebDriverWait(driver, WAIT_FIVE)
                .until(ExpectedConditions.presenceOfElementLocated(BUTTON_LOGIN));
    }

    //ввод Email
    private void fillFieldEmailRandomValue(String email){
        driver.findElement(EMAIL).sendKeys(email);
    }

    //ввод Пароль
    private void fillFieldPasswordRandomValue(String password){
        driver.findElement(PASSWORD).sendKeys(password);
    }

    //нажатие на кн Вход
    private void clickOnButtonLogIn(){
        driver.findElement(BUTTON_LOGIN).click();
    }


    @Step("Входит в личный кабинет, вводит емейл и пароль, нажимает на кн Войти")
    public void logInUser(String email, String password){
        fillFieldEmailRandomValue(email);
        fillFieldPasswordRandomValue(password);
        clickOnButtonLogIn();
    }




}
