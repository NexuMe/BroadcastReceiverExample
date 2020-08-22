package com.example.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    // Методът onReceive(...) се извиква, когато BroadcastReceiver получи съобщение
    @Override
    public void onReceive(Context context, Intent intent) {
            String dataStr = intent.getStringExtra("msg");
            Toast.makeText(context, "BroadcastReceiver Received Message: " + dataStr, Toast.LENGTH_LONG).show();
        }
}
