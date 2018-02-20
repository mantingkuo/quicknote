package mj.tw.com.quicknote.controller

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListPresenter : ViewModel(), NoteListContract.Presenter {
    lateinit var contractView: NoteListContract.View
    lateinit var notelist: LiveData<ArrayList<NoteEntity>>

//    constructor(view: NoteListContract.View) {
//       this.view = view
//    }

    override fun getData(): LiveData<ArrayList<NoteEntity>> {
//        if(DbManager.db == null){
//            Log.d("mmm","null")
//        }
        var dbb = DbManager()
        notelist = dbb.db.dbAccessMethod().getAllNotes()
        return notelist
    }

    fun setView(view: NoteListContract.View) {
        contractView = view
    }
}