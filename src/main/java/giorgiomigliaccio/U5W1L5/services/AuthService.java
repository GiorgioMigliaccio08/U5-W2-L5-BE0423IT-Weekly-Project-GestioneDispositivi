package giorgiomigliaccio.U5W1L5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import giorgiomigliaccio.U5W1L5.entities.utente;
import riccardogulin.u5d11.exceptions.UnauthorizedException;
import giorgiomigliaccio.U5W1L5.payloads.NewUserResponseDTO;

@Service
public class AuthService {
    @Autowired
    UsersService usersService;

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private PasswordEncoder bcrypt;

    public String authenticateUser(UserLoginDTO body) {
        // 1. Verifichiamo che l'email dell'utente sia nel db
        User user = usersService.findByEmail(body.email());

        // 2. In caso affermativo, verifichiamo se la password fornita corrisponde a quella trovata nel db
        if (body.password().equals(user.getPassword())) {
            // 3. Se le credenziali sono OK --> Genere un token JWT e lo ritorno
            return "token";
        } else {
            // 4. Se le credenziali NON sono OK --> 401 (Unauthorized)
            throw new UnauthorizedException("Credenziali non valide!");
        }
    }

    public User save(NewUserDTO body) {
        // Verifico se l'email è già in uso
		/*Optional<User> user = usersDAO.findByEmail(body.getEmail());
		if(user.isPresent()) throw new RuntimeException();*/

        usersDAO.findByEmail(body.email()).ifPresent(user -> {
            throw new BadRequestException("L'email " + user.getEmail() + " è già in uso!");
        });

        User newUser = new User();
        newUser.setSurname(body.surname());
        newUser.setName(body.name());
        newUser.setEmail(body.email());
        // newUser.setPassword(body.password());
        newUser.setPassword(bcrypt.encode(body.password()));
        newUser.setRole(Role.USER);
        return usersDAO.save(newUser);
    }
}