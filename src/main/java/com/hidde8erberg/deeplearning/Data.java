package com.hidde8erberg.deeplearning;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.File;

/**
 * Created by hidde8erberg on 28/05/2018.
 */
public class Data {

    Data() {
        Gson gson = new Gson();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data.json").getFile());
        JsonElement element = new JsonParser().parse();
    }
}
