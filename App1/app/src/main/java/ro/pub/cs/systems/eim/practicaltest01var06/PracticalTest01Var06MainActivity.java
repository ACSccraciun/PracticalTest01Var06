package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    private Button play_button;

    private CheckBox hold1, hold2, hold3;

    private EditText numar1, numar2, numar3;

    private boolean hold1_checked, hold2_checked, hold3_checked;

    private Integer scor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        init();

        buttonListeners();

        if (savedInstanceState != null) {
            String saved = savedInstanceState.getString("numar1");
            if (saved != null) {
                numar1.setText(saved);
            }

            saved = savedInstanceState.getString("numar2");
            if (saved != null) {
                numar2.setText(saved);
            }

            saved = savedInstanceState.getString("numar3");
            if (saved != null) {
                numar3.setText(saved);
            }
        }
    }

    private void init() {
        play_button = findViewById(R.id.play_button);

        hold1 = findViewById(R.id.hold1);
        hold2 = findViewById(R.id.hold2);
        hold3 = findViewById(R.id.hold3);

        numar1 = findViewById(R.id.numar1);
        numar2 = findViewById(R.id.numar2);
        numar3 = findViewById(R.id.numar3);

        hold1_checked = false;
        hold2_checked = false;
        hold3_checked = false;

        scor = 0;
    }

    private void launchSecond(ArrayList<String> generated, Integer count_checks) {
        Intent intent = new Intent(PracticalTest01Var06MainActivity.this, PracticalTest01Var06SecondaryActivity.class);


        intent.putExtra("numar1", generated.get(0));
        intent.putExtra("numar2", generated.get(1));
        intent.putExtra("numar3", generated.get(2));

        intent.putExtra("checks", count_checks);
        intent.putExtra("win", Constants.checkWin(generated));


        startActivityForResult(intent, Constants.REQUEST_CODE);
    }

    private void buttonListeners() {
        play_button.setOnClickListener(v -> {
            ArrayList<String> generated = Constants.generateRandom();
            Integer count_checks = 0;

            if (!hold1_checked) {
                numar1.setText(generated.get(0));
            } else {
                count_checks++;
            }
            if (!hold2_checked) {
                numar2.setText(generated.get(1));
            }else {
                count_checks++;
            }
            if (!hold3_checked) {
                numar3.setText(generated.get(2));
            }else {
                count_checks++;
            }

            Integer new_scor = 0;
            if (Constants.checkWin(generated)) {
                new_scor = Constants.winAmount(count_checks);

                if (new_scor != 0) {
                    scor = new_scor;
                    launchSecond(generated, count_checks);
                } else {
                    Toast.makeText(PracticalTest01Var06MainActivity.this, "Score: " + scor.toString(), Toast.LENGTH_SHORT).show();
                }

                scor += new_scor;
            } else {
                Toast.makeText(PracticalTest01Var06MainActivity.this, "Score: " + scor.toString(), Toast.LENGTH_SHORT).show();
            }

            if (scor > 300) {
                Intent intent = new Intent(PracticalTest01Var06MainActivity.this, PracticalTest01Var06Service.class);
                intent.putExtra("scor", scor);
                startService(intent);
            }
        });


        hold1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            hold1_checked = isChecked;
        });

        hold2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            hold2_checked = isChecked;
        });

        hold3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            hold3_checked = isChecked;
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE) {
            Integer value = data.getIntExtra("value", 0);

            Toast.makeText(PracticalTest01Var06MainActivity.this, value.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // outState.putString(KEY_TEXT_VALUE, editText.getText().toString());
        outState.putString("numar1", numar1.getText().toString());
        outState.putString("numar2", numar2.getText().toString());
        outState.putString("numar3", numar3.getText().toString());
    }
}