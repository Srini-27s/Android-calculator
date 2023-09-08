package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView edt1;
    String input = ""; // Store the input string
    boolean mAddition, mSubtract, mMultiplication, mDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.resultTV);

        // Set click listeners for number buttons
        findViewById(R.id.b0).setOnClickListener(new NumberClickListener("0"));
        findViewById(R.id.b1).setOnClickListener(new NumberClickListener("1"));
        findViewById(R.id.b2).setOnClickListener(new NumberClickListener("2"));
        findViewById(R.id.b3).setOnClickListener(new NumberClickListener("3"));
        findViewById(R.id.b4).setOnClickListener(new NumberClickListener("4"));
        findViewById(R.id.b5).setOnClickListener(new NumberClickListener("5"));
        findViewById(R.id.b6).setOnClickListener(new NumberClickListener("6"));
        findViewById(R.id.b7).setOnClickListener(new NumberClickListener("7"));
        findViewById(R.id.b8).setOnClickListener(new NumberClickListener("8"));
        findViewById(R.id.b9).setOnClickListener(new NumberClickListener("9"));
        findViewById(R.id.bdot).setOnClickListener(new NumberClickListener("."));

        // Set click listeners for operator buttons
        findViewById(R.id.bplus).setOnClickListener(new OperatorClickListener("+"));
        findViewById(R.id.bminus).setOnClickListener(new OperatorClickListener("-"));
        findViewById(R.id.bmul).setOnClickListener(new OperatorClickListener("*"));
        findViewById(R.id.bdiv).setOnClickListener(new OperatorClickListener("/"));

        // Clear button
        findViewById(R.id.bClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = ""; // Clear the input
                edt1.setText("");
            }
        });

        // Equals button
        findViewById(R.id.bequ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.isEmpty()) {
                    calculateResult();
                }
            }
        });
    }

    private class NumberClickListener implements View.OnClickListener {
        private String number;

        public NumberClickListener(String number) {
            this.number = number;
        }

        @Override
        public void onClick(View v) {
            input += number; // Append the number to the input
            edt1.setText(input);
        }
    }

    private class OperatorClickListener implements View.OnClickListener {
        private String operator;

        public OperatorClickListener(String operator) {
            this.operator = operator;
        }

        @Override
        public void onClick(View v) {
            if (!input.isEmpty()) {
                input += operator; // Append the operator to the input
                edt1.setText(input);
            }
        }
    }

    private void calculateResult() {
        if (input.contains("+")) {
            String[] parts = input.split("\\+");
            if (parts.length == 2) {
                float num1 = Float.parseFloat(parts[0]);
                float num2 = Float.parseFloat(parts[1]);
                float result = num1 + num2;
                edt1.setText(String.valueOf(result));
            }
        } else if (input.contains("-")) {
            // Handle subtraction
        } else if (input.contains("*")) {
            // Handle multiplication
        } else if (input.contains("/")) {
            // Handle division
        }
    }
}
