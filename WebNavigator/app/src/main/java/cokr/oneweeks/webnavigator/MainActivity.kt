package cokr.oneweeks.webnavigator;
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cokr.oneweeks.webnavigator.ui.theme.WebNavigatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            WebnavigatorTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }

        setContentView(R.layout.activity_main)
        val webView : WebView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.naver.com")
        webView.settings.javaScriptEnabled = true

        // naver
        findViewById<Button>(R.id.button).setOnClickListener {
            webView.loadUrl("https://www.naver.com")
        }
        // op.gg
        findViewById<Button>(R.id.button2).setOnClickListener {
            webView.loadUrl("https://op.gg")
        }
        // minecraft
        findViewById<Button>(R.id.button3).setOnClickListener {
            webView.loadUrl("https://www.minecraft.net/ko-kr")
        }
        // maple story
        findViewById<Button>(R.id.button4).setOnClickListener {
            webView.loadUrl("https://maplestory.nexon.com/Home/Main")
        }

        // back
        findViewById<Button>(R.id.button5).setOnClickListener {
            webView.goBack()
        }
        // reload
        findViewById<Button>(R.id.button6).setOnClickListener {
            webView.reload()
        }
        // forward
        findViewById<Button>(R.id.button7).setOnClickListener {
            webView.goForward()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WebnavigatorTheme {
        Greeting("Android")
    }
}