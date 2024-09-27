package android.azadevs.bankingui.components

import android.azadevs.bankingui.data.Finance
import android.azadevs.bankingui.ui.theme.BlueStart
import android.azadevs.bankingui.ui.theme.GreenStart
import android.azadevs.bankingui.ui.theme.OrangeStart
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val finances = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf, name = "My\nBusiness", iconBackgroundColor = OrangeStart
    ), Finance(
        icon = Icons.Rounded.Wallet, name = "My\nWallet", iconBackgroundColor = BlueStart
    ), Finance(
        icon = Icons.Rounded.Analytics, name = "Finance\nAnalytics", iconBackgroundColor = BlueStart
    ), Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        iconBackgroundColor = GreenStart
    )
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FinanceSection(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(16.dp)
        )
        LazyRow {
            items(finances.size) { index ->
                FinanceItem(index = index)
            }
        }
    }
}

@Composable
fun FinanceItem(modifier: Modifier = Modifier, index: Int) {
    val finance = finances[index]
    var lastPadding = 0.dp
    if (index == finances.size - 1) {
        lastPadding = 16.dp
    }
    Box(modifier = modifier.padding(start = 16.dp, end = lastPadding)) {
        Column(modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .size(120.dp)
            .clickable { }
            .padding(13.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.iconBackgroundColor)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}
