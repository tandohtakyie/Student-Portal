package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val studentPortals: ArrayList<StudentPortal> = ArrayList()
    private var adapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        println("is on create")
        fab.setOnClickListener { view ->
            val intent = Intent(this, AddPortalActivity::class.java)
            this.startActivityForResult(intent, 5 )
        }

        linksRecyclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 3)
        adapter = RecyclerAdapter(studentPortals, this, listener = {
            for( item in studentPortals) {
                if (item.id == it) {

                    val intent = Intent(this, WebviewAppActivity::class.java)
                    intent.putExtra("STUDENT_PORTAL_LINK", item.link)
                    this.startActivity(intent)
                }
            }
        })

        linksRecyclerView.adapter = adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        println("GOT HERE @@@@@@@@@@@@@@############# 1")
        if (requestCode == 5) {
            if (resultCode ==  Activity.RESULT_OK) {
                val  newPortal: StudentPortal = data!!.getParcelableExtra("NEW_STUDENT_PORTAL")
                println(newPortal.name)
                println("GOT HERE @@@@@@@@@@@@@@############# 2")
                studentPortals.add(newPortal)
                adapter?.notifyDataSetChanged()
                println(studentPortals.size)
//                addMock()
                println("GOT HERE @@@@@@@@@@@@@@############# 3")
            }
        }

    }



    private fun addMock() {
        val newPortal = intent.getParcelableExtra<StudentPortal>("NEW_STUDENT_PORTAL")
        studentPortals.add(newPortal)

        adapter?.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
