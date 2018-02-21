package mj.tw.com.quicknote.controller

import android.arch.persistence.room.Room
import mj.tw.com.quicknote.data.AppDb
import mj.tw.com.quicknote.utility.AppState

/**
 * Created by Mandy on 2/18/18.
 */
class DbManager {
    companion object {
        val DB_NAME = "note.db"
        lateinit var database: AppDb
        fun initDbManager() {
            database = Room.databaseBuilder(AppState.appContext, AppDb::class.java, DB_NAME).build()
        }
    }
}