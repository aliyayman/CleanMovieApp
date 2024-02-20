package com.aliyayman.cleanmovieapp.presentaion.movies

sealed class MoviesEvent {
    data class Search(val searchString: String) : MoviesEvent()

}