package com.hidde8erberg.deeplearning;

import java.util.List;
import java.util.Random;
import static java.lang.Math.exp;

public class Network {

    // hidden layer values
    private double[] hidden = new double[3];

    // output value
    private double output;

    // weights and biases for hidden layer
    private double[][] weights = new double[9][3];
    private double[] bias = new double[9];

    // weights and bias for output
    private double[] weights_o = new double[9];
    private double bias_o;

    // init randomizer
    private Random rand = new Random();

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

    // TODO: create backpropagation function
    public void back_prop() {

    }

    // TODO: create cost function
    double cost(double[] input, double correct) {
        return forward_prop(input) - correct;
    }

    double tanh(double n) {
        return Math.tanh(n);
    }

    double act(double n) {
        return 1/(1+exp(-n));
    }

    Network(double[][] input) {
        init();
        double[] test_in = {219/255,61/255,0/255};

        System.out.println(input[1][2]);
        /*for(int i = 0; i < weights.length; i++){
            for(int j = 0; j < weights[i].length; j++){
                System.out.println(weights[i][j]);
            }
        }
        while (true) {
            double test = forward_prop(test_in);
            //System.out.println(test);
            init();
        }*/
    }

}
