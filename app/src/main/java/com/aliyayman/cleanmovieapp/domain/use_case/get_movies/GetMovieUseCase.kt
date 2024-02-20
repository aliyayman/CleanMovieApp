package com.aliyayman.cleanmovieapp.domain.use_case.get_movies

import com.aliyayman.cleanmovieapp.data.remote.dto.toMovieList
import com.aliyayman.cleanmovieapp.domain.model.Movie
import com.aliyayman.cleanmovieapp.domain.repository.MovieRepository
import com.aliyayman.cleanmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError

import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    fun executeGetMovies(search: String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))

            } else {
                emit(Resource.Error(message = "No movie found!"))
            }

        } catch (e: IOError) {
            emit(Resource.Error("No internet connection"))

        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }
    }

}