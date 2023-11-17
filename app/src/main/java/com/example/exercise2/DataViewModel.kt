package com.example.exercise2


import androidx.lifecycle.ViewModel
import com.example.exercise2.data.DataUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

    class DataViewModel : ViewModel() {
        private val _stateUI = MutableStateFlow(DataUIState())
        val stateUI: StateFlow<DataUIState> = _stateUI.asStateFlow()

        fun setDataMhs(nama: String, NIM: String, konsentrasi: String, judulskripsi: String) {
            _stateUI.update { stateSaatIni ->
                stateSaatIni.copy(
                    nama = nama,
                    NIM = NIM,
                    konsentrasi = konsentrasi,
                    judulskripsi = judulskripsi
                )

            }
        }

        fun setDosen(dosenPilihan: String){
            _stateUI.update { stateSaatIni -> stateSaatIni.copy(dosen = dosenPilihan)}
        }
    }
