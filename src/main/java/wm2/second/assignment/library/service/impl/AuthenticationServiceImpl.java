package wm2.second.assignment.library.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wm2.second.assignment.library.model.dto.RegistrationModel;
import wm2.second.assignment.library.model.entity.UserEntity;
import wm2.second.assignment.library.repository.UserRepository;
import wm2.second.assignment.library.service.AuthenticationService;

import java.util.concurrent.ExecutionException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    protected static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean registration(RegistrationModel registrationModel) {

        try {
            userRepository.save(new UserEntity(registrationModel));
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public int login(String email, String password) {
        UserEntity user;

        user = userRepository.findFirstByEmail(email);

        if(user != null && user.getId() > 0){
            user = userRepository.findByEmailAndPassword(email, password);

            if(user != null && user.getId() > 0) {
                return 1; // match

            } else return 0; // no match

        }  else return -1; // does not exist at all

    }
}
