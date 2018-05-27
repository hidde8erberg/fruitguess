package com.hidde8erberg.fruitguess;

import java.util.Random;
import java.util.concurrent.ExecutionException;

import static java.lang.Math.exp;

public class Network {

    // hidden layer values
    double[] hidden = new double[3];

    // output value
    double output;

    // weights and biases for hidden layer
    double[][] weights = new double[9][3];
    double[] bias = new double[9];

    // weights and bias for output
    double[] weights_o = new double[9];
    double bias_o;

    // init randomizer
    Random rand = new Random();

    private void init() {
        // initialize hidden layer weights
        for(int i = 0; i < weights.length; i++){
            for(int j = 0; j < weights[i].length; j++){
                weights[i][j] = rand.nextDouble();
            }
        }

        // initialize hidden layer biases
        for(int i = 0; i < 3; i++){
            bias[i] = rand.nextDouble();
        }

        // initialize output weights
        for(int i = 0; i < 3; i++){
            weights_o[i] = rand.nextDouble();
        }

        // initialize output bias
        bias_o = rand.nextDouble();

    }

    public double forward_prop(double[] input) {
        if(input.length != 3){
            throw new IllegalArgumentException("input does not have a size of 3");
        }

        double[] hiddenvalues = new double[9];
        double output = bias_o;

        for(int i = 0; i < hiddenvalues.length; i++){
            hiddenvalues[i] = tanh((input[0] * weights[i][0]) + (input[1] * weights[i][1]) + (input[2] * weights[i][2]) + bias[i]);
        }

        for(int i = 0; i < hiddenvalues.length; i++) {
            output += hiddenvalues[i] * weights_o[i];
        }
        return tanh(output);
    }

    public void back_prop() {

    }

    double cost() {
        return forward_prop(input) - wanted;
    }

    double tanh(double n) {
        return Math.tanh(n);
    }

    double act(double n) {
        return 1/(1+exp(-n));
    }

    Network() {
        init();
        double[] test_in = {219/255,61/255,0/255,98/255};

        for(int i = 0; i < weights.length; i++){
            for(int j = 0; j < weights[i].length; j++){
                System.out.println(weights[i][j]);
            }
        }
        //System.out.println(2.9218874559815535E-4*10);
        /*while (true) {
            double test = forward_prop(test_in);
            if (test < 0.001){
                System.out.println(test);
                return;
            }
            init();
        }*/
    }

}
