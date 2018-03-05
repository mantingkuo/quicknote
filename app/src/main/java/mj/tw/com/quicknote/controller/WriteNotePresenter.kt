package mj.tw.com.quicknote.controller

import android.arch.lifecycle.ViewModel
import android.os.AsyncTask
import android.util.Log
import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class WriteNotePresenter : ViewModel(), WriteNoteContract.Presenter {
    lateinit var view: WriteNoteContract.View
    override fun setupView(view: WriteNoteContract.View) {
        this.view = view
    }

    override fun saveNote(note: NoteEntity, isNew: Boolean) {
        var aync = SaveAsync()
        aync.isNew = isNew
        aync.execute(note)
    }

    inner class SaveAsync : AsyncTask<NoteEntity, Void, Int>() {
        var isNew: Boolean = true
        override fun doInBackground(vararg p0: NoteEntity?): Int {
            if (isNew) {
                DbManager.addNote(p0.get(0)!!)
            } else {
                DbManager.updateNote(p0.get(0)!!)
            }
            return 0
        }

        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)
            view!!.saveDone()
        }
    }
}