package com.example.wazkar.recevier;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.wazkar.MainActivity;
import com.example.wazkar.R;
import com.example.wazkar.data_layer.NotificationDataset;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class NotificationReceiver extends BroadcastReceiver {

    private String CHANNEL_ID="Wazkar";







    @Override
    public void onReceive(Context context, Intent intent1) {


        // TODO notification

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.splash)
                .setContentTitle(context.getString(R.string.notification_title))
                .setAutoCancel(true);


        Intent intent =new Intent(context, MainActivity.class);
        PendingIntent pendingIntent =PendingIntent.getActivity(context,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentText(NotificationDataset.getNof());
        builder.setAutoCancel(true);
        builder.setStyle(new NotificationCompat.BigTextStyle());
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSmallIcon(R.drawable.loo);
        builder.setSound(uri);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);








        builder.setContentIntent(pendingIntent);



        Notification notification = builder.build();
        NotificationManagerCompat.from(context).notify(0, notification);





    }
}
