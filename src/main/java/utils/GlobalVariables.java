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


    // ------- Переменные полей -------- //

    //поле Email
    public static final By EMAIL = By.xpath("(//input[@name = 'name'])[2]");

    //поле Пароль
    public static final By PASSWORD = By.name("Пароль");

    // ---- Кнопки ----//

    // ------ Кнопка Войти ----- //
    public static final By BUTTON_LOGIN = By.xpath(".//button[text() = 'Войти']");

    public static final By BUTTON_LOGIN_ON_REG_PAGE = By.xpath(".//a[text() = 'Войти']");


    // кнопка войти в аккаунт
    public static final By BUTTON_LOGIN_ACC = By.xpath(".//button[text()='Войти в аккаунт']");


}
