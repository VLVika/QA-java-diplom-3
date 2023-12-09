package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Rule;
import org.junit.Test;
import praktikum.ru.po.RegPagePO;

@DisplayName("Регистрация")
public class RegistrationNegativeTest {


    private static String emailRandom = String.format("marfa_'%s'@mail.ru", RandomStringUtils.randomAlphanumeric(3, 5));
    private static String passwordRandom = RandomStringUtils.randomAlphanumeric(3, 5);


    @Rule
    public DriverRule driverRule = new DriverRule();


    @DisplayName("Ошибка регистрации пользователя, ввод пароля меньше 6 символов")
    @Test
    public void registrationNegativeTest() {
        RegPagePO objRegPage = new RegPagePO(driverRule.getDriver());
        objRegPage.openRegistrationPage();
        objRegPage.registrationNewUser(emailRandom, passwordRandom);

        objRegPage.checkErrorRegistration();
    }


}
