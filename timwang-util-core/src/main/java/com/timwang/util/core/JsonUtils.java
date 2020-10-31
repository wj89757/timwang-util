package com.timwang.util.core;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author wangjun
 * @date 2020-10-31
 */
public class JsonUtils {
    protected static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static Gson gson;
    private static JsonParser jsonParser;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss");
        gson = gsonBuilder.create();
        jsonParser = new JsonParser();
    }

    public static String toJson(Object o) {
        if(o == null ){
            return "";
        }
        return gson.toJson(o);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        try {
            return gson.fromJson(json, classOfT);
        }catch (Exception e){
            logger.error("fromJson",e);
            return null;
        }
    }

    public static <T> List<T> fromJsonArray(String json, Class<T> classOfT) {
        if (StringUtils.isEmpty(json)) {
            return Lists.newArrayList();
        }
        JsonArray jsonArray = jsonParser.parse(json).getAsJsonArray();

        List<T> result = Lists.newArrayList();

        for (int i = 0; i < jsonArray.size(); i++) {
            result.add(gson.fromJson(jsonArray.get(i), classOfT));
        }

        return result;
    }

    public static JsonArray parseToJsonArray(String json) {
        return jsonParser.parse(json).getAsJsonArray();
    }
}
