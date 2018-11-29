package com.foo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserContext {

    private ThreadLocal<AuthUser> authUser = new ThreadLocal<>();

    private int cmp = 0;

    public void clear() {
        this.authUser = null;
        cmp = 0;
    }

    public String getNom(){
        return authUser.get().getNom();
    }

    public void setAuthUser(AuthUser authUser){
        this.authUser.set(authUser);
        cmp++;
    }
}
