package utils;

import org.openqa.selenium.By;

public class GlobalVariables {
    // ------- URL API Request -------//

    //базовая url для всех запросов
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";

    //путь с аутентификацией
    public static final String PATH_AUT = "auth/";


    // -------  ТАЙМАУТЫ -------//

    //таймаут 5 секунд
    public static final int WAIT_FIVE = 5;

    // -------- URL СТРАНИЦ РЕГИСТРАЦИИ, ЛОГИНА ---------- //

    //url страницы регистрации
    public static final String REG_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    //url страницы Войти
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    public static final String START_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    // кнопка войти в аккаунт
    public static final By BUTTON_LOGIN_ACC = By.xpath(".//button[text()='Войти в аккаунт']");

    //кнопка личный кабинет
    public static final By BUTTON_PERS_AC = By.xpath(".//p[text()='Личный Кабинет']");

    //кн логотипа сайти Стелла Бургерс
    public static final By LOGO_STELLA_BURGERS = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");

    //кн Конструктор
    public static final By BUTTON_DESIGNER = By.xpath(".//p[text() = 'Конструктор']");


    // ------- Переменные полей -------- //

    //поле Email
    public static final By EMAIL = By.xpath("(//input[@name = 'name'])[2]");

    //поле Пароль
    public static final By PASSWORD = By.name("Пароль");

    // ------ Кнопка Войти ----- //
    public static final By BUTTON_LOGIN = By.xpath(".//button[text() = 'Войти']");

    public static final By BUTTON_LOGIN_ON_REG_PAGE = By.xpath(".//a[text() = 'Войти']");

    // ------- Кнопка Зарегистрироваться  ------//

    public static final By BUTTON_REG = By.xpath(".//button[text() = 'Зарегистрироваться']");


}
