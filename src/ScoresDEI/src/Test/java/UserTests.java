/**------------scoreDEI: Resultados desportivos em direto - WEB FRAMEWORK------------
 University of Coimbra
 Degree in Computer Science and Engineering
 Sistemas Distribuidos
 3rd year, 2nd semester
 Authors:
 Sancho Amaral Simões, 2019217590, uc2019217590@student.uc.pt
 Tiago Filipe Santa Ventura, 2019243695, uc2019243695@student.uc.pt
 Coimbra, 31th May 2022
 */

import Main.BusinessLayer.User.DTO.UserCreateDTO;
import Main.BusinessLayer.User.UserReader;
import Main.BusinessLayer.User.UserWriter;
import Main.DataLayer.Model.User;
import Main.DataLayer.Repository.UserRepository;
import Main.Util.PasswordHasher;
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
                "test",
                "test@test.com",
                "222222222",
                "test123##"
                );
        u.setRoleId((long) 0);
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
