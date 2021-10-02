package com.praveen.praveenmessenger

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_messenger.*
import java.net.URLEncoder

class MessengerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messenger)
        onClickSendButton()
    }

    /**
     * Assigned button OnClick listener in this function
     * In this listener we call validate user input
     */
    fun onClickSendButton(){
        sendButton.setOnClickListener {
            validateUserInput()
        }
    }

    /**
     * validating the user input is not empty
     */
    fun validateUserInput(){
        if (etPhoneText.text!!.isEmpty()){
            Toast.makeText(this,"Please enter the valid number",Toast.LENGTH_SHORT).show()
        }else if(etMessageText.text!!.isEmpty()){
            Toast.makeText(this,"Your message is empty",Toast.LENGTH_SHORT).show()
        }else{
            messageSent()
        }
    }

    /**
     * messageSent
     */
    fun messageSent(){
        val intent = Intent(Intent.ACTION_VIEW)
        val num = etPhoneText.text.toString()
        val msg = etMessageText.text.toString()
        val URL = "https://api.whatsapp.com/send?phone=" + num + "&text="+ URLEncoder.encode(msg, "UTF-8")
        intent.setPackage("com.whatsapp")
        intent.data = Uri.parse(URL)
        startActivity(intent)
    }

}