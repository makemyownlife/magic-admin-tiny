package cn.javayong.magic.admin.tiny.domain;

import lombok.Data;

import java.util.Map;

/**
 * 登录响应模型
 */
@Data
public class LoginResponse {
    private String accessToken;
    private String refreshToken;

    private Long userId = 1L;

    private Long expiresTime;

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
}