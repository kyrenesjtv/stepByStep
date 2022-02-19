package com.github.kyrenesjtv.stepbystep.designmodel.oo.apiauthentication;

import com.alibaba.fastjson.JSONObject;
import com.github.kyrenesjtv.stepbystep.designmodel.util.TokenUtils;
import lombok.Data;

/**
 * @author huojianxiong
 * @Description AuthToken
 * @Date 2022/2/19 22:58
 */
@Data
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createtime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createtime) {
        this.token = token;
        this.createtime = createtime;
    }

    public AuthToken(String token, long createtime, long expiredTimeInterval) {
        this.token = token;
        this.createtime = createtime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createtime, String appId, String appSecret) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("createtime", createtime);
        jsonObject.put("appId", appId);
        jsonObject.put("appSecret", appSecret);
        String sign = TokenUtils.getSign(jsonObject);
        String token = TokenUtils.getToken(baseUrl + sign);
        AuthToken authToken = new AuthToken(token, createtime);
        return authToken;
    }

    public boolean isExpired() {
        return createtime + expiredTimeInterval < System.currentTimeMillis();
    }

    public boolean match(AuthToken authToken) {
        return token.equals(authToken.getToken());
    }
}
