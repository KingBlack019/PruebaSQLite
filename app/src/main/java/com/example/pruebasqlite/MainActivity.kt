package com.example.pruebasqlite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebasqlite.Data.LogoApiService
import com.example.pruebasqlite.generalFunctions.ViewModelUsuario
import com.example.pruebasqlite.Screens.LoginScreen
import com.example.pruebasqlite.Screens.MainScreen
import com.example.pruebasqlite.Screens.NavRoute
import com.example.pruebasqlite.Screens.RegisterScreen
import com.example.pruebasqlite.generalFunctions.ViewModelTienda
import com.example.pruebasqlite.ui.theme.PruebaSQLiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaSQLiteTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }

    @Composable
    fun AppNavigation(navController: NavHostController = rememberNavController()) {
        val viewModelUsuario: ViewModelUsuario = viewModel()
        val uiStateUsuario by viewModelUsuario.uiState.collectAsState()

        val viewModelTienda: ViewModelTienda = viewModel()
        val uiStateVshop by viewModelTienda.uiState.collectAsState()

        val logoApiService: LogoApiService = LogoApiService()

        NavHost(navController = navController, startDestination = NavRoute.LOGIN.name){
            composable(NavRoute.LOGIN.name){
                LoginScreen(viewModelUsuario = viewModelUsuario, uiStateUsuario = uiStateUsuario, clickRegister = { navController.navigate(NavRoute.REGISTER.name) }, clickContinue = {navController.navigate(NavRoute.MAIN.name)} )
            }
            composable(NavRoute.REGISTER.name){
                RegisterScreen(viewModelUsuario = viewModelUsuario, uiStateUsuario = uiStateUsuario, clickContinue = { navController.navigate(NavRoute.MAIN.name) })
            }
            composable(NavRoute.MAIN.name){
                MainScreen(viewModelUsuario = viewModelUsuario, uiStateUsuario = uiStateUsuario, viewModelTienda = viewModelTienda, uiStateVshop = uiStateVshop, logoApiService = logoApiService)
            }
        }
    }

}


