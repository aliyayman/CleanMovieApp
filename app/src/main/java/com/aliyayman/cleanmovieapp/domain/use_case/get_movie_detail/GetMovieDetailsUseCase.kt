package com.aliyayman.cleanmovieapp.domain.use_case.get_movie_detail

import com.aliyayman.cleanmovieapp.data.remote.dto.toMovieDetail
import com.aliyayman.cleanmovieapp.domain.model.MovieDetail
import com.aliyayman.cleanmovieapp.domain.repository.MovieRepository
import com.aliyayman.cleanmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    fun executeGetMoviesDetails(imdbId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e: IOError) {
            emit(Resource.Error("No internet connection"))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }
    }
}