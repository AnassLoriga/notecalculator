package com.example.notescalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText note1, note2, note3, note4;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);
        note3 = findViewById(R.id.note3);
        note4 = findViewById(R.id.note4);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
            }
        });
    }

    private void calculateAverage() {
        try {
            float n1 = Float.parseFloat(note1.getText().toString());
            float n2 = Float.parseFloat(note2.getText().toString());
            float n3 = Float.parseFloat(note3.getText().toString());
            float n4 = Float.parseFloat(note4.getText().toString());

            if (n1 < 0 || n1 > 20 || n2 < 0 || n2 > 20 || n3 < 0 || n3 > 20 || n4 < 0 || n4 > 20) {
                Toast.makeText(MainActivity.this, "Les notes doivent être entre 0 et 20.", Toast.LENGTH_SHORT).show();
                return;
            }

            float average = (n1 + n2 + n3 + n4) / 4;

            String mention;
            if (average >= 16) {
                mention = "Excellent";
            } else if (average >= 14) {
                mention = "Très bien";
            } else if (average >= 12) {
                mention = "Bien";
            } else if (average >= 10) {
                mention = "Assez bien";
            }else if (average < 10) {
                mention = "Eliminé";
            } else {
                mention = "Échec";
            }

            resultTextView.setText("Moyenne: " + average + "\nMention: " + mention);

        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Veuillez entrer des notes valides.", Toast.LENGTH_SHORT).show();
        }
    }
}
