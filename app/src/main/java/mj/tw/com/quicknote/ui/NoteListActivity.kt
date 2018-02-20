package mj.tw.com.quicknote.ui

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import mj.tw.com.quicknote.R
import mj.tw.com.quicknote.controller.NoteListContract
import mj.tw.com.quicknote.controller.NoteListPresenter
import android.view.View
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_note_list.*
import mj.tw.com.quicknote.AppApplication
import mj.tw.com.quicknote.controller.DbManager
import mj.tw.com.quicknote.data.Note
import mj.tw.com.quicknote.data.NoteEntity

//import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListActivity : AppCompatActivity(), NoteListContract.View {
    var mLayoutManager: RecyclerView.LayoutManager? = null
    lateinit var mPresenter: NoteListPresenter
    lateinit var mListView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(findViewById(R.id.toolbar))
        mListView = findViewById(R.id.listview)
        mLayoutManager = LinearLayoutManager(this)
        mListView.layoutManager = mLayoutManager
        mPresenter = ViewModelProviders.of(this).get(NoteListPresenter::class.java)
        mPresenter.setView(this)
        GetDataAsync().execute(mPresenter)
//        mPresenter.getData().observe(this, Observer<ArrayList<NoteEntity>>{ t->mListView.adapter.notifyDataSetChanged()})
    }

    fun onWriteNote(v: View) {
        var i: Intent = Intent(this, WriteNoteActivity::class.java)
        startActivity(i)
    }

    inner class GetDataAsync : AsyncTask<NoteListPresenter, Void, List<NoteEntity>>() {
        lateinit var loadingDialog: ProgressBar
        override fun onPreExecute() {
            super.onPreExecute()
            loadingDialog = ProgressBar(this@NoteListActivity)
            loadingDialog.isIndeterminate = true
            loadingDialog.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: NoteListPresenter?): List<NoteEntity> {
            return p0.get(0)?.getData()!!
        }

        override fun onPostExecute(result: List<NoteEntity>) {
            super.onPostExecute(result)
            mListView.adapter = NoteListAdapter(result)
            loadingDialog.visibility = View.INVISIBLE
        }
    }
}