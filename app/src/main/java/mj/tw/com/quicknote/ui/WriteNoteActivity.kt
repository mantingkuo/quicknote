package mj.tw.com.quicknote.ui

import android.icu.util.Calendar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import mj.tw.com.quicknote.R
import mj.tw.com.quicknote.data.NoteEntity
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by Mandy on 2/17/18.
 */
class WriteNoteActivity : AppCompatActivity(){
    lateinit var viewTitle:TextView
    lateinit var viewContent:TextView
    lateinit var viewTime:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_note)
        viewContent = findViewById(R.id.content)
    }
    fun onSave(v:View){
        var currentNote =  NoteEntity()
        currentNote.content = viewContent.text.toString()
        val calendar = Calendar.getInstance()
        currentNote.time = calendar.timeInMillis
//        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    }
}