package com.delorme.democonstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListener();
    }

    void setAffichage(String nb) {
        EditText affichage = findViewById(R.id.affichCalc);
        String result = affichage.getText().toString();
        String[] test = {"-", "+", "\u00F7", "\u00D7"};

        for (String i : test) {
            if (nb.equals(i)){
                if (result.charAt(result.length()-1) == i.charAt(0)) {
                    return;
                }
            }
        }

        if (result.equals("0")) {
            affichage.setText(nb);
        } else {
            affichage.setText(result + nb);
        }
    }
    String calculer(String toEval) {
        toEval = toEval.replace("\u00F7", "/");
        toEval = toEval.replace("\u00D7", "*");
        String result = Calculate.eval(toEval);
        String[] test = result.split("\\.");
        if (test.length > 0) {
            if (test[1].equals("0")){
                result = test[0];
            }
        }
        return result;
    }

    void setListener() {
        EditText affichage = findViewById(R.id.affichCalc);
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnEgale = findViewById(R.id.btnEgale);
        Button btnMoins = findViewById(R.id.btnMoins);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnPoint = findViewById(R.id.btnPoint);
        Button btnMultiplier = findViewById(R.id.btnMultiplier);
        Button btnDiviser = findViewById(R.id.btnDiviser);
        Button btnClear = findViewById(R.id.btnClear);

        btn0.setOnClickListener(v -> {
            setAffichage(btn0.getText().toString());
        });
        btn1.setOnClickListener(v -> {
            setAffichage(btn1.getText().toString());
        });
        btn2.setOnClickListener(v -> {
            setAffichage(btn2.getText().toString());
        });
        btn3.setOnClickListener(v -> {
            setAffichage(btn3.getText().toString());
        });
        btn4.setOnClickListener(v -> {
            setAffichage(btn4.getText().toString());
        });
        btn5.setOnClickListener(v -> {
            setAffichage(btn5.getText().toString());
        });
        btn6.setOnClickListener(v -> {
            setAffichage(btn6.getText().toString());
        });
        btn7.setOnClickListener(v -> {
            setAffichage(btn7.getText().toString());
        });
        btn8.setOnClickListener(v -> {
            setAffichage(btn8.getText().toString());
        });
        btn9.setOnClickListener(v -> {
            setAffichage(btn9.getText().toString());
        });
        btnMoins.setOnClickListener(v -> {
            setAffichage(btnMoins.getText().toString());
        });
        btnPlus.setOnClickListener(v -> {
            setAffichage(btnPlus.getText().toString());
        });
        btnPoint.setOnClickListener(v -> {
            setAffichage(btnPoint.getText().toString());
        });
        btnMultiplier.setOnClickListener(v -> {
            setAffichage(btnMultiplier.getText().toString());
        });
        btnDiviser.setOnClickListener(v -> {
            setAffichage(btnDiviser.getText().toString());
        });
        btnEgale.setOnClickListener(v -> {
            String toEval = affichage.getText().toString();
            String result = calculer(toEval);
            affichage.setText(result);
        });
        btnClear.setOnClickListener(v -> {
            affichage.setText("0");
        });
    }
}