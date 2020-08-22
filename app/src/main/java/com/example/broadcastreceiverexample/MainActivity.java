package com.example.broadcastreceiverexample;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Създаваме обект "receiver"от клас MyBroadcastReceiver
    MyBroadcastReceiver receiver = new MyBroadcastReceiver();
    IntentFilter intentFilter;
    Button btShow;
    EditText edInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btShow = findViewById(R.id.btShow);
        edInput = findViewById(R.id.edInput);

        // Създаваме филтър за намеренията
        intentFilter = new IntentFilter("com.example.CUSTOM_INTENT");

        // Натискайки бутона - Добавяме действието/текста във филтъра и изпращаме Broadcast с Intent
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textStr = edInput.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("msg", textStr);
                intent.setAction("com.example.CUSTOM_INTENT");
                sendBroadcast(intent);
            }
        });
    }

    // Регистриране на приемника
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    // Отписване на приемника
    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }

}