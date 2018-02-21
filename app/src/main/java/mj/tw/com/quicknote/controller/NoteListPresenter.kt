package mj.tw.com.quicknote.controller

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListPresenter : ViewModel(), NoteListContract.Presenter {
    lateinit var contractView: NoteListContract.View

    override fun getData(): LiveData<List<NoteEntity>> {
        var notes = DbManager.database.dbAccessMethod().getAllNotes()
        return notes
    }

    fun setView(view: NoteListContract.View) {
        contractView = view
    }
}