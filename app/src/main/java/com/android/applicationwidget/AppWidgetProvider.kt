package com.android.applicationwidget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class AppWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        for (id in appWidgetIds!!){
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

            val view = RemoteViews(context?.packageName, R.layout.app_widget_layout)
            view.setOnClickPendingIntent(R.id.image, pendingIntent)

            appWidgetManager?.updateAppWidget(id, view)
        }
    }
}