package wm2.second.assignment.library.controller.impl;

import wm2.second.assignment.library.controller.AuthenticationWS;
import wm2.second.assignment.library.model.RegistrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationWSImpl implements AuthenticationWS {

    protected static Logger log = LoggerFactory.getLogger(AuthenticationWSImpl.class);

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(@RequestHeader("email") String email,
                                @RequestHeader("password") String password) {
        log.info("Email :: {}", email);
        log.info("Password :: {}", password);

        return null;
    }

    @Override
    @RequestMapping(value = "/forget", method = RequestMethod.GET)
    public ResponseEntity forgetPassword(
            @RequestParam(name="email", required = true) String email) {
        log.info("Email :: {}", email);
        return null;
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)// auth
    public ResponseEntity registration(
            @RequestBody RegistrationModel formData) {
        log.info(formData.toString());
        return null;
    }
}
