package com.aliyayman.cleanmovieapp.domain.repository

import com.aliyayman.cleanmovieapp.data.remote.dto.MoviesDetailDto
import com.aliyayman.cleanmovieapp.data.remote.dto.MoviesDto


interface MovieRepository {
    suspend fun getMovies(search: String) : MoviesDto
    suspend fun getMovieDetail(imdbId: String) : MoviesDetailDto
}