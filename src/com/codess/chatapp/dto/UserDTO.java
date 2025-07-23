package com.codess.chatapp.dto;

import java.util.Arrays;

public final class UserDTO {
    private final String userid;
    private final char[] password;

    public UserDTO(String userid, char[] password) {
        this.userid = userid;
        this.password = password.clone(); 
    }

    public String getUserid() {
        return userid;
    }

    public char[] getPassword() {
        return password.clone(); 
        }

    public void clearPassword() {
        Arrays.fill(this.password, '\0');
    }
}
