package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {

    private TextView gained_text;
    private Button ok;

    private Integer checks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);

        gained_text = findViewById(R.id.gained_text);
        ok = findViewById(R.id.ok);

        Intent intent = getIntent();

        boolean win = intent.getBooleanExtra("win", false);
        checks = intent.getIntExtra("checks", 3);

        if (win) {
            gained_text.setText("Gained: " + Constants.winAmount(checks));
        }

        ok.setOnClickListener(v -> {
            Intent result = new Intent();

            result.putExtra("value", Constants.winAmount(checks));
            setResult(RESULT_OK, result);
            finish();
        });
    }
}