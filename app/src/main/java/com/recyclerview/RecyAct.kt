package com.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ansari.b21ksqlite.R
import org.json.JSONArray
import org.json.JSONObject

class RecyAct : AppCompatActivity() {
    val dataUsers = ArrayList<DataClass>()
    val url = "https://api.androidhive.info/contacts/"

    companion object {
        val TAG = RecyAct::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recy)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        //addData()




        var stringReq = StringRequest(Request.Method.POST,url, Response.Listener {
            Log.i("mytag",it)
            var jsonObject = JSONObject(it)
            var mycontacts = jsonObject.getJSONArray("contacts")
            for(i in 0 until (mycontacts.length()) ){

                var data = mycontacts.getJSONObject(i)
                var title = data.getString("name")
                var genere = data.getString("email")
                var year = data.getString("id")



                dataUsers.add(DataClass(title,genere,year))

            }
            var myAdapter = MyAdapter(dataUsers)
            recyclerView.adapter = myAdapter

        }, Response.ErrorListener {

        })

        var requestQ = Volley.newRequestQueue(this)
        requestQ.add(stringReq)
    }

    fun addData(){
        dataUsers.add(DataClass("ansari","2007","test"))
        dataUsers.add(DataClass("abdul","2017","test22"))
    }
}
