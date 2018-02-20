package mj.tw.com.quicknote.controller

import android.arch.lifecycle.LiveData
import mj.tw.com.quicknote.data.Note
import mj.tw.com.quicknote.data.NoteEntity

//import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */

interface NoteListContract {
    interface View {}

    interface Presenter {
        fun getData(): List<NoteEntity>
    }
}