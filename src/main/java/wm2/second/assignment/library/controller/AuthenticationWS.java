package wm2.second.assignment.library.controller;

import wm2.second.assignment.library.model.dto.RegistrationModel;
import org.springframework.http.ResponseEntity;

public interface AuthenticationWS {
    ResponseEntity login(String email, String password);
    ResponseEntity registration(RegistrationModel formData);
}