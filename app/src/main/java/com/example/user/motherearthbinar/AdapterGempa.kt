package com.example.user.motherearthbinar

import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.view_holder_gempa.view.*

class AdapterGempa(context: Context) : RecyclerView.Adapter<AdapterGempa.cardView1>() {

    var data = arrayListOf<GempaModel>()
    var mycontext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardView1 {
        return cardView1(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_gempa, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AdapterGempa.cardView1, position: Int) {
        holder.textData.text = data[position].lokasi

        if (data[position].status == "aman") {
            holder.bg_card.setBackgroundColor(mycontext.resources.getColor(R.color.gempaAman))
        } else if (data[position].status == "bahaya") {
            holder.bg_card.setBackgroundColor(mycontext.resources.getColor(R.color.gempaBahaya))
        } else if (data[position].status == "waspada") {
            holder.bg_card.setBackgroundColor(mycontext.resources.getColor(R.color.gempaWaspada))
        }

        // intent  ke detail gempa
        holder.btnDetail.setOnClickListener {
            val intent = Intent(mycontext, DetailGempaActivity::class.java)
            intent.putExtra("data",data[position])
            mycontext.startActivity(intent)
        }
    }


    inner class cardView1(view: View) : RecyclerView.ViewHolder(view) {
        val textData: TextView = view.tempat_gempa
        val btnDetail: Button = view.btn_detail
        var bg_card: ConstraintLayout = view.bg_status
    }


    fun update(data: ArrayList<GempaModel>) {
        this.data = data
        notifyDataSetChanged()
    }
}
