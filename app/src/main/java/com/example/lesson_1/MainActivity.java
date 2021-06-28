package com.example.lesson_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public Button button_number_1, button_number_2, button_number_3, button_number_4, button_number_5, button_number_6, button_number_7, button_number_8, button_number_9;
    public Button cal_minus, cal_plus, cal_multiplication, cal_division, cal_result;
    public Button button_clear, button_clear_1, button_plusMinus, button_zero, button_point;
    public EditText textResult;

    private String operations;
    private double res;
    private CanculatorModel operationCanculator = new CanculatorModel();

    Variables var = new Variables();


    private final static String keyCounters = "Counters";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canculator_layout);
        initial();
        createClickBtnNumber();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(this, "Welcome to my canculator " + name, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(keyCounters, var);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        var = (Variables) savedInstanceState.getSerializable(keyCounters);
        restoreText();
    }

    public void initial() {
        button_number_1 = (Button) findViewById(R.id.button_1);
        button_number_2 = (Button) findViewById(R.id.button_2);
        button_number_3 = (Button) findViewById(R.id.button_3);
        button_number_4 = (Button) findViewById(R.id.button_4);
        button_number_5 = (Button) findViewById(R.id.button_5);
        button_number_6 = (Button) findViewById(R.id.button_6);
        button_number_7 = (Button) findViewById(R.id.button_7);
        button_number_8 = (Button) findViewById(R.id.button_8);
        button_number_9 = (Button) findViewById(R.id.button_9);

        cal_minus = (Button) findViewById(R.id.cal_minus);
        cal_plus = (Button) findViewById(R.id.cal_plus);
        cal_multiplication = (Button) findViewById(R.id.cal_multiplication);
        cal_division = (Button) findViewById(R.id.cal_division);
        cal_result = (Button) findViewById(R.id.cal_result);

        button_clear = (Button) findViewById(R.id.button_clear);
        button_clear_1 = (Button) findViewById(R.id.button_clear_1);
        button_plusMinus = (Button) findViewById(R.id.button_plusMinus);
        button_zero = (Button) findViewById(R.id.button_0);
        button_point = (Button) findViewById(R.id.button_point);

        textResult = (EditText) findViewById(R.id.textResult);
    }

    public void createClickBtnNumber() {
        button_number_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("1");
            }
        });
        button_number_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("2");
            }
        });
        button_number_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("3");
            }
        });
        button_number_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("4");
            }
        });
        button_number_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("5");
            }
        });
        button_number_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("6");
            }
        });
        button_number_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("7");
            }
        });
        button_number_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("8");
            }
        });
        button_number_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("9");
            }
        });
        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.append("0");
            }
        });

        button_plusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText(String.format(Locale.getDefault(), "-%s", textResult.getText().toString())); //"-" + textResult.getText().toString()
            }
        });

        button_clear_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearDownOneSpace();
            }
        });

        button_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textResult.getText().toString().equals("") || textResult == null) {
                    textResult.append("0.");
                } else {
                    textResult.append(".");
                }
            }
        });

        cal_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var.number_1 = Double.parseDouble(textResult.getText().toString());
                if (textResult.getText().length() <= 0) {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.write_number), Toast.LENGTH_SHORT).show();
                } else {
                    operations = "-";
                    hack();
                }
            }
        });
        cal_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var.number_1 = Double.parseDouble(textResult.getText().toString());
                if (textResult.getText().length() <= 0) {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.write_number), Toast.LENGTH_SHORT).show();
                } else {
                    operations = "+";
                    hack();
                }
            }
        });
        cal_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var.number_1 = Double.parseDouble(textResult.getText().toString());
                if (textResult.getText().length() <= 0) {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.write_number), Toast.LENGTH_SHORT).show();
                } else {
                    operations = "*";
                    hack();
                }
            }
        });
        cal_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var.number_1 = Double.parseDouble(textResult.getText().toString());
                if (textResult.getText().length() <= 0) {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.write_number), Toast.LENGTH_SHORT).show();
                } else {
                    operations = "/";
                    hack();
                }
            }
        });

        cal_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var.number_2 = Double.parseDouble(textResult.getText().toString());
                hack();
                result();
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearText();
            }
        });
    }

    public void restoreText() {
        textResult.setText(String.format(Locale.getDefault(), "%s", res));
    }

    public void hack() {
        if (operations == "-") {
            textResult.setText("");
            res = operationCanculator.opMinus(var.number_1, var.number_2);
        } else if (operations == "+") {
            textResult.setText("");
            res = operationCanculator.opPlus(var.number_1, var.number_2);
        } else if (operations == "*") {
            textResult.setText("");
            res = operationCanculator.opMulti(var.number_1, var.number_2);
        } else if (operations == "/") {
            textResult.setText("");
            res = operationCanculator.opDivis(var.number_1, var.number_2);
        }
    }

    public void clearDownOneSpace() {
        String text = textResult.getText().toString();
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
        }
        textResult.setText(text);
    }

    public void result() {
        textResult.setText(String.format(Locale.getDefault(), "%s", res));
    }

    public void clearText() {
        textResult.setText("");
        var.number_1 = 0.0;
        var.number_2 = 0.0;
    }

}
