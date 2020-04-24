package com.firozanwar.recyclerviewwithmvvm.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firozanwar.recyclerviewwithmvvm.data.repository.MoviesRepository

class MoviesViewModelFactory(private val moviesRepository: MoviesRepository):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(
            moviesRepository
        ) as T
    }
}