package com.tanamo.jetpackandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tanamo.jetpackandroid.room.Word

class WordListAdapter internal constructor(context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Word>() // Cached copy of words

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        holder.wordItemView.text = current.word
    }

    override fun getItemCount() = words.size

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val wordItemView: TextView = itemView.findViewById(R.id.textView)

    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }


}