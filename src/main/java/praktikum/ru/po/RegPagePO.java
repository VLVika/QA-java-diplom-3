package praktikum.ru.po;


import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.GlobalVariables.*;

public class RegPagePO {

   // поле драйвера
    private WebDriver driver;


  //форма регистрации с полями
    private static final By FORM_REG = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']");

  //поле Имя
  private static final By NAME = By.xpath(".//input[@name = 'name']");

  //кнопка Зарегистрироваться
  private static final By BUTTON_REG = By.xpath(".//button[text() = 'Зарегистрироваться']");

//конструктор класса
    public RegPagePO(WebDriver driver) {
        this.driver = driver;
    }

  //ввод имени

   private void fillFieldNameRandomValue(String nameRandom){
       driver.findElement(NAME).sendKeys(nameRandom);
   }

    //ввод Email
    private void fillFieldEmailRandomValue(String email){
        driver.findElement(EMAIL).sendKeys(email);
    }

    //ввод Пароль
    private void fillFieldPasswordRandomValue(String password){
        driver.findElement(PASSWORD).sendKeys(password);
    }

    //нажимаем на кнопку Зарегистрироваться
    private void clickOnButtonRegistration(){
        driver.findElement(BUTTON_REG).click();
    }


    //метод регистрации нового пользователя
    @Step("Регистрирует нового пользователя, вводит рандомное Имя, логин и пароль, нажимает на кн Зарегистрироваться")
  public void registrationNewUser(String nameRandom, String email, String password){
    fillFieldNameRandomValue(nameRandom);
    fillFieldEmailRandomValue(email);
    fillFieldPasswordRandomValue(password);
    clickOnButtonRegistration();
  }

    //метод открытия страницы
    @Step("Открывает страницу регистрации")
    public void openRegistrationPage()  {
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

    @Step("Пользователь логинится в систему, вводит логин и пароль")
    public void  logIn(String email, String password){
        fillFieldEmailRandomValue(email);
        fillFieldPasswordRandomValue(password);



    }




}
