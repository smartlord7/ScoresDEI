package PresentationLayer.Auth;

import DataLayer.Model.Role;
import DataLayer.Model.User;
import DataLayer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class UserAuthDetailsProvider implements UserDetailsService {

    // region Private Properties

    @Autowired
    private UserRepository users;

    // endregion Private Properties

    // region Public Methods

    /**
     * Method that gives user details
     * @param userName is the username.
     * @return the details of the user.
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User u = users.findByUserName(userName);

        if (u != null) {
            ArrayList<Role> roles = new ArrayList<Role>(u.getRole());

            return new org.springframework.security.core.userdetails.User(u.getUserName(), u.getPasswordHash(), roles);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
    }

    // endregion Public Methods

}
