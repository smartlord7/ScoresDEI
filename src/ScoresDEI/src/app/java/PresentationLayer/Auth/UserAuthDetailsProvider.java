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
    @Autowired
    private UserRepository users;

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
}
