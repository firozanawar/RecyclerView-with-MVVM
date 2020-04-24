package com.firozanwar.recyclerviewwithmvvm.data.repository

import com.firozanwar.recyclerviewwithmvvm.data.SafeApiRequest
import com.firozanwar.recyclerviewwithmvvm.data.network.MoviesApi

class MoviesRepository(
    private val moviesApi: MoviesApi
) : SafeApiRequest() {

    suspend fun getMovies() = apiRequest { moviesApi.getMovies() }

}