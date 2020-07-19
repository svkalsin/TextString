package com.example.textstring;

mport androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnZiro;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnDecimal;

    String tempValue = "";
    String tempAction = "";
    Button btnReset;
    Button btnSign;
    Button btnPercent;
    Button btnDivision;
    Button btnMultiplication;
    Button btnSubtraction;
    Button btnAddition;
    Button btnEqually;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        tvResult = findViewById(R.id.tv_result);
        initButtons();
        initFunctionButtons();

    }

    private void initButtons() {

        btnZiro = findViewById(R.id.btn_ziro);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        btnFive = findViewById(R.id.btn_five);
        btnSix = findViewById(R.id.btn_six);
        btnSeven = findViewById(R.id.btn_seven);
        btnEight = findViewById(R.id.btn_eight);
        btnNine = findViewById(R.id.btn_nine);
        btnDecimal = findViewById(R.id.btn_decimal);

        btnZiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("0");
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult("9");
            }
        });
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult(".");
            }
        });
    }

    private void setTextResult(String number) {
        String result = tvResult.getText().toString();
        if ("0".equals(result) && !".".equals(number)) {
            tvResult.setText(number);
        } else {
            if (".".equals(number) && result.contains(".")) {
                return;
            }
            tvResult.append(number);
        }
    }

    private void initFunctionButtons() {

        btnReset = findViewById(R.id.btn_reset);
        btnSign = findViewById(R.id.btn_sign);
        btnPercent = findViewById(R.id.btn_percent);
        btnDivision = findViewById(R.id.btn_division);
        btnMultiplication = findViewById(R.id.btn_multiplication);
        btnSubtraction = findViewById(R.id.btn_subtraction);
        btnAddition = findViewById(R.id.btn_addition);
        btnEqually = findViewById(R.id.btn_equally);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempValue = "";
                tempAction = "";
                tvResult.setText("0");
            }
        });

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = tvResult.getText().toString();
                if (result.contains("-")) {
                    tvResult.setText(result.substring(1));
                } else {
                    StringBuffer sb = new StringBuffer(result);
                    sb.insert(0, "-");
                    tvResult.setText(sb);
                }
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = tvResult.getText().toString();
                try {
                    float res = Float.parseFloat(result);
                    tvResult.setText(Float.toString(res / 100));
                } catch (Exception e) {

                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction("/");
            }
        });
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction("*");
            }
        });
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction("-");
            }
        });
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction("+");
            }
        });
        btnEqually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction("=");
            }
        });
    }

    private void executeAction() {
        String result = tvResult.getText().toString();
        try {
            float value = Float.parseFloat(tempValue);
            float res = Float.parseFloat(result);
            switch (tempAction) {
                case "/": {
                    tvResult.setText(Float.toString(value / res));
                    break;
                }
                case "*": {
                    tvResult.setText(Float.toString(value * res));
                    break;
                }
                case "+": {
                    tvResult.setText(Float.toString(value + res));
                    break;
                }
                case "-": {
                    tvResult.setText(Float.toString(value - res));
                    break;
                }
            }
            tempAction = "";
            tempValue = "";
        } catch (Exception e) {

        }
    }

    private void setAction(String action) {
        if (!"".equals(tempAction)) {
            executeAction();
        } else if (!"=".equals(action)) {
            tempAction = action;
            tempValue = tvResult.getText().toString();
            tvResult.setText("0");
        }
    }

}