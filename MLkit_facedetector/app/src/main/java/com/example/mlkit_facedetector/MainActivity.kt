package com.example.mlkit_facedetector

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button1)
        image=findViewById(R.id.imageview1)
        button.setOnClickListener(View.OnClickListener {
            var intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*");
            startActivityForResult(intent, 2000)
        })
//        button.setOnClickListener() {
//            var intent = Intent(Intent.ACTION_PICK)
//            intent.setType("image/*");
//            startActivityForResult(intent, 2000) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            if(requestCode==2000){
                val currentUri : Uri? =data?.data

                try{
                    val bitmap : Bitmap = MediaStore.Images.Media.getBitmap(contentResolver,currentUri)
                    image?.setImageBitmap(bitmap)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }else{
            Log.d("ActivityResult","error")
        }
    }
    }
}