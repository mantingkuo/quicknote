package mj.tw.com.quicknote.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import mj.tw.com.quicknote.R
import mj.tw.com.quicknote.controller.DbManager
import mj.tw.com.quicknote.data.NoteEntity
//import mj.tw.com.quicknote.data.NoteEntity
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by Mandy on 2/17/18.
 */
class WriteNoteActivity : AppCompatActivity() {
    lateinit var viewTitle: TextView
    lateinit var viewContent: TextView
    lateinit var viewTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_note)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = getString(R.string.write_note_title)

        viewContent = findViewById(R.id.content)
    }

    fun onSave(v: View) {
        val t = SaveThread()
        t.start()
        finish()
    }

    fun onCancel(v: View) {
        finish()
    }

    inner class SaveThread : Thread() {
        override fun run() {
            val calendar = Calendar.getInstance()
            var note = NoteEntity(null, "hi note", viewContent.text.toString(), calendar.timeInMillis)
            DbManager.database.dbAccessMethod().addNote(note)
        }
    }
}