package com.example.user.motherearthbinar

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.view_holder_berita1.view.*

class AdapterBerita(context: Context) : RecyclerView.Adapter<AdapterBerita.cardView1>() {

    var mydata = arrayListOf<BeritaModel>()
    var mycontext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardView1 {
        return cardView1(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_berita1, parent, false))
    }

    override fun getItemCount(): Int {
        return mydata.size
    }

    override fun onBindViewHolder(holder: cardView1, position: Int) {
        holder.textJudul.text = mydata[position].judul
        holder.textPara.text = mydata[position].berita
    }

    inner class cardView1(view: View) : RecyclerView.ViewHolder(view) {
        val textJudul : TextView = view.judul
        val textPara : TextView = view.para
    }

    fun update(data : ArrayList<BeritaModel>){
        this.mydata = data
        notifyDataSetChanged()
    }
}
