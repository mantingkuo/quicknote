package mj.tw.com.quicknote.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Mandy on 2/18/18.
 */
@Database(entities = arrayOf(NoteEntity::class), version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun dbAccessMethod(): DbAccessMethod
}