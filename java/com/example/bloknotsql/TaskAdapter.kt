package com.example.bloknotsql

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class TaskAdapter ( val moviesList:ArrayList<Model>) : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {


    private val context: Context? = null

    fun deleteItem(pos:Int){

        moviesList.removeAt(pos)

        notifyItemRemoved(pos)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<TextView>(R.id.tv_rec)
        val description = itemView.findViewById<TextView>(R.id.tv_rec2)
        val cardView = itemView.findViewById<CardView>(R.id.card_recycle)
        // val button = itemView.findViewById<Button>(R.id.btn_del)

        //  val layout = itemView.findViewById<LayoutInflater>(R.id.rel_rec)

    }



    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.my_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

//        holder.cardView.animation = AnimationUtils.loadAnimation(this.context, R.anim.recycler_view_animation)
        val movie = moviesList[position]
        holder.title.text = movie.getTitle()
        holder.description.text = movie.getDescription()
    }




    override fun getItemCount(): Int {
        return moviesList.size
    }


}