package com.aliyayman.cleanmovieapp.presentaion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aliyayman.cleanmovieapp.presentaion.movie_detail.views.MovieDetailScreen
import com.aliyayman.cleanmovieapp.presentaion.movies.views.MovieScreen
import com.aliyayman.cleanmovieapp.ui.theme.CleanMovieAppTheme
import com.aliyayman.cleanmovieapp.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //api key  3422b8d9
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanMovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MovieScreen.route ){
                        composable(route = Screen.MovieScreen.route){

                            MovieScreen(navController = navController)

                        }
                        composable(route = Screen.MovieDetailScreen.route+"/{${IMDB_ID}}"){
                            MovieDetailScreen()
                        }
                    }

                }
            }
        }
    }
}
