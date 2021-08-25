package com.example.memesocial

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMeme()
        loadMeme()
    }
    private fun loadMeme(){
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

// Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                val imgurl = response.getString("url")
                println(imgurl)

                val memeimg = findViewById<ImageView>(R.id.meme)
                Glide.with(this).load(imgurl).into(memeimg)

                print("shown image")
            },
            Response.ErrorListener { error ->
                print("error")
                // TODO: Handle error
            }
        )
        queue.add(jsonObjectRequest)
    }
    fun shareMeme(view: View) {}
    fun nextMeme(view: View) {}
}