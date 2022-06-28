package cca.capitalcityaquatics.aquariuminfo

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme
import java.io.IOException
import java.io.InputStream

@Composable
fun LoadFile(
    file: String
) {
    var dataText by remember {
        mutableStateOf("")
    }
    Column {
        Text(dataText)
    }
    val context = LocalContext.current
    LaunchedEffect(true) {
        kotlin.runCatching {
            val inputStream: InputStream = context.assets.open(file)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            String(buffer)
        }.onSuccess {
            dataText = it
        }.onFailure {
            dataText = "error"
        }
    }
}