package com.github.kyrenesjtv.stepbystep.designmodel.oo.apiauthentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huojianxiong
 * @Description ApiRequest
 * @Date 2022/2/19 23:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String url, RequestVO requestVO) {
        this.baseUrl = url;
        this.token = requestVO.getToken();
        this.appId = requestVO.getAppId();
        this.timestamp = requestVO.getTimestamp();
    }
}
