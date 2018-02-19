package mj.tw.com.quicknote.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

/**
 * Created by Mandy on 2/18/18.
 */
@Entity(tableName = "note_content")
class NoteEntity {
    @ColumnInfo(name = "title")
    lateinit var title: String

    @ColumnInfo(name = "content")
    lateinit var content: String

    @ColumnInfo(name = "time")
    var time:Long = 0
}