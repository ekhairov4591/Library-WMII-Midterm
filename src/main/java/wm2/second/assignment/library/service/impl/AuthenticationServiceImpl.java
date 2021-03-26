package wm2.second.assignment.library.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wm2.second.assignment.library.model.dto.RegistrationModel;
import wm2.second.assignment.library.model.entity.UserEntity;
import wm2.second.assignment.library.repository.UserRepository;
import wm2.second.assignment.library.service.AuthenticationService;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    // used to hash password
    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    // used to validate hashed pass with entered plaintext
    private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword)) {
            System.out.println("The password matches.");
            return true;
        } else {
            System.out.println("The password does not match.");
        }
        return false;
    }


    protected static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public int registration(RegistrationModel registrationModel) {

        UserEntity user;

        user = userRepository.findFirstByEmail(registrationModel.getEmail());
        if(user != null) return -1; // -1 if exists
        //logger.info("Email already exists!");

        try {
            // hashing
            registrationModel.setPassword(hashPassword(registrationModel.getPassword()));
            userRepository.save(new UserEntity(registrationModel));
            return 1; // if registered successfully
        }catch (Exception e){
            logger.error(e.getMessage());
            return 0; // if error
        }
    }

    @Override
    public int login(String email, String password) {
        UserEntity user;


       user =  userRepository.findFirstByEmail(email);


        if(user != null && user.getId() > 0){

            if(checkPass(password, user.getPassword())) {
                return 1; // match

            } else return 0; // no match

        }  else return -1; // does not exist at all

    }

    @Override
    public String getNameSurname(String email, String password) {
        UserEntity user;

        user = userRepository.findFirstByEmail(email); // finding by Email

        if (user != null && user.getId() > 0) { // if exists email, finding by matching pass as well

            if(checkPass(password, user.getPassword())){
                return user.getFirstname() + " " + user.getLastname();
            }
        }
        return null;
    }
}