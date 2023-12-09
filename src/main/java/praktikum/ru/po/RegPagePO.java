package praktikum.ru.po;


import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static praktikum.ru.po.LogInPagePO.LOGIN_URL;
import static utils.GlobalVariables.*;

public class RegPagePO {

    // поле драйвера
    private WebDriver driver;

    //url страницы регистрации
    public static final String REG_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    //форма регистрации с полями
    private static final By FORM_REG = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']");

    //поле Имя
    private static final By NAME = By.xpath(".//input[@name = 'name']");

    //Кнопка Зарегистрироваться
    public static final By BUTTON_REG = By.xpath(".//button[text() = 'Зарегистрироваться']");

    //текст ошибки при вводе меньше 6 символов в поле пароль
    private static final String ERROR_TEXT = "Некорректный пароль";

    //элемент ошибки при вводе меньше 6 символов в поле пароль
    private static final By ERROR = By.xpath("//p[text() = 'Некорректный пароль']");

    //конструктор класса
    public RegPagePO(WebDriver driver) {
        this.driver = driver;
    }

    //ввод имени

    private void fillFieldNameRandomValue() {
        driver.findElement(NAME).sendKeys(String.format("Марфуша_'%s'", RandomStringUtils.randomNumeric(3)));
    }

    //ввод Email
    private void fillFieldEmailRandomValue(String email) {
        driver.findElement(EMAIL).sendKeys(email);
    }

    //ввод Пароль
    private void fillFieldPasswordRandomValue(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    //нажимаем на кнопку Зарегистрироваться
    private void clickOnButtonRegistration() {
        driver.findElement(BUTTON_REG).click();
    }


    //метод регистрации нового пользователя
    @Step("Регистрирует нового пользователя, вводит рандомное Имя, логин и пароль, нажимает на кн Зарегистрироваться")
    public void registrationNewUser(String email, String password) {
        fillFieldNameRandomValue();
        fillFieldEmailRandomValue(email);
        fillFieldPasswordRandomValue(password);
        clickOnButtonRegistration();
    }

    //метод открытия страницы
    @Step("Открывает страницу регистрации")
    public void openRegistrationPage() {
        driver.get(REG_PAGE_URL);
        new WebDriverWait(driver, WAIT_FIVE)
                .until(ExpectedConditions.presenceOfElementLocated(BUTTON_REG));
    }

    //метод проверки
    @Step("Проверяет, что регистрация прошла успешно")
    public void checkResultRegistration() {
        new WebDriverWait(driver, WAIT_FIVE)
                .until(ExpectedConditions.presenceOfElementLocated(BUTTON_LOGIN));
        Assert.assertEquals("Регистрация прошла НЕ УСПЕШНО!!!", LOGIN_URL, driver.getCurrentUrl());
    }

    @Step("Проверяет, что при введении пороля менее 6 символов появляется текст ошибки")
    public void checkErrorRegistration() {
        new WebDriverWait(driver, WAIT_FIVE)
                .until(ExpectedConditions.presenceOfElementLocated(ERROR));
        Assert.assertEquals("Не появилась ошибка -->" + ERROR, ERROR_TEXT, driver.findElement(ERROR).getText());


    }


}
