package mj.tw.com.quicknote.controller

//import android.arch.persistence.room.Room
import android.arch.persistence.room.Room
import android.util.Log
import mj.tw.com.quicknote.data.AppDb
//import mj.tw.com.quicknote.data.AppDb
import mj.tw.com.quicknote.utility.AppState

/**
 * Created by Mandy on 2/18/18.
 */
class DbManager {
    companion object {
        lateinit var database: AppDb
        fun initDbManager() {
            database = Room.databaseBuilder(AppState.appContext, AppDb::class.java, "note.db").build()
        }
    }

//    var db = Room.databaseBuilder(AppState.appContext,
//            AppDb::class.java, "database-name").build()
}