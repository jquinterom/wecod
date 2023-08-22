package com.example.wecod.services

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.getSystemService
import com.example.wecod.MainActivity
import com.example.wecod.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MessagingService : FirebaseMessagingService() {

    val TAG = "FirebaseMessagingService"

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d(TAG, message.from.toString())
        if (message.data.isNotEmpty()) {
            Log.d(TAG, "Message data payload: ${message.data}")
        }

        if (message.notification != null) {
            Log.d(TAG, "Message Notification Body: ${message.notification!!.body}")
            createMyNotification(message.notification!!.body)
        } else {
            Log.d(TAG, "Notification is null")
        }
    }

    private fun createMyNotification(message: String?) {
        Log.d(TAG, "Creating notification...")
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val defaultSoundUri  = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val mBuilder = NotificationCompat.Builder(this, "WeCod")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("WeCod News!")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        createNotificationChannel()

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.d(TAG, "You don't have notification permission")
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1235, mBuilder.build())
    }

    private fun createNotificationChannel() {
        Log.d(TAG, "Notification Manager")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Log.d(TAG, "SDK_INT 26+ is OK")
            val name = "wecodnotificationchannel"
            val description = "This is the notification channel for WeCod app"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("Wecod", name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }
}