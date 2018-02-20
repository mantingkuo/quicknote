package mj.tw.com.quicknote.controller

import android.arch.persistence.room.Room
import android.util.Log
import mj.tw.com.quicknote.data.AppDb
import mj.tw.com.quicknote.utility.AppState

/**
 * Created by Mandy on 2/18/18.
 */
class DbManager {
    lateinit var db : AppDb
    init {
         if(AppState.appContext == null){
             Log.e("mmm","ddddddd")

         }else{
             db = Room.databaseBuilder(AppState.appContext,
                     AppDb::class.java, "database-name").build()
         }
    }
//    var db = Room.databaseBuilder(AppState.appContext,
//            AppDb::class.java, "database-name").build()
}