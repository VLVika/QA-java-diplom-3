package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import praktikum.ru.po.LogInPagePO;
import praktikum.ru.po.RegPagePO;
import praktikum.ru.po.StartPagePO;

import static praktikum.ru.api.steps.DeleteUser.deleteUser;

@DisplayName("Регистрация")
public class RegistrationTest {

    private static String emailRandom = String.format("marfa_'%s'@mail.ru", RandomStringUtils.randomAlphanumeric(3, 5));
    private static String passwordRandom = RandomStringUtils.randomAlphanumeric(6, 8);


    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    @DisplayName("Успешная Регистрация нового пользователя")
    public void registrationTest() {

        RegPagePO objRegPage = new RegPagePO(driverRule.getDriver());
        objRegPage.openRegistrationPage();
        objRegPage.registrationNewUser(emailRandom, passwordRandom);

        objRegPage.checkResultRegistration();

    }


    @DisplayName("Метод удаления пользователя")
    @After
    public void turnOff() {

        LogInPagePO logInPage = new LogInPagePO(driverRule.getDriver());
        logInPage.logInUser(emailRandom, passwordRandom);

        StartPagePO startPage = new StartPagePO(driverRule.getDriver());
        startPage.checkGoToStartPage();
        String token = startPage.getToken();
        deleteUser(token);
    }

}
