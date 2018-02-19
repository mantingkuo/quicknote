package mj.tw.com.quicknote.controller

import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */

interface NoteListContract {
    interface View {}

    interface Presenter {
        fun getData(): ArrayList<NoteEntity>
    }
}