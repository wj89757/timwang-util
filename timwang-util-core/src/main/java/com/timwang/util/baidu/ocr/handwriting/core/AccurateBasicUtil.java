package com.timwang.util.baidu.ocr.handwriting.core;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.net.URLEncoder;
import cn.hutool.http.HttpUtil;
import com.timwang.util.baidu.constant.UrlList;
import com.timwang.util.baidu.ocr.handwriting.result.HandWritingResult;
import com.timwang.util.baidu.token.AuthService;
import com.timwang.util.core.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * @author wangjun
 * @date 2020-10-31
 */
public class AccurateBasicUtil {
    private static Logger logger = LoggerFactory.getLogger(AccurateBasicUtil.class);

    public static HandWritingResult accurateBasic(String filePath) {
        try {
            byte[] imgData = FileUtil.readBytes(filePath);
            String imgStr = Base64.encode(imgData);
            String imgParam = URLEncoder.createDefault().encode(imgStr, Charset.defaultCharset());
            String accessToken = AuthService.getAuth();
            String result = HttpUtil.post(String.format(UrlList.ACCURATE_BASIC_URL, accessToken), MapUtil.of("image", imgParam));
            return JsonUtils.fromJson(result, HandWritingResult.class);
        } catch (Exception e) {
            logger.error("accurate basic ex", e);
        }
        return null;
    }

    public static void main(String[] args) {
        HandWritingResult handWritingResult = accurateBasic("/Users/wangjun/Downloads/下载.png");
        System.out.println(JsonUtils.toJson(handWritingResult));
    }
}
