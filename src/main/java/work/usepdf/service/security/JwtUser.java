package work.usepdf.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser extends User implements UserDetails {

    private static final long serialVersionUID = 6955485316728953833L;

    private Long id;

    public JwtUser(Long id, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userName, password, authorities);
        this.id = id;
    }

    Long getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
