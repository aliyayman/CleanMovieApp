package com.aliyayman.cleanmovieapp.data.remote

import com.aliyayman.cleanmovieapp.data.remote.dto.MoviesDetailDto
import com.aliyayman.cleanmovieapp.data.remote.dto.MoviesDto
import com.aliyayman.cleanmovieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    // https://www.omdbapi.com/?apikey=3422b8d9&s=batman
    // https://www.omdbapi.com/?apikey=3422b8d9&i=tt1285016

    @GET(".")
    suspend fun  getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey: String = API_KEY
        ) : MoviesDto


    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String = API_KEY
    ) : MoviesDetailDto

}