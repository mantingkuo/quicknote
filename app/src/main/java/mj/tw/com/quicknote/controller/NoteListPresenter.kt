package mj.tw.com.quicknote.controller

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import mj.tw.com.quicknote.data.Note
import mj.tw.com.quicknote.data.LiveDataNote
import mj.tw.com.quicknote.data.NoteEntity

//import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListPresenter : ViewModel(), NoteListContract.Presenter {
    lateinit var contractView: NoteListContract.View
    lateinit var notelist :  List<NoteEntity>

//    constructor(view: NoteListContract.View) {
//       this.view = view
//    }

    override fun getData(): List<NoteEntity> {
//        if(DbManager.db == null){
//            Log.d("mmm","null")
//        }
//        var dbb = DbManager()
//        notelist = dbb.db.dbAccessMethod().getAllNotes()
        var note = NoteEntity(null,"hi note","here is note content",6666)

        DbManager.database.dbAccessMethod().addNote(note)
        var notes = DbManager.database.dbAccessMethod().getAllNotes()
        for(n in notes){
            Log.d("mmm","aync:"+n.content)
        }
        return notes
    }

    fun setView(view: NoteListContract.View) {
        contractView = view
    }
}