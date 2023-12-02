package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import praktikum.ru.po.LogInPagePO;
import praktikum.ru.po.RegPagePO;
import praktikum.ru.po.StartPagePO;

import java.io.IOException;

import static praktikum.ru.api.DeleteUser.deleteUser;

@DisplayName("Регистрация")
public class RegistrationTest {

    private static String emailRandom = String.format("marfa_'%s'@mail.ru", RandomStringUtils.randomAlphanumeric(3, 5));
    private static String passwordRandom = RandomStringUtils.randomAlphanumeric(6, 8);


    @Rule
    public DriverRule driverRule;

    {
        try {
            driverRule = new DriverRule();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    public void turnOff(){

        LogInPagePO logInPagePO = new LogInPagePO(driverRule.getDriver());
        logInPagePO.logInUser(emailRandom, passwordRandom);

        StartPagePO startPagePO = new StartPagePO(driverRule.getDriver());
        startPagePO.openStartPage();
        String token = startPagePO.getToken();
        deleteUser(token);
    }

}
