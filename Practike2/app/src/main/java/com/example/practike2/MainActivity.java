package com.example.practike2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCurrencyRUS;
    private ArrayList<CurrencyConvertor> currencyConvertors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextCurrencyRUS = findViewById(R.id.editTextRUS);
        currencyConvertors.add(new CurrencyConvertor(findViewById(R.id.editTextCurrencyUSA), findViewById(R.id.textViewCourseUSA), 100.49));
        currencyConvertors.add(new CurrencyConvertor(findViewById(R.id.editTextCurrencyUAH), findViewById(R.id.textViewCourseUAH), 2.74));
        currencyConvertors.add(new CurrencyConvertor(findViewById(R.id.editTextCurrencyPLN), findViewById(R.id.textViewCoursePLN), 23.07));
        currencyConvertors.add(new CurrencyConvertor(findViewById(R.id.editTextCurrencyBYR), findViewById(R.id.textViewCourseBYR), 29.9));
        currencyConvertors.add(new CurrencyConvertor(findViewById(R.id.editTextCurrencyEURO), findViewById(R.id.textViewCourseEURO), 106.1));
        editTextCurrencyRUS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                double value = charSequence.toString().equals("") ? 1 : Double.parseDouble(charSequence.toString());
                for (CurrencyConvertor convertor : currencyConvertors) {
                    convertor.setValueCourseEditText(value);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}