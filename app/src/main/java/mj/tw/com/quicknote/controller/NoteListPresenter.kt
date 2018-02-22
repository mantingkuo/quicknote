package mj.tw.com.quicknote.controller

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListPresenter : ViewModel(), NoteListContract.Presenter {
    lateinit var contractView: NoteListContract.View
    lateinit var notes: LiveData<List<NoteEntity>>
    override fun setupView(view: NoteListContract.View) {
        contractView = view
    }

    override fun getData(index: Int): NoteEntity {
        return notes.value!!.get(index)
    }

    override fun getDatas(): LiveData<List<NoteEntity>> {
        notes = DbManager.getAllNote()
        return notes
    }

    fun setView(view: NoteListContract.View) {
        contractView = view
    }
}