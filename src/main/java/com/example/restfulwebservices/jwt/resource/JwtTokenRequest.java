package com.example.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

    //{
    //    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkZWZhdWx0IiwiZXhwIjoxNjQ2NDQzNDM4LCJpYXQiOjE2NDU4Mzg2Mzh9.D1os-cE0MKL5k6oKOt3D8zYSpGsm-mPc2DpkkloaEi_2ZFgZegRdTKjAkZ71jKLH9GkNliFbny0976uAPQo6nw"
    //}

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
