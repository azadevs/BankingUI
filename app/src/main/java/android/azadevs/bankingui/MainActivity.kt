package android.azadevs.bankingui

import android.azadevs.bankingui.components.BottomNavigationBar
import android.azadevs.bankingui.components.CardsSection
import android.azadevs.bankingui.components.CurrencySection
import android.azadevs.bankingui.components.FinanceSection
import android.azadevs.bankingui.components.WalletSection
import android.azadevs.bankingui.ui.theme.BankingUITheme
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(lightScrim = Color.WHITE, darkScrim = Color.BLACK)
        )
        setContent {
            BankingUITheme {
                HomeScreen()
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            WalletSection()
            CardsSection()
            Spacer(modifier = modifier.height(12.dp))
            FinanceSection()
            CurrencySection()
        }
    }
}