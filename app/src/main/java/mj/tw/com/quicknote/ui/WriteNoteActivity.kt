package mj.tw.com.quicknote.ui

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import mj.tw.com.quicknote.R
import mj.tw.com.quicknote.controller.DbManager
import mj.tw.com.quicknote.data.NoteEntity
import mj.tw.com.quicknote.utility.Constants
import java.util.*

/**
 * Created by Mandy on 2/17/18.
 */
class WriteNoteActivity : AppCompatActivity() {
    lateinit var viewTitle: TextView
    lateinit var viewContent: TextView
    lateinit var viewTime: TextView
    var postion = -1
    var noteId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_note)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = getString(R.string.write_note_title)

        viewContent = findViewById(R.id.content)
        viewTitle = findViewById(R.id.title)


        postion = intent.getIntExtra(Constants.KEY_POSITION, -1)
        if (postion != -1) {
            var note = DbManager.getNote(postion)
            viewContent.setText(note.content)
            viewTitle.setText(note.title)
            noteId = note.id!!
        }
    }

    fun onSave(v: View) {
        if (viewContent.text.isNotEmpty() || viewTitle.text.isNotEmpty()) {
            SaveAsync().execute()
        } else {
            Toast.makeText(this, getString(R.string.save_empty), Toast.LENGTH_LONG).show()
        }
    }

    fun onCancel(v: View) {
        finish()
    }

    inner class SaveAsync : AsyncTask<Void, Void, Int>() {
        override fun doInBackground(vararg p0: Void?): Int {
            val calendar = Calendar.getInstance()
            if (postion == -1) {
                var note = NoteEntity(null, viewTitle.text.toString(), viewContent.text.toString(), calendar.timeInMillis)
                DbManager.addNote(note)
            } else {
                var note = NoteEntity(noteId, viewTitle.text.toString(), viewContent.text.toString(), calendar.timeInMillis)
                DbManager.updateNote(note)
            }
            return 0
        }

        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)
            finish()
        }
    }
}