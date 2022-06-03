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

package Main.BusinessLayer.User;

import Main.BusinessLayer.User.DTO.UserListDTO;
import Main.DataLayer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserReader {

    // region Private Properties

    @Autowired
    private UserRepository users;

    // endregion Private Properties

    // region Public Methods

    public List<UserListDTO> getAll() {
        return users.findAll()
                .stream()
                .map(UserTranslator::toListDTO)
                .toList();
    }

    // endregion Public Methods

}
