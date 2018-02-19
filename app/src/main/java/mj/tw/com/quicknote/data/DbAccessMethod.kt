package mj.tw.com.quicknote.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.provider.ContactsContract

/**
 * Created by Mandy on 2/18/18.
 */
@Dao
interface DbAccessMethod {
    @Query("select * from note_content")
    fun getAllNotes():ArrayList<NoteEntity>

    @Insert
    fun addNote(note: NoteEntity)
}