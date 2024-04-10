package ro.pub.cs.systems.eim.practicaltest01var06;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Date;

public class PracticalTest01Var06Service extends Service {

    private static final long DELAY_MILLIS = 2000;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            Thread.sleep(DELAY_MILLIS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Intent broadcastIntent1 = new Intent("action1");
        broadcastIntent1.putExtra("date", new Date().toString());
        broadcastIntent1.putExtra("scor", intent.getIntExtra("scor", 0));
        broadcastIntent1.putExtra("message", "Victory!");
        sendBroadcast(broadcastIntent1);

        return START_NOT_STICKY;
    }
}
