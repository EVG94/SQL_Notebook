package com.example.bloknotsql.db

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bloknotsql.EditActivity
import com.example.bloknotsql.R

class MyAdapter(listMain:ArrayList<ListItem>, context: Context): RecyclerView.Adapter<MyAdapter.MyHolder>() {

    var listArray = listMain
    var myContext = context


    class MyHolder(itemView: View, myContext: Context) : RecyclerView.ViewHolder(itemView) {
        val tvTask = itemView.findViewById<TextView>(R.id.tv_recycler)
        val contextV = myContext

        fun data(item: ListItem){

            tvTask.text = item.task

            itemView.setOnClickListener {
                val intent = Intent(contextV, EditActivity::class.java).apply {

                    putExtra(IntentConstance.I_TASK_KEY, item.task)
                    putExtra(IntentConstance.I_TASK_TITLE, item.title)
                    putExtra(IntentConstance.I_TASK_URI, item.uri)
                }
                contextV.startActivity(intent)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyHolder(inflater, myContext)

    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.data(listArray[position])

    }

    override fun getItemCount(): Int {
        return listArray.size

    }
    fun update(listItems:List<ListItem>){
        listArray.clear()
        listArray.addAll(listItems)
        notifyDataSetChanged()

    }
    fun removeItem(position: Int, dbManager: MyDbManager){

       dbManager.removeItemDB(listArray[position].id.toString())
        listArray.removeAt(position)
       notifyItemRangeChanged(0, listArray.size)
        notifyItemRemoved(position)
        Toast.makeText(myContext, " Задача удалена! ", Toast.LENGTH_SHORT).show()

    }
}