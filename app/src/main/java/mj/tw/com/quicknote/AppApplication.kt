package mj.tw.com.quicknote

import android.app.Application
import mj.tw.com.quicknote.utility.AppState

/**
 * Created by Mandy on 2/19/18.
 */
class AppApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        AppState.appContext = applicationContext
    }
}