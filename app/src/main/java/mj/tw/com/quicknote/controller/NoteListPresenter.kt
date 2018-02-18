package mj.tw.com.quicknote.controller

import android.util.Log
import mj.tw.com.quicknote.Note

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListPresenter : NoteListContract.Presenter {
    lateinit var mView: NoteListContract.View

    constructor(view: NoteListContract.View) {
        mView = view
    }

    override fun getData(): ArrayList<Note> {
        var array = ArrayList<Note>()
        var x = 10
        while (x > 0) {
            var n1 = Note()
            n1.title = "this weeke ddd"
            n1.summary = "sdjkfjldaksfj lafdafd"
            n1.time = 7772882
            array.add(n1)
            x =x-1
        }
        Log.d("mmm", "len:"+array.size)
        return array
    }
}