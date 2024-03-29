package com.example.notificationapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notificationapp.databinding.ActivityMain2Binding
import com.example.notificationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // declaring variables
    private lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val notificationId = 1234
    private val channelId = "myapp.notifications"
    private val description = "Notification App Example"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting the notification manager
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager


        binding.notificationBTN.setOnClickListener{

            //creating intent of the next activity
            val intent = Intent(this, MainActivity2::class.java)

            //creating a pending intent of the intent we created before, in case the user clicked on the notification
            //the pending intent will be waiting until the user clicks on the notification.
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            //creating a notification channel for the notification.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationChannel)

                //building the notification
                builder = Notification.Builder(this, channelId)
                    .setContentIntent(pendingIntent)
                    .setContentTitle("My Notification")
                    .setContentText(binding.notificationET.text!!)
            } else {

                // building the notification
                builder = Notification.Builder(this)
                    .setContentIntent(pendingIntent)
                    .setContentTitle("My Notification")
                    .setContentText(binding.notificationET.text!!)
            }
            //executing the notification
            notificationManager.notify(notificationId, builder.build())



        }

    }
}