package com.fantasy1022.mykotlin.fcm

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v7.app.NotificationCompat
import android.util.Log
import com.fantasy1022.mykotlin.MainActivity
import com.fantasy1022.mykotlin.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


/**
 * Created by fantasyfang on 2017/6/5.
 */
class MyFirebaseMessagingService : FirebaseMessagingService() {

    val TAG = javaClass.simpleName

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        //super.onMessageReceived(p0)
        Log.d(TAG, "From: " + remoteMessage?.notification?.body)
        sendNotification(remoteMessage?.notification?.body)
    }

    fun sendNotification(messageBody: String?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_ic_notification)
                .setContentTitle("FCM Message")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
    }
}