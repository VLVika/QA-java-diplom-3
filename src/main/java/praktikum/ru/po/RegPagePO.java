package praktikum.ru.po;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPagePO {

   // поле драйвера
    private WebDriver driver;

   //таймаут 5 секунд
    private static final int WAIT_FIVE = 5;

  //url страницы регистрации
    private static final String REG_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

  //форма регистрации с полями
    private static final By FORM_REG = By.xpath(".//form[@class = 'Auth_form__3qKeq mb-20']");

  //поле Имя
  private static final By NAME = By.xpath(".//input[@name = 'name']");

  //поле Email
  private static final By EMAIL = By.xpath("(//input[@name = 'name'])[2]");

  //поле Пароль
  private static final By PASSWORD = By.name("Пароль");

  //кнопка Зарегистрироваться
  private static final By BUTTON_REG = By.xpath(".//button[text() = 'Зарегистрироваться']");

//конструктор класса
    public RegPagePO(WebDriver driver) {
        this.driver = driver;
    }

  //ввод имени
   private void fillFieldNameRandomValue(){
       driver.findElement(NAME).sendKeys(String.format("Марфуша_'%s'", RandomStringUtils.randomNumeric(3)));
   }

    //ввод Email
    private void fillFieldEmailRandomValue(){
        driver.findElement(EMAIL).sendKeys("marfa_'%s'@mail.ru", RandomStringUtils.randomAlphanumeric(3, 5));
    }

    //ввод Пароль
    private void fillFieldПарольRandomValue(){
        driver.findElement(PASSWORD).sendKeys(RandomStringUtils.randomAlphanumeric(6, 8));
    }

    //нажимаем на кнопку Зарегистрироваться
    private void clickOnButtonRegistration(){
        driver.findElement(BUTTON_REG).click();
    }


    //метод регистрации нового пользователя
  public void registrationNewUser(){
    fillFieldNameRandomValue();
    fillFieldEmailRandomValue();
    fillFieldПарольRandomValue();
    clickOnButtonRegistration();
  }

    //метод открытия страницы
    public void openRegistrationPage()  {
        driver.get(REG_PAGE_URL);
        new WebDriverWait(driver, WAIT_FIVE)
                .until(ExpectedConditions.presenceOfElementLocated(FORM_REG));
    }



}
