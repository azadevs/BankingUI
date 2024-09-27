package android.azadevs.bankingui.data

import androidx.compose.ui.graphics.Brush

/**
 * Created by : Azamat Kalmurzayev
 * 27/09/24
 */
data class CardItem(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val cardBalance: Double,
    val cardColor: Brush
)
