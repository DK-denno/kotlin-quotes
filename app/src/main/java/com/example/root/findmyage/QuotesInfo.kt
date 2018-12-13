package com.example.root.findmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quotes_info.*

class QuotesInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes_info)

        val bundle: Bundle = intent.extras
        var author = bundle.getString("author")
        var quote = bundle.getString("quote")
        var image = bundle.getInt("image")
        imgvw.setImageResource(image)
        tvname.text = author
        tvquote.text = quote
    }
}
