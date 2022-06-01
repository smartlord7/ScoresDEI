import BusinessLayer.User.DTO.UserCreateDTO;
import BusinessLayer.User.UserReader;
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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@EntityScan(basePackages = "DataLayer.Model")
@ContextConfiguration(classes = {UserRepository.class, UserWriter.class, UserReader.class})
@EnableJpaRepositories(basePackages = "DataLayer.Repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTests {

    // region Private properties

    @Autowired
    private UserRepository users;

    @Autowired
    private UserWriter writer;

    @Autowired
    private UserReader reader;

    // endregion Private Properties

    // region Public methods

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(users);
    }

    /**
     * Test for the creation of a user.
     */
    @Test
    @Rollback(false)
    public void create() {
        UserCreateDTO u;

        u = new UserCreateDTO(
                "admin",
                "admin@admin.com",
                "111111111",
                "admin123#"
                );
        writer.create(u);
    }

    /**
     * Test for the insertion of the user.
     */
    @Test
    public void create_() {
        User u;

        u = new User();
        u.setUserName("testuser");
        u.setPasswordHash(PasswordHasher.encrypt("testuser123#"));
        u.setPhoneNumber("111111111");
        u.setEmail("testuser@gmail.com");
        System.out.println(users.save(u));
    }

    @Test
    public void getAll() {
        System.out.println(reader.getAll());
    }

    // endregion Public methods

}
