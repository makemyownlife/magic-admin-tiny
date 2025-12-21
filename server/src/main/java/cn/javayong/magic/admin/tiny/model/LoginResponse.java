package cn.javayong.magic.admin.tiny.model;

import java.util.Map;

/**
 * 登录响应模型
 */
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private Map<String, Object> userInfo;

    // Getters and Setters
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Map<String, Object> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Map<String, Object> userInfo) {
        this.userInfo = userInfo;
    }
}