package com.hessah.myappfornotificationtraning

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater.from
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.NotificationManagerCompat.from
import androidx.core.content.getSystemService
import java.util.Date.from

class MainActivity : AppCompatActivity() {

    private val channel_id = "channel_id"
    private val notification_id=101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotification()
        findViewById<Button>(R.id.button_id).setOnClickListener{sentNotification()}




    }

    fun createNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val name ="Notification Title"
            val descriptionText = "Notification Description"
            val importance :Int = NotificationManager.IMPORTANCE_DEFAULT
            val channel : NotificationChannel= NotificationChannel(channel_id,name, importance)
                .apply {description=descriptionText  }
            val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }

    }
    private fun sentNotification (){

//        val intent:Intent = Int

        val builder =NotificationCompat.Builder(this,channel_id)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Example Title")
            .setContentText("Example Description")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){

            notify(notification_id,builder.build())
        }


    }

}