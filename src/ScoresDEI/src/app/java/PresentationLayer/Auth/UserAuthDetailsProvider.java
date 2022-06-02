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

package PresentationLayer.Auth;

import DataLayer.Model.Role;
import DataLayer.Model.User;
import DataLayer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
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

    public UserDetails getSession() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return (UserDetails) principal;
        }

        return null;
    }

    // endregion Public Methods

}
