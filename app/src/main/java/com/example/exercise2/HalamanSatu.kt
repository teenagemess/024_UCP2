package com.example.exercise2

import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    onSubmitButtonClicked: (String, String, String) -> Unit,
    onCancelButtonClicked: () -> Unit,
){
    var nama by remember { mutableStateOf("") }
    var NIM by remember { mutableStateOf("") }
    var konsentrasi by remember { mutableStateOf("")}
    var judulskripsi by remember { mutableStateOf("")}

    Column(modifier = Modifier.padding(10.dp)) {
        
        Text(text = "Formulir Pengajuan Skripsi")
        OutlinedTextField(value = nama,
            onValueChange = {nama =it},
            label = { Text(text = "Nama") },
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(value = NIM,
            onValueChange = {NIM =it},
            label = { Text(text = "NIM") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(value = konsentrasi,
            onValueChange = {konsentrasi =it},
            label = { Text(text = "Konsentrasi") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(value = judulskripsi,
            onValueChange = {judulskripsi =it},
            label = { Text(text = "JudulSkripsi") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(onClick = onCancelButtonClicked) {
                Text(text = "Cancel")
            }

            Button(
                onClick = {
                    if (nama.isNotEmpty() && NIM.isNotEmpty() && konsentrasi.isNotEmpty()) {
                        onSubmitButtonClicked(nama, NIM, konsentrasi)
                    }
                }
            ) {
                Text(text = "Next")
            }
        }
    }
}