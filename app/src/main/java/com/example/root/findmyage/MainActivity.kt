package com.example.root.findmyage

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.quotes_ticket.view.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val listOfQuotes = ArrayList<Quotes>()
    var adapter:QuotesAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfQuotes.add(Quotes("Dennis","Programming all the way",R.drawable.download))
        listOfQuotes.add(Quotes("Avicci","Wake me up when its all over",R.drawable.skull))
        listOfQuotes.add(Quotes("Kibaki","Bure Kabisaa....Kubaff",R.drawable.kibaki))
        listOfQuotes.add(Quotes("The Dead","I just wanna die ",R.drawable.die))
        listOfQuotes.add(Quotes("Skaters","Skateboaring is the way",R.drawable.board))
        listOfQuotes.add(Quotes("Supreme","Supreme has just killed it",R.drawable.show))
        listOfQuotes.add(Quotes("Boarding","The photo says it all ",R.drawable.crime))

        adapter = QuotesAdapter(this,listOfQuotes)
        listview.adapter = adapter

    }

    class QuotesAdapter:BaseAdapter{
        var listOfQuotes = ArrayList<Quotes>()
        var context:Context?=null
        constructor(context:Context,listOfQuotes:ArrayList<Quotes>):super(){
            this.listOfQuotes = listOfQuotes
            this.context = context
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var quote = listOfQuotes[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myview = inflater.inflate(R.layout.quotes_ticket,null)
            myview.tvname.text = quote.author!!
            myview.quote.text = quote.quote!!
            myview.imageView.setImageResource(quote.image!!)
            myview.imageView.setOnClickListener {
                var intent = Intent(context,QuotesInfo::class.java)
                intent.putExtra("author",quote.author!!)
                intent.putExtra("quote",quote.quote!!)
                intent.putExtra("image",quote.image!!)
                context!!.startActivity(intent)
            }
            return myview
        }

        override fun getItem(position: Int): Any {
           return listOfQuotes[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
          return listOfQuotes.size
        }


    }
}