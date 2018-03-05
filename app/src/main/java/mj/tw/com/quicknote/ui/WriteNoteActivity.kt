package mj.tw.com.quicknote.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import mj.tw.com.quicknote.R
import mj.tw.com.quicknote.controller.BaseContractView
import mj.tw.com.quicknote.controller.DbManager
import mj.tw.com.quicknote.controller.WriteNoteContract
import mj.tw.com.quicknote.controller.WriteNotePresenter
import mj.tw.com.quicknote.data.NoteEntity
import mj.tw.com.quicknote.utility.Constants
import java.util.*

/**
 * Created by Mandy on 2/17/18.
 */
class WriteNoteActivity : AppCompatActivity(), WriteNoteContract.View {
    lateinit var viewTitle: TextView
    lateinit var viewContent: TextView
    lateinit var presenter: WriteNoteContract.Presenter
    var position = -1
    var noteId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_note)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = getString(R.string.write_note_title)

        viewContent = findViewById(R.id.content)
        viewTitle = findViewById(R.id.title)


        position = intent.getIntExtra(Constants.KEY_POSITION, -1)
        if (position != -1) {
            var note = DbManager.getNote(position)
            viewContent.setText(note.content)
            viewTitle.setText(note.title)
            noteId = note.id!!
        }
        presenter = WriteNotePresenter()
        presenter.setupView(this)
    }

    override fun saveDone() {
        finish()
    }

    fun onSave(v: View) {
        if (viewContent.text.isNotEmpty() || viewTitle.text.isNotEmpty()) {
            var note: NoteEntity
            val calendar = Calendar.getInstance()
            note = if (position == -1) {
                NoteEntity(null, viewTitle.text.toString(), viewContent.text.toString(), calendar.timeInMillis)
            } else {
                NoteEntity(noteId, viewTitle.text.toString(), viewContent.text.toString(), calendar.timeInMillis)
            }
            presenter.saveNote(note, when (position) {
                -1 -> true
                else -> false
            })
        } else {
            Toast.makeText(this, getString(R.string.save_empty), Toast.LENGTH_LONG).show()
        }
    }

    fun onCancel(v: View) {
        finish()
    }
}