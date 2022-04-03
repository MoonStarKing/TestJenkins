package com.example.demojenkins.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class MyToken implements AuthenticationToken {

    private String token ;

    public MyToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}
