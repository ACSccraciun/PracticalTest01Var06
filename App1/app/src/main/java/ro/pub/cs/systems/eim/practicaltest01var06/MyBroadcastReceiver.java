package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // Verificăm dacă mesajul de difuzare conține o anumită acțiune
        if (intent.getAction() != null) {
            String action = intent.getAction();


            // Jurnalizează mesajul de difuzare în consolă
            Log.d(TAG, "Received broadcast message with action: " + action);
            // Dacă mesajul conține date suplimentare, le puteți accesa folosind metode precum getIntent().getStringExtra(), getIntExtra() etc.
            if (intent.getExtras() != null) {
                String message = intent.getStringExtra("message");
                Integer scor = intent.getIntExtra("scor", 0);
                String date = intent.getStringExtra("date");

                Log.d(TAG, message);
                Log.d(TAG, scor.toString());
                Log.d(TAG, date);

                Toast.makeText(context, message + "; " + scor + "; " + date, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
