package work.usepdf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import work.usepdf.service.security.AuthenticationException;
import work.usepdf.service.security.JwtAuthenticationRequest;
import work.usepdf.service.security.JwtAuthenticationResponse;
import work.usepdf.service.security.JwtTokenUtil;

import java.util.Objects;

@RestController
public class AuthenticationRestController {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager,
                                        JwtTokenUtil jwtTokenUtil,
                                        @Qualifier("userServiceImpl") UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

//    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
//    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
//        String authToken = request.getHeader(tokenHeader);
//        final String token = authToken.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
//
//        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
//            String refreshedToken = jwtTokenUtil.refreshToken(token);
//            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
//        } else {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String username, String password) throws AuthenticationException {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled!", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Bad credentials!", e);
        }
    }
}


