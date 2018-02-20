package mj.tw.com.quicknote

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.util.Log
import mj.tw.com.quicknote.controller.DbManager
import mj.tw.com.quicknote.data.AppDb
import mj.tw.com.quicknote.data.NoteEntity
import mj.tw.com.quicknote.utility.AppState

/**
 * Created by Mandy on 2/19/18.
 */
class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppState.appContext = applicationContext
        DbManager.initDbManager()

    }
}
