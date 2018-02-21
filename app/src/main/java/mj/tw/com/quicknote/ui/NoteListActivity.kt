package mj.tw.com.quicknote.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import mj.tw.com.quicknote.R
import mj.tw.com.quicknote.controller.NoteListContract
import mj.tw.com.quicknote.controller.NoteListPresenter
import android.view.View
import android.widget.ProgressBar
import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListActivity : AppCompatActivity(), NoteListContract.View {
    var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var presenter: NoteListPresenter
    lateinit var listView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(findViewById(R.id.toolbar))
        listView = findViewById(R.id.listview)
        layoutManager = LinearLayoutManager(this)
        listView.layoutManager = layoutManager
        presenter = ViewModelProviders.of(this).get(NoteListPresenter::class.java)
        presenter.setView(this)
        GetDataAsync().execute(presenter)
    }

    fun onWriteNote(v: View) {
        var i: Intent = Intent(this, WriteNoteActivity::class.java)
        startActivity(i)
    }

    inner class GetDataAsync : AsyncTask<NoteListPresenter, Void, List<NoteEntity>?>() {
        lateinit var loadingDialog: ProgressBar
        lateinit var presenter: NoteListPresenter
        override fun onPreExecute() {
            super.onPreExecute()
            loadingDialog = ProgressBar(this@NoteListActivity)
            loadingDialog.isIndeterminate = true
            loadingDialog.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: NoteListPresenter?): List<NoteEntity>? {
            presenter = p0.get(0)!!
            return p0.get(0)!!.getData()!!.value
        }

        override fun onPostExecute(result: List<NoteEntity>?) {
            super.onPostExecute(result)
            var adapter = NoteListAdapter(result)
            presenter.getData().observe(this@NoteListActivity, Observer { t ->
                adapter.addNotes(t!!)
            })
            listView.adapter = adapter
            loadingDialog.visibility = View.INVISIBLE
        }
    }
}