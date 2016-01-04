package com.piggsoft.response;

/**
 * <br>Created by fire pigg on 2016/01/04.
 *
 * @author piggsoft@163.com
 */
public class TokenRsp extends SuccessRsp {

    private String token;
    private String expireIn;

    public TokenRsp(String token, String expireIn) {
        super();
        this.token = token;
        this.expireIn = expireIn;
    }

    public TokenRsp(String token) {
        super();
        this.token = token;
    }

    public String getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(String expireIn) {
        this.expireIn = expireIn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
