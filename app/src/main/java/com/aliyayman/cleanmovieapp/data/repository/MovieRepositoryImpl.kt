package com.aliyayman.cleanmovieapp.data.repository

import com.aliyayman.cleanmovieapp.data.remote.MovieAPI
import com.aliyayman.cleanmovieapp.data.remote.dto.MoviesDetailDto
import com.aliyayman.cleanmovieapp.data.remote.dto.MoviesDto
import com.aliyayman.cleanmovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieAPI
) : MovieRepository{
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbId: String): MoviesDetailDto {
        return api.getMovieDetail(imdbId)
    }
}