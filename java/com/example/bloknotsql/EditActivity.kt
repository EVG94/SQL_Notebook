package com.example.bloknotsql

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bloknotsql.db.IntentConstance
import com.example.bloknotsql.db.MyDbManager
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)
    val imageCode = 10
    var tempImage = "empty"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        myIntent()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode==Activity.RESULT_OK && requestCode== imageCode){
            imageViewForResult.setImageURI(data?.data)
            tempImage = data?.data.toString()
            contentResolver.takePersistableUriPermission(data?.data!!,  Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDB()

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()

    }

    fun onClickNewImage(view: View) {

        imageLayout.visibility = View.VISIBLE
        btn_add_photo.visibility = View.GONE
    }

    fun onClickDeleteImage(view: View) {

        imageLayout.visibility = View.GONE
        btn_add_photo.visibility = View.VISIBLE



    }

    fun onclickChooseImage(view: View) {

      val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "image/*"

        startActivityForResult(intent, imageCode )
    }

    fun onClickSave(view: View) {

        val myTask = etTask.text.toString()
        val myTitle = etTitle.text.toString()
        if (myTask != "" && myTitle != ""){

            myDbManager.insertToDb(myTask, myTitle, tempImage)
            Toast.makeText(this, " Задача успешно добавлена!", Toast.LENGTH_SHORT).show()
            finish()

        }
    }
    fun myIntent(){
        val i = intent
     //   btn_save.visibility = View.GONE
        if (i != null){
            if (i.getStringExtra(IntentConstance.I_TASK_KEY) != null){
                btn_add_photo.visibility = View.GONE
                etTask.setText(i.getStringExtra(IntentConstance.I_TASK_KEY))
                etTitle.setText(i.getStringExtra(IntentConstance.I_TASK_TITLE))


                if (i.getStringExtra(IntentConstance.I_TASK_URI) != "empty"){
                    imageLayout.visibility = View.VISIBLE
                    imageViewForResult.setImageURI(Uri.parse(i.getStringExtra(IntentConstance.I_TASK_URI)))
                    editButton.visibility = View.GONE
                    deleteButton.visibility = View.GONE

                }

            }
        }
    }
}