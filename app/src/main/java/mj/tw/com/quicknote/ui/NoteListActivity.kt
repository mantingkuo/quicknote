package mj.tw.com.quicknote.ui

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import mj.tw.com.quicknote.R
import mj.tw.com.quicknote.controller.NoteListContract
import mj.tw.com.quicknote.controller.NoteListPresenter
import android.support.design.widget.FloatingActionButton
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import mj.tw.com.quicknote.data.NoteEntity
import mj.tw.com.quicknote.utility.AppState

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListActivity : AppCompatActivity(), NoteListContract.View {
    var mLayoutManager: RecyclerView.LayoutManager? = null
    lateinit var mPresenter: NoteListPresenter
    lateinit var mListView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        mListView = findViewById(R.id.listview)
        mLayoutManager = LinearLayoutManager(this)
        mPresenter = NoteListPresenter(this)
        mListView.layoutManager = mLayoutManager

    }

    fun onWriteNote(v:View){
        var i:Intent = Intent(this,WriteNoteActivity::class.java)
        startActivity(i)
    }
    inner class GetDataAsync: AsyncTask<NoteListPresenter, Void, ArrayList<NoteEntity>>() {
        lateinit var loadingDialog: ProgressBar
        override fun onPreExecute() {
            super.onPreExecute()
            loadingDialog.isIndeterminate= true
            loadingDialog.visibility = View.VISIBLE
        }
        override fun doInBackground(vararg p0: NoteListPresenter?): ArrayList<NoteEntity> {
            return p0.get(0)?.getData()!!
        }

        override fun onPostExecute(result: ArrayList<NoteEntity>) {
            super.onPostExecute(result)
            mListView.adapter = NoteListAdapter(mPresenter.getData())
            loadingDialog.visibility = View.INVISIBLE
        }
    }
}