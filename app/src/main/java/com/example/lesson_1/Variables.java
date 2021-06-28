package com.example.lesson_1;

import android.widget.EditText;

import java.io.Serializable;

public class Variables implements Serializable {
    public double number_1;
    public double number_2;

    public Variables() {
    }

    public double getNumber_1() {
        return number_1;
    }

    public void setNumber_1(double number_1) {
        this.number_1 = number_1;
    }

    public double getNumber_2() {
        return number_2;
    }

    public void setNumber_2(double number_2) {
        this.number_2 = number_2;
    }
}
