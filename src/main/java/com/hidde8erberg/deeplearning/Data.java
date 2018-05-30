package com.hidde8erberg.deeplearning;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;


public class Data {
    private double r;
    private double g;
    private double b;

    private boolean correct;

    public double getR() {
        return r / 255;
    }

    public double getG() {
        return g / 255;
    }

    public double getB() {
        return b / 255;
    }

    public double isCorrect() {
        if (correct) return 1;
        else return 0;
    }

    public static double[][] getData(){
        URL url = Main.class.getResource("/data.json");
        String path = url.getPath();

        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Data[] data = new Gson().fromJson(reader, Data[].class);
        double[][] input = new double[data.length][4];

        for (int i = 0; i < data.length; i++){
            input[i][0] = data[i].getR();
            input[i][1] = data[i].getG();
            input[i][2] = data[i].getB();
            input[i][3] = data[i].isCorrect();
        }

        return input;
    }
}
