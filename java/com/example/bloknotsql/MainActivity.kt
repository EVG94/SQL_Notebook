package com.example.bloknotsql

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bloknotsql.db.MyAdapter
import com.example.bloknotsql.db.MyDbManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val myDbManager = MyDbManager(this)
    val myAdapter = MyAdapter(ArrayList(), this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        initSearchView()
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDB()
        fillAdapter()


    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()

    }


    fun clickNew(view: View) {

        intent = Intent(this, EditActivity::class.java)
        startActivity(intent)


    }
    fun initSearchView(){



        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(Text: String?): Boolean {
                tvZagolovok.visibility = View.GONE
                val list = myDbManager.readDbData(Text!!)
                myAdapter.update(list)
                return true

            }


        })
    }

    fun init() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val swapHelper = getSwapManager()
        swapHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter = myAdapter

    }

    fun fillAdapter() {
        val list = myDbManager.readDbData("")
        myAdapter.update(list)
        if (list.size > 0) {
            tvNoElement.visibility = View.GONE
        } else {
            tvNoElement.visibility = View.VISIBLE
        }

    }
    fun getSwapManager():ItemTouchHelper{
        return ItemTouchHelper(object : ItemTouchHelper.
        SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                myAdapter.removeItem(viewHolder.adapterPosition, myDbManager)
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

      menuInflater.inflate(R.menu.menu, menu)
        val menuItem = menu!!.findItem(R.id.searchRecycler)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return super.onOptionsItemSelected(item)
    }


}