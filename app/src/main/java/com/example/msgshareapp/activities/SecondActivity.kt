package com.example.msgshareapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString(Constants.USER_MSG_KEY)  //"!!" used cauz we used NULL bundle

        showToast(msg)
        //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        txvUserMessage.text = msg

    }
}