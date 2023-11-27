package utils;

import org.openqa.selenium.By;

public class GlobalVariables {

    // -------  ТАЙМАУТЫ -------//

    //таймаут 5 секунд
    public static final int WAIT_FIVE = 5;

    // -------- URL СТРАНИЦ РЕГИСТРАЦИИ, ЛОГИНА ---------- //

    //url страницы регистрации
    public static final String REG_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    //url страницы Войти
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";


    // ------- Переменные полей -------- //

    //поле Email
    public static final By EMAIL = By.xpath("(//input[@name = 'name'])[2]");

    //поле Пароль
    public static final By PASSWORD = By.name("Пароль");

    // ------ Кнопка Войти ----- //
    public static final By BUTTON_LOGIN = By.xpath(".//button[text() = 'Войти']");

}
