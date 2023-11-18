package praktikum.test;

import org.junit.Rule;
import org.junit.Test;
import praktikum.ru.po.RegPagePO;

import java.io.IOException;

public class RegistrationTest {

    @Rule
    public DriverRule driverRule = new DriverRule();

    public RegistrationTest() throws IOException {
    }


    @Test
    public void registrationTest() throws InterruptedException {

        RegPagePO objRegPage = new RegPagePO(driverRule.getDriver());
        objRegPage.openRegistrationPage();
        objRegPage.registrationNewUser();
    }

}
