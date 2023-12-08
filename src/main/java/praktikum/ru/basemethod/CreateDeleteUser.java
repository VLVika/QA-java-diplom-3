package praktikum.ru.basemethod;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import praktikum.ru.api.pojo.CreateUserModelRq;
import praktikum.ru.api.steps.CreateUser;

import static praktikum.ru.api.steps.DeleteUser.deleteUser;

public class CreateDeleteUser {

    CreateUser create = new CreateUser();
    private String accessToken;
    protected String email;
    protected String password;

    @Before
    @DisplayName("Создаёт пользователя, получает token")
    public void getToken(){
        var request = CreateUserModelRq.newUser();
        email= request.getEmail() ;
        password = request.getPassword();
        accessToken = create.getTokenNewUser(request);

    }


    @DisplayName("Удаляет пользователя")
    @After
    public void turnOff(){

        deleteUser(accessToken);
    }
}
