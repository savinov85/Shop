package ru.savinov.spring.study_shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import ru.savinov.spring.study_shop.controllers.LoginController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudyShopApplicationTest {
    @Autowired
    private LoginController loginController;


    @Test
    void contextLoads() throws Exception {
        assertThat(loginController).isNotNull();

    }

}
