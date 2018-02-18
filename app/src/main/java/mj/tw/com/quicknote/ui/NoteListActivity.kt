package mj.tw.com.quicknote.ui

import android.content.Intent
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

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListActivity : AppCompatActivity(), NoteListContract.View {
    var mLayoutManager: RecyclerView.LayoutManager? = null
    lateinit var mPresenter: NoteListPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        val listview = findViewById<RecyclerView>(R.id.listview)
        mLayoutManager = LinearLayoutManager(this)
        mPresenter = NoteListPresenter(this)
        listview.layoutManager = mLayoutManager
        listview.adapter = NoteListAdapter(mPresenter.getData())
        Log.d("mmm","da"+listview.adapter.itemCount)
    }

    fun onWriteNote(v:View){
        var i:Intent = Intent(this,WriteNoteActivity::class.java)
        startActivity(i)
    }
}