package praktikum.ru.api.pojo;

import org.apache.commons.lang3.RandomStringUtils;

public class CreateUserModelRq {

    public static CreateUserPojoRq newUser() {
        return CreateUserPojoRq.builder()
                .name(String.format("Маруся %s", RandomStringUtils.randomAlphabetic(5)))
                .email(String.format("marfa_'%s'@mail.ru", RandomStringUtils.randomNumeric(5)))
                .password(RandomStringUtils.randomAlphanumeric(6, 8))
                .build();
    }
}
