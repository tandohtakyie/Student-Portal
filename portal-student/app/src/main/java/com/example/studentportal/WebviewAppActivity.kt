package com.example.studentportal

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.portal_webview_main.*

class WebviewAppActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.portal_webview_main)

        val link = intent.getStringExtra("STUDENT_PORTAL_LINK")

        webview_student_portal.setBackgroundColor(Color.YELLOW)
        webview_student_portal.settings.javaScriptEnabled = true
        webview_student_portal.settings.loadWithOverviewMode = true
        webview_student_portal.settings.useWideViewPort = true
        webview_student_portal.loadUrl(link)
    }
}