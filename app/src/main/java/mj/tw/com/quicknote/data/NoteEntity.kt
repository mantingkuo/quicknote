package mj.tw.com.quicknote.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Mandy on 2/18/18.
 */
@Entity(tableName = "note")
data class NoteEntity constructor(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "user_id") var id: Long?,
                                  @ColumnInfo(name = "title") var title: String,
                                  @ColumnInfo(name = "content") var content: String,
                                  @ColumnInfo(name = "time") var time: Long)