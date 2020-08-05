package com.example.room.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.room.Data.DataClass
import com.example.room.Data.DataClass2
import com.example.room.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var database: DataClass2? = null
    private var  adapterGrd :RoomActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Add.add?.getDB()

        recyclers()
    }

    private fun recyclers() {
        val Gridmanager =  GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = Gridmanager
        adapterGrd = RoomActivity(this)
        recyclerView.adapter = adapterGrd
        val data = database?.getDaoInterf()?.getallEditFromDataclass()

        if (data!=null)
            adapterGrd?.update(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add -> {

                this.startActivity(Intent(this,  RoomActivity :: class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun itemClicked(data: DataClass) {
        val newdata = database?.getDaoInterf()?.getallEditFromDataclass()
        if (newdata!=null)
            adapterGrd?.update(newdata)
    }
}