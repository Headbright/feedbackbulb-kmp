import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.feedbackbulb.libs.core.FeedbackSDKClient
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var loading by remember { mutableStateOf(false) }
        val coroutineScope = rememberCoroutineScope()
        val sendFeedback: () -> Unit = {
            loading = true
            coroutineScope.launch {
                val client= FeedbackSDKClient("01b7f627-37c0-43f8-8815-2d730f55134b")
                client.sendFeedback("You know Kotlin is awesome, right?")
                loading = false
            }
        }
        
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = sendFeedback) {
                Text("Click me!")
            }
            AnimatedVisibility(loading) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}