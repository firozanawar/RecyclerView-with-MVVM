package com.firozanwar.recyclerviewwithmvvm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firozanwar.recyclerviewwithmvvm.utils.Coroutines
import com.firozanwar.recyclerviewwithmvvm.data.model.Movie
import com.firozanwar.recyclerviewwithmvvm.data.repository.MoviesRepository
import kotlinx.coroutines.Job

class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()

    private lateinit var job: Job

    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovies() {

        job = Coroutines.ioToMain(
            {
                moviesRepository.getMovies()
            }, {
                _movies.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}
