package com.example.UIELEMENTSUNIT6

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.remove
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class QueuedSongsActivity : AppCompatActivity() {
    lateinit var adapter: ArrayAdapter<String>
    var songsArray: ArrayList<String> = ArrayList()

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queued_songs)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = intent
        var queuedList = intent.getStringArrayListExtra("queuedList")

        val holder = queuedList!!.toTypedArray()

        for (string in holder){
            songsArray.add(string)
        }


        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val queuedSongsListView: ListView = findViewById<ListView>(R.id.listView)
        queuedSongsListView.adapter = adapter

        registerForContextMenu(queuedSongsListView)

    }

}