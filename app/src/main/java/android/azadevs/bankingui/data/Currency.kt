package android.azadevs.bankingui.data

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by : Azamat Kalmurzayev
 * 27/09/24
 */
data class Currency(
    val currencyName: String,
    val buy: Float,
    val sell: Float,
    val icon: ImageVector
)
