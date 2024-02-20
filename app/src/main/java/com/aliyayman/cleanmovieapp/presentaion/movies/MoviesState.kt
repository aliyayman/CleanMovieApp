package com.aliyayman.cleanmovieapp.presentaion.movies

import com.aliyayman.cleanmovieapp.domain.model.Movie

data class MoviesState(

    val movies : List<Movie> = emptyList(),
    val isLoading : Boolean = false,
    val error : String = "",
    val search : String = "batman"
) {
}