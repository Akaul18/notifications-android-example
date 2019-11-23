package com.example.notificationpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.notificationpractice.App.CHANNEL_1_ID;
import static com.example.notificationpractice.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      Creating notification manager
        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.title);
        editTextMessage = findViewById(R.id.message);
    }

    public void sendOnChannel1(View v){

        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

//        Creating notification to show
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

//      Telling notificationmanager to notify the notification we just setup
        notificationManager.notify(1, notification);

    }

    public void sendOnChannel2(View v){

        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

//        Creating notification to show
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

//      Telling notificationmanager to notify the notification we just setup
        notificationManager.notify(2, notification);


    }
}
