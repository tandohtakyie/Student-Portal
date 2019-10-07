package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_portal_main.*
import java.util.*


class AddPortalActivity: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_portal_main)

        addPortal()
    }

    private fun addPortal() {
        addPortalButton.setOnClickListener {
            if (!titleTextField.text.isEmpty()) {
                val link = urlTextField.text.toString()
                val title = titleTextField.text.toString()
                val id = 1
                val newPortal = StudentPortal(id, title, link)
                val intent = Intent(this, MainActivity::class.java)
                println(newPortal.name)
                intent.putExtra("NEW_STUDENT_PORTAL", newPortal)
                setResult(Activity.RESULT_OK, intent)
                this.finish()
            }
        }
    }
}