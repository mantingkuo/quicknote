package mj.tw.com.quicknote.controller

import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */

interface WriteNoteContract {
    interface View : BaseContractView {
        fun saveDone()
    }

    interface Presenter : BasePresenter {
        fun setupView(view: View)
        fun saveNote(note: NoteEntity, isNew: Boolean)
    }
}