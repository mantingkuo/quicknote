package mj.tw.com.quicknote.controller

import android.util.Log
import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListPresenter : NoteListContract.Presenter {
    lateinit var mView: NoteListContract.View

    constructor(view: NoteListContract.View) {
        mView = view
    }

    override fun getData(): ArrayList<NoteEntity> {
        var array:ArrayList<NoteEntity> = DbManager.db.dbAccessMethod().getAllNotes()
        Log.d("mmm", "len:"+array.size)
        return array
    }
}