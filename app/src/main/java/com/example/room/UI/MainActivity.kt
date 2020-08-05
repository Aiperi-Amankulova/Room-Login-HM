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
    private var db: DataClass2?=null // благодаря db: DataBaseAbstrct? осушеств передача таблиц

    private var  adapterGrd :GridAdapter? = null  // делаетс глобал, для возможн перезаписать

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = App.app?.getDB()

        recyclers()
    }


    private fun recyclers() {
        val Gridmanager =  GridLayoutManager(applicationContext, 2)   // (Gridmanager -переменная
        recyclerView.layoutManager = Gridmanager            // где recycler это id
        adapterGrd = GridAdapter(this)      //adapterGrd это переменная // (this)  для функции удаления кнопки delete
        recyclerView.adapter = adapterGrd
        val data = db?.getDaoInterf()?.getallEditFromDataclass()

        if (data!=null)                               // проверка что data не = null, т.к adapterGrd.update(data) выходит ошибка
            adapterGrd?.update(data)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add -> {

                this.startActivity(Intent(this, ShowActivity :: class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun itemClicked(data: DataClass) {
        val newdata = db?.getDaoInterf()?.getallEditFromDataclass()
        if (newdata!=null)
            adapterGrd?.update(newdata)
    }
}