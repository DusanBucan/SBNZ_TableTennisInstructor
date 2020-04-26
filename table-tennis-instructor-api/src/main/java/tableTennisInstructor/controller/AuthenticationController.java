package tableTennisInstructor.controller;

import tableTennisInstructor.dto.request.PasswordChangerDTO;
import tableTennisInstructor.dto.response.UserDTO;
import tableTennisInstructor.dto.response.UserTokenDTO;
import tableTennisInstructor.security.TokenUtils;
import tableTennisInstructor.dto.request.LoginDTO;
import tableTennisInstructor.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;


    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid LoginDTO authenticationRequest) {
        return new ResponseEntity<>(userDetailsService.login(authenticationRequest), HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<UserTokenDTO> refreshAuthenticationToken(HttpServletRequest request) {
        return new ResponseEntity<>(userDetailsService.refreshAuthenticationToken(request), HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity changePassword(@RequestBody @Valid PasswordChangerDTO passwordChanger) {
        userDetailsService.changePassword(passwordChanger.getOldPassword(), passwordChanger.getNewPassword());
        return ResponseEntity.ok().build();
    }

}
