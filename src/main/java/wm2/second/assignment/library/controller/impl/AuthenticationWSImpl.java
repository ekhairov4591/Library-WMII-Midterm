package wm2.second.assignment.library.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import wm2.second.assignment.library.controller.AuthenticationWS;
import wm2.second.assignment.library.model.dto.RegistrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wm2.second.assignment.library.model.entity.UserEntity;
import wm2.second.assignment.library.repository.UserRepository;
import wm2.second.assignment.library.service.AuthenticationService;
import wm2.second.assignment.library.service.impl.AuthenticationServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthenticationWSImpl implements AuthenticationWS {

    protected static Logger log = LoggerFactory.getLogger(AuthenticationWSImpl.class);

    //injecting service
    @Autowired
    private AuthenticationService authenticationService;


    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(@RequestHeader("email") String email,
                                @RequestHeader("password") String password) {
        log.info("Email :: {}", email);
        log.info("Password :: {}", password);

        int result = authenticationService.login(email, password);

        if (result < 0) { // no match
            return ResponseEntity.notFound().build();
        } else if (result == 0) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        } else if (result < 0) { // does not exist at all
            return (ResponseEntity) ResponseEntity.unprocessableEntity();
        } else { // if 1 then match
            return ResponseEntity.ok("You have been successfully authorized "
                    + authenticationService.getNameSurname(email, password));
        }

    }
/*
    @Override
    @RequestMapping(value = "/forget", method = RequestMethod.GET)
    public ResponseEntity forgetPassword(
            @RequestParam(name="email", required = true) String email) {
        log.info("Email :: {}", email);
        return null;
    }
    */


    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)// auth
    public ResponseEntity registration(
            @RequestBody RegistrationModel formData) {
        log.info(formData.toString());

        // calling registration method
        if (authenticationService.registration(formData) == 1) {
            return ResponseEntity.created(null).build(); // http 201 success
        } else if (authenticationService.registration(formData) == -1) {
            return ResponseEntity.ok("User with this email already exists..."); //match
        } else {
            return ResponseEntity.unprocessableEntity().build(); // any other error
        }
    }
}