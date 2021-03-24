package wm2.second.assignment.library.service;

import wm2.second.assignment.library.model.dto.RegistrationModel;

public interface AuthenticationService {

    boolean registration(RegistrationModel registrationModel);

    int login(String email, String password);

}
