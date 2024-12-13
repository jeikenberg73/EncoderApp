package com.example.encoderapp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.encoderapp.R
import com.example.encoderapp.ui.theme.EncoderAppTheme
import com.example.encoderapp.util.MainTopBar
import com.example.encoderapp.viewmodel.EncodeDecodeViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    encodeDecodeViewModel: EncodeDecodeViewModel?
) {
    /**
     * This is the composable state string that holds the input string to be encoded.
     */
    var stringToEncode: String by rememberSaveable {
        mutableStateOf("")
    }

    /**
     * This is the composable state string that holds the resulting decimal values that are a
     * result of the encoding of the input string.
     */
    var encodedString: String by rememberSaveable {
        mutableStateOf("")
    }

    /**
     * This is the composable state string that holds the resulting string after decoding the
     * decimal values from the encoder.
     */
    var decodedString: String by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        // Title bar
        topBar = {
            MainTopBar(
                title = stringResource(R.string.title)
            )
        },
        contentColor = MaterialTheme.colorScheme.primary
    ) { innerPadding ->
        // Body
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input field
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp),
                value = stringToEncode,
                onValueChange = {
                    stringToEncode = it
                },
                label = { Text(stringResource(R.string.stringToEncode)) }
            )
            // Encoder Button
            Button(
                modifier = Modifier
                    .padding(top = 8.dp),
                onClick = {
                    val encodedStrings = encodeDecodeViewModel?.encodeString(stringToEncode)
                    encodeDecodeViewModel?.let { viewModel ->
                        encodedStrings?.let { encodedStrings ->
                            encodedString = viewModel.getEncodedString(encodedStrings)
                            decodedString = viewModel.decodeStrings(encodedStrings)
                        }
                    }
                }
            ) {
                Text(
                    text = stringResource(R.string.encodeDecodeBtn)
                )
            }
            // Encoded decimal values
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp),
                value = encodedString,
                onValueChange = { },
                label = { Text(stringResource(R.string.encodedLabel)) },
                enabled = false
            )
            // Decoded string
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp),
                value = decodedString,
                onValueChange = { },
                label = { Text(stringResource(R.string.decodedLabel)) },
                enabled = false
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun MainScreenPreview() {
    EncoderAppTheme {
        MainScreen(
            modifier = Modifier,
            null
        )
    }
}