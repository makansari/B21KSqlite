package com.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ansari.b21ksqlite.R

class MyAdapter (val mylist : ArrayList<DataClass>):RecyclerView.Adapter<MyAdapter.MyViewholder> () {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewholder {

        var v : View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewholder(v)
    }

    override fun getItemCount(): Int {

        return mylist.size
    }

    override fun onBindViewHolder(myViewH: MyViewholder, position: Int) {
        var mydata : DataClass = mylist.get(position)
        myViewH.textTitle.text = mydata.name
        myViewH.textGenere.text = mydata.genere
        myViewH.textYear.text = mydata.year

    }

    class MyViewholder(myview : View):RecyclerView.ViewHolder(myview) {
            val textTitle = myview.findViewById<TextView>(R.id.textViewTitle);
        val textYear = myview.findViewById<TextView>(R.id.textViewYear)
        val textGenere = myview.findViewById<TextView>(R.id.textViewGenere)

    }
}