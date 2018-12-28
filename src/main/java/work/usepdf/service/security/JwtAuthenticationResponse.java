package work.usepdf.service.security;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = -2951893594849990664L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
