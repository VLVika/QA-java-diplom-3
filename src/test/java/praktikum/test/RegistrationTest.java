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

@DisplayName("Регистрация")
public class RegistrationTest {

    private static String emailRandom = String.format("marfa_'%s'@mail.ru", RandomStringUtils.randomAlphanumeric(3, 5));
    private static String passwordRendom = RandomStringUtils.randomAlphanumeric(6, 8);
    private static String nameRandom = String.format("Марфуша_'%s'", RandomStringUtils.randomNumeric(3));

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
        objRegPage.registrationNewUser(nameRandom, emailRandom, passwordRendom);

        objRegPage.checkResultRegistration();

    }

    @After
    public void turnOff(){

        LogInPagePO logInPagePO = new LogInPagePO(driverRule.getDriver());
        logInPagePO.logInUser(emailRandom, passwordRendom);
        System.out.println(emailRandom);

        StartPagePO startPagePO = new StartPagePO(driverRule.getDriver());
        startPagePO.openStartPage();
        startPagePO.getToken();

    }

}
