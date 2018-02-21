package mj.tw.com.quicknote.ui

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mj.tw.com.quicknote.R
import mj.tw.com.quicknote.data.NoteEntity
import mj.tw.com.quicknote.utility.Constants
import java.util.*
import java.util.Calendar.*

//import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListAdapter : RecyclerView.Adapter<NoteListAdapter.ViewHolder> {
    var data = listOf<NoteEntity>()
    var context: Context
    val START_INDEX = 0
    val END_INDEX = 20

    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var summary: TextView
        var time: TextView
        var item: View

        init {
            item = view!!
            title = view!!.findViewById(R.id.title)
            summary = view!!.findViewById(R.id.summary)
            time = view!!.findViewById(R.id.time)
        }
    }

    constructor(dataset: List<NoteEntity>?, context: Context) {
        if (dataset != null) {
            data = dataset
        }
        this.context = context
    }

    fun addNotes(notes: List<NoteEntity>) {
        data = notes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.view_note_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var title = data[position].title
        if (title.isNotEmpty()) {
            holder!!.title.visibility = View.VISIBLE
            holder!!.title.text = title
        } else {
            holder!!.title.visibility = View.GONE
        }

        var noteContent = data[position].content
        when (noteContent.length) {
            in START_INDEX..END_INDEX -> noteContent
            else -> {
                noteContent = noteContent.substring(START_INDEX, END_INDEX) + "..."
            }
        }
        holder!!.summary.text = noteContent
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = data[position].time
        val formatter = String.format("%d/%d/%d %d:%d:%d", calendar.get(YEAR),
                calendar.get(MONTH) + 1, calendar.get(DATE), calendar.get(HOUR_OF_DAY),
                calendar.get(MINUTE), calendar.get(SECOND))
        holder!!.time.text = formatter
        holder.item.setOnClickListener({
            var i = Intent(context, WriteNoteActivity::class.java)
            i.putExtra(Constants.KEY_POSITION, position)
            context.startActivity(i)
        })
    }

    override fun getItemCount(): Int {
        return data.size
    }
}