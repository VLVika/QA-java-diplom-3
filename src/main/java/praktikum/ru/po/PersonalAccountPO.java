package praktikum.ru.po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.GlobalVariables.WAIT_FIVE;

public class PersonalAccountPO {

    // поле драйвера
    private WebDriver driver;

    // url страницы
    private static final String URL_PERS_ACC = "https://stellarburgers.nomoreparties.site/account/profile";

    //кнопка Профиль
    private static final By BUTTON_PROFILE = By.xpath(".//a[text()='Профиль']");

    //gполе email
    private static final By FIELD_EMAIL = By.xpath("(.//input[@name='name'])[1]");


    //конструктор класса
    public PersonalAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    //метод проверяющий, что отображается страница личного кабинета
    @Step("Проверяет, что находится на странице Личного Кабинета")
    public void checkGoToPersonalAcc(){
        new WebDriverWait(driver, WAIT_FIVE)
                .until(ExpectedConditions.presenceOfElementLocated(BUTTON_PROFILE));
    }

    //берет текст email
    @Step("Берет текст из поля email")
    public String getTextFromFieldEmail(){
       return driver.findElement(FIELD_EMAIL).getAttribute("value");
    }
}
