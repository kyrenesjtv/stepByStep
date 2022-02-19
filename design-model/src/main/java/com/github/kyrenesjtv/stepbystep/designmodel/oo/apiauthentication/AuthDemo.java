package com.github.kyrenesjtv.stepbystep.designmodel.oo.apiauthentication;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huojianxiong
 * @Description AuthDemo
 * @Date 2022/2/20 00:22
 */
@RestController
@RequestMapping("/demo")
public class AuthDemo {

    @RequestMapping("/test")
    public void testAuth(@RequestBody RequestVO requestVO, HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        ApiRequest apiRequest = new ApiRequest(requestURL.toString(), requestVO);

        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getBaseUrl();

        AuthToken clientToken = new AuthToken(token, timestamp);

        String password = "123";
        AuthToken serverAuthToken = AuthToken.create(originalUrl, timestamp, appId, password);

        if (serverAuthToken.isExpired()) {
            System.out.println("过期");
        }

        if (serverAuthToken.match(clientToken)) {
            System.out.println("不匹配");
        }
    }
}
