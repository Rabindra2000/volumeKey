package fawesomeapps.com.nidar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by Rabindra on 10/19/2016.
 */

public class IntentReceiver extends BroadcastReceiver {
    public static boolean wasScreenOn = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("LOB", "onReceive");
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            wasScreenOn = false;
            Log.e("LOB", "wasScreenOn" + wasScreenOn);
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            // and do whatever you need to do here
            wasScreenOn = true;

        } else if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
            Log.e("LOB", "userpresent");
            Log.e("LOB", "wasScreenOn" + wasScreenOn);
            String url = "tel:+9779845434585";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setData(Uri.parse("tel:+9779845434585"));
            context.startActivity(i);

        } else if (intent.getAction().equals(Intent.ACTION_MEDIA_BUTTON)) {
            KeyEvent event = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            if (KeyEvent.KEYCODE_MEDIA_PLAY == event.getKeyCode() && KeyEvent.KEYCODE_VOLUME_DOWN == event.getAction()) {

                Log.e("LOB", "DOwn ");

                
            }
        }


    }
}
