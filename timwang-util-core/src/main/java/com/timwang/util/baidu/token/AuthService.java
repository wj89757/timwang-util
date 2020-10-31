package com.timwang.util.baidu.token;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.timwang.util.baidu.constant.ParamList;
import com.timwang.util.baidu.constant.UrlList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangjun
 * @date 2020-10-31
 */
public class AuthService {
    private static Logger logger = LoggerFactory.getLogger(AuthService.class);

    public static String getAuth() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "vq4fgRXOe6omHIhGljufTRMD";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "WiWydegfe747uNLHiTDsE2ZdU9UHR6MB";
        return getAuth(clientId, clientSecret);
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     *
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    private static String getAuth(String ak, String sk) {
        // 获取token地址
        String getAccessTokenUrl = String.format(UrlList.AUTH_TOKEN_URL, ak, sk);
        try {
            String result = HttpUtil.get(getAccessTokenUrl);
            return new JSONObject(result).get(ParamList.ACCESS_TOKEN_KEY).toString();
        } catch (Exception e) {
            logger.error("get auth ex", e);
        }
        return null;
    }
}
