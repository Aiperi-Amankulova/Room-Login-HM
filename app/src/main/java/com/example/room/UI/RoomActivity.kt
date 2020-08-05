package com.example.room.UI

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.room.Data.DataClass
import com.example.room.Data.DataClass2
import com.example.room.R
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity(mainActivity: MainActivity) : AppCompatActivity() {

    private var database: DataClass2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        IntentListener()
        database = Add.add?.getDataBase()
    }

    private fun IntentListener(){
        btnSave.setOnClickListener {
            database?.getDaoInterf()?.insertDataClassEdit(forlistener())
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun forlistener(): DataClass {
        return DataClass(
            etFirst  = etFirst.text.toString(),
            etSecond = etSecond.text.toString()
        )
    }
}