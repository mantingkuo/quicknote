package mj.tw.com.quicknote.controller

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import mj.tw.com.quicknote.data.AppDb
import mj.tw.com.quicknote.data.NoteEntity
import mj.tw.com.quicknote.utility.AppState

/**
 * Created by Mandy on 2/18/18.
 */
class DbManager {
    companion object {
        val DB_NAME = "note.db"
        lateinit var database: AppDb
        lateinit var notes: LiveData<List<NoteEntity>>
        fun initDbManager() {
            database = Room.databaseBuilder(AppState.appContext, AppDb::class.java, DB_NAME).build()

        }

        fun getAllNote(): LiveData<List<NoteEntity>> {
            notes = DbManager.database.dbAccessMethod().getAllNotes()
            return notes
        }

        fun getNote(index: Int): NoteEntity {
            return notes.value!!.get(index)
        }

        fun addNote(note: NoteEntity) {
            DbManager.database.dbAccessMethod().addNote(note)
        }

        fun updateNote(note: NoteEntity) {
            DbManager.database.dbAccessMethod().updateNote(note)
        }
    }
}