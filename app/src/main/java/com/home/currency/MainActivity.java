package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ntdEditText;
    TextView usResultTextView;
    TextView jpResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingView();
    }
    void bindingView(){
        ntdEditText = findViewById(R.id.enter_ntd_editview);
        usResultTextView = findViewById(R.id.us_textview);
        jpResultTextView = findViewById(R.id.jp_textview);

        Button button = findViewById(R.id.go_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enterText = ntdEditText.getText().toString();
                float ntdFloat;

                try {
                    ntdFloat = Float.parseFloat(enterText);
                }catch (NumberFormatException e) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Problem")
                            .setMessage("Please enter your NTD amount")
                            .setPositiveButton("OK", null)
                            .show();
                    return;
                }
                float usdFloat = ntdFloat * 30.9f;
                usResultTextView.setText(String.valueOf(usdFloat));
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Result")
                        .setMessage("USD is " + usdFloat)
                        .setPositiveButton("OK", null)
                        .show();

            }
        });
    }
}
