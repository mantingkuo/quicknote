package mj.tw.com.quicknote.ui

import android.arch.lifecycle.LiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mj.tw.com.quicknote.R
import mj.tw.com.quicknote.data.NoteEntity

/**
 * Created by Mandy on 2/17/18.
 */
class NoteListAdapter : RecyclerView.Adapter<NoteListAdapter.ViewHolder> {
    var mData : ArrayList<NoteEntity>
    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var summary: TextView
        var time : TextView

        init {
            title = view!!.findViewById(R.id.title)
            summary = view!!.findViewById(R.id.summary)
            time = view!!.findViewById(R.id.time)
        }
    }
    constructor(dataset: LiveData<ArrayList<NoteEntity>>){
        mData = dataset.value!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.view_note_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.title.text = mData[position].title
        holder!!.summary.text = mData[position].content
        holder!!.time.text = mData[position].time.toString()
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}