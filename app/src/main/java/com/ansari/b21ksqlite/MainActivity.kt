package com.ansari.b21ksqlite

import android.content.ContentValues
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var myDbHelper = MyDbHelper(this)

        var database = myDbHelper.writableDatabase



        buttonSave.setOnClickListener(){
            var username = editTextUsername.text.toString()
            var email = editTextEmail.text.toString()

            var contentVal = ContentValues()
            contentVal.put(MyDbHelper.KEY_NAME,username)
            contentVal.put(MyDbHelper.KEY_EMAIL,email)
            database.insert(MyDbHelper.TABLE_CONTACTS,null,contentVal)

            editTextEmail.setText("")
            editTextUsername.setText("")
        }
        buttonShow.setOnClickListener() {

            var cursor: Cursor = database.rawQuery("select * from " + MyDbHelper.TABLE_CONTACTS, null)

            cursor.moveToFirst()

            do {
                var username = cursor.getString(cursor.getColumnIndex(MyDbHelper.KEY_NAME))
                var email = cursor.getString(cursor.getColumnIndex(MyDbHelper.KEY_EMAIL))

                Toast.makeText(this, "Username is : " + username + " email is " + email, Toast.LENGTH_LONG).show()

            } while (cursor.moveToNext())

        }
    }
}
