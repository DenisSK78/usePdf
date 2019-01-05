package work.usepdf.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import work.usepdf.service.security.JwtUser;

public interface UserService extends UserDetailsService {
    JwtUser loadUserByUsername(String email);
}
