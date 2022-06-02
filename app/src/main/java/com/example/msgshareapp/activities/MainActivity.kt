package com.example.msgshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            //Code to be executed when button is clicked
            Log.i("MainActivity","Button was Clicked!")

            //Toast.makeText(this,"Button was Clicked!",Toast.LENGTH_SHORT).show()
            showToast("Button was Clicked!", Toast.LENGTH_LONG) //by default it is short in time by extension
            //The time length was of SHORT type and use ".show()" to print on screen
        }

        btnSendMsgToNextActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()  //take input from user from usermessg and then convert to string to store in message
            //Toast.makeText(this, message,Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {
            val message: String = etUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to: "))
        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)

        }

    }
}