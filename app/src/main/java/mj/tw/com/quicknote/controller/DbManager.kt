package mj.tw.com.quicknote.controller

import android.arch.persistence.room.Room
import mj.tw.com.quicknote.data.AppDb
import mj.tw.com.quicknote.utility.AppState

/**
 * Created by Mandy on 2/18/18.
 */
object DbManager {
    var db: AppDb = Room.databaseBuilder(AppState.appContext,
            AppDb::class.java, "database-name").build()
}