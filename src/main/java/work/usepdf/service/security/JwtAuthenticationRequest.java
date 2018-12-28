package work.usepdf.service.security;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = 2295179794947106273L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JwtAuthenticationRequest() {
    }

    public JwtAuthenticationRequest(String username, String password) {

        this.username = username;
        this.password = password;
    }
}
