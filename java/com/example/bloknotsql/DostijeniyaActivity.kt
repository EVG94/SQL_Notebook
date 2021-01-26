package com.example.bloknotsql

import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bloknotsql.db.MyAdapter
import kotlinx.android.synthetic.main.activity_dostijeniya.*
import java.util.ArrayList

class DostijeniyaActivity : AppCompatActivity() {
    private val movieList = ArrayList<Model>()
    private lateinit var moviesAdapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dostijeniya)


        val MyrecyclerView: RecyclerView = findViewById(R.id.my_recyclerView)
        val addButt = findViewById<ImageButton>(R.id.btn_add)

        val et1 = findViewById<EditText>(R.id.edit_text)
        val et2 = findViewById<EditText>(R.id.edit_text2)
        moviesAdapter = TaskAdapter(movieList)
        val layoutManager = LinearLayoutManager(this)
        MyrecyclerView.layoutManager = layoutManager
        MyrecyclerView.itemAnimator = DefaultItemAnimator()
        MyrecyclerView.adapter = moviesAdapter


        addButt.setOnClickListener {
            val movieString:String = edit_text.text.toString()
            val movie2String:String = edit_text2.text.toString()
            val movie = Model(movieString, "Deadline of : $movie2String")
            movieList.add(movie)
            //  moviesAdapter.notifyItemInserted(id)
            et1.setText("")
            et2.setText("")
            moviesAdapter.notifyDataSetChanged()
        }


        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(moviesAdapter))
        itemTouchHelper.attachToRecyclerView(MyrecyclerView)
    }
}