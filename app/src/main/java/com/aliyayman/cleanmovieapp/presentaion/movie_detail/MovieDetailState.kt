package com.aliyayman.cleanmovieapp.presentaion.movie_detail

import com.aliyayman.cleanmovieapp.domain.model.MovieDetail

data class MovieDetailState (
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error: String = "",
){


}