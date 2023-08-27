package com.ciarabelle.starwars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ciarabelle.starwars.navigation.CHARACTERS
import com.ciarabelle.starwars.navigation.ROOT
import com.ciarabelle.starwars.navigation.navigateToRoot
import com.ciarabelle.starwars.screens.CharactersScreen
import com.ciarabelle.starwars.screens.ResourcesScreen
import com.ciarabelle.starwars.ui.theme.StarWarsTheme
import com.ciarabelle.starwars.viewmodels.StarWarsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarWarsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val viewModel = ViewModelProvider(this)[StarWarsViewModel::class.java]
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = ROOT) {
                        composable(ROOT) {
                            ResourcesScreen(onAction = navController::navigate)
                        }
                        composable(CHARACTERS) {
                            CharactersScreen(onNavigate = navController::navigateToRoot)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StarWarsTheme {
        ResourcesScreen(onAction = {})
    }
}
