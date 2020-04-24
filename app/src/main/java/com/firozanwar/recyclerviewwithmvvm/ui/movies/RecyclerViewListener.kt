package com.firozanwar.recyclerviewwithmvvm.ui.movies

import android.view.View
import com.firozanwar.recyclerviewwithmvvm.data.model.Movie

interface RecyclerViewListener {

    fun onRecyclerViewItemClick(view: View, movie: Movie)
}