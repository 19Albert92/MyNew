package com.example.lesson_1;

public class CanculatorModel {

    private double numb_one;
    private double numb_two;


    public double numb_one() {
        return numb_one;
    }

    public void numb_one(double numb_one) {
        this.numb_one = numb_one;
    }

    public double numb_two() {
        return numb_two;
    }

    public void numb_two(double numb_two) {
        this.numb_two = numb_two;
    }

    public double opMinus(double numb_one, double numb_two) {
        return numb_one - numb_two;
    }

    public double opPlus(double numb_one, double numb_two) {
        return numb_one + numb_two;
    }

    public double opMulti(double numb_one, double numb_two) {
        return numb_one * numb_two;
    }

    public double opDivis(double numb_one, double numb_two) {
        return numb_one / numb_two;
    }
}
