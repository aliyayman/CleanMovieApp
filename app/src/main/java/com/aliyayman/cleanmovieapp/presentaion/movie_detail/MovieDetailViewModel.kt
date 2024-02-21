package com.aliyayman.cleanmovieapp.presentaion.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliyayman.cleanmovieapp.domain.use_case.get_movies.GetMovieDetailsUseCase
import com.aliyayman.cleanmovieapp.util.Constants.IMDB_ID
import com.aliyayman.cleanmovieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val stateHandle: SavedStateHandle

) : ViewModel(){


    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state : State<MovieDetailState> = _state


    init {
        stateHandle.get<String>(IMDB_ID)?.let{
            getMovieDetail(it)
        }
    }

    private fun getMovieDetail(imdbId : String){
        getMovieDetailsUseCase.executeGetMoviesDetails(imdbId).onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = MovieDetailState(movie = it.data)
                }
                is Resource.Error ->{
                    _state.value = MovieDetailState(error = it.message ?: "error")
                }
                is Resource.Loading ->{
                    _state.value = MovieDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}