package com.example.exercise2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel


enum class PengelolaHalaman {
    Home,
    Form,
    Hasil,
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirMahasiswa(
    viewModel: DataViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
    ) { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanHome(onNextButtonClicked = {
                    navController.navigate(PengelolaHalaman.Form.name)
                }
                )
            }
            composable(route = PengelolaHalaman.Form.name) {
                HalamanSatu(
                    onSubmitButtonClicked = { nama, nim, konsentrasi, judulskripsi ->
                        viewModel.setDataMhs(nama, nim, konsentrasi, judulskripsi)
                        navController.navigate(PengelolaHalaman.Hasil.name)
                    },
                    onCancelButtonClicked = {
                        navController.navigate(PengelolaHalaman.Home.name)
                    },
                )
            }
            composable(route = PengelolaHalaman.Hasil.name) {
                HalamanHasil(
                    DataUIState = uiState,
                    onCancelButtonClicked = { cancelOrderAndNavigateToRasa(navController) })
            }
        }
    }
}

private fun cancelOrderAndNavigateToRasa(
    navController: NavHostController
) {
    navController.popBackStack(PengelolaHalaman.Home.name, inclusive = false)
}