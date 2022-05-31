package DataLayerTests;

import BusinessLayer.User.DTO.UserCreateDTO;
import BusinessLayer.User.UserWriter;
import DataLayer.Model.User;
import DataLayer.Repository.UserRepository;
import Util.PasswordHasher;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@EntityScan(basePackages = "DataLayer.Model")
@ContextConfiguration(classes = {UserRepository.class, UserWriter.class})
@EnableJpaRepositories(basePackages = "DataLayer.Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTests {

    // region Private properties


    @Autowired
    private UserRepository users;

    @Autowired
    private UserWriter writer;

    // endregion Private Properties

    // region Public methods

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(users);
    }

    /**
     * Method to create a user.
     */
    @Test
    public void writeUser() {
        UserCreateDTO u;

        u = new UserCreateDTO();
        u.setUserName("testuser");
        u.setPassword("testuser123#");
        u.setUserName("testuser");
        u.setPhoneNumber("111111111");
        u.setEmail("testuser@gmail.com");

        writer.create(u);
    }

    /**
     * Method used to enable the user.
     */
    @Test
    public void insertUser() {
        User u;

        u = new User();
        u.setUserName("testuser");
        u.setPasswordHash(PasswordHasher.encrypt("testuser123#"));
        u.setUserName("testuser");
        u.setPhoneNumber("111111111");
        u.setEmail("testuser@gmail.com");
        System.out.println(users.save(u));
    }

    // endregion Public methods

}
