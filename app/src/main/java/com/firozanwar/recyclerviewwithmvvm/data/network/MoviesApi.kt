package com.firozanwar.recyclerviewwithmvvm.data.network

import com.firozanwar.recyclerviewwithmvvm.data.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    @GET("28ab573c6c771d5c6348")
    suspend fun getMovies(): Response<List<Movie>>

    companion object {

        operator fun invoke(): MoviesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.npoint.io/")
                .build()
                .create(MoviesApi::class.java)
        }
    }
}