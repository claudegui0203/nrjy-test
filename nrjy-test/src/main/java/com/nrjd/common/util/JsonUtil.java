package com.nrjd.common.util;

import com.google.gson.Gson;

public class JsonUtil {
    public static Gson gson = null;

    public static Gson getGson() {
        gson = new Gson();
        return gson;
    }
}
