package clinica.consultorio.service.impl;

import clinica.consultorio.entidades.AppUser;
import clinica.consultorio.entidades.AppUserRole;
import clinica.consultorio.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        userRepository.save(new AppUser("Pablo", "pablo","pablo@pablo.com",hashedPassword, AppUserRole.ADMIN));
        userRepository.save(new AppUser("Leonel", "leonel", "leonel@leonel.com", hashedPassword2, AppUserRole.USER));

    }
}
