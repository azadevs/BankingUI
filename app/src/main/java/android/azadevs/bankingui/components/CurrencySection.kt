package android.azadevs.bankingui.components

import android.azadevs.bankingui.data.Currency
import android.azadevs.bankingui.ui.theme.GreenStart
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyLira
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.CurrencyYuan
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val currencies = listOf(
    Currency(
        currencyName = "USD", buy = 23.35f, sell = 23.25f, icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        currencyName = "EUR", buy = 13.35f, sell = 13.25f, icon = Icons.Rounded.Euro
    ),
    Currency(
        currencyName = "YEN", buy = 22.35f, sell = 22.25f, icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        currencyName = "YUAN", buy = 23.35f, sell = 23.25f, icon = Icons.Rounded.CurrencyYuan
    ),
    Currency(
        currencyName = "LIRA", buy = 23.35f, sell = 23.25f, icon = Icons.Rounded.CurrencyLira
    ),
)

@Preview
@Composable
fun CurrencySection(
    modifier: Modifier = Modifier
) {

    val isExpanded = remember { mutableStateOf(false) }

    val iconState = remember { mutableStateOf(Icons.Rounded.KeyboardArrowUp) }
    Spacer(modifier = modifier.height(32.dp))
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .animateContentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = modifier
                    .clip(CircleShape)
                    .clickable {
                        isExpanded.value = !isExpanded.value
                        if (isExpanded.value) {
                            iconState.value = Icons.Rounded.KeyboardArrowDown
                        } else {
                            iconState.value = Icons.Rounded.KeyboardArrowUp
                        }
                    }
                    .background(MaterialTheme.colorScheme.secondary)) {
                    Icon(
                        imageVector = iconState.value,
                        contentDescription = "Currencies",
                        modifier = modifier.size(25.dp),
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
                Spacer(modifier = modifier.width(20.dp))
                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )
            if (isExpanded.value) {
                BoxWithConstraints(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {

                    val boxWidth = this.maxWidth / 3

                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                    ) {
                        Spacer(modifier = modifier.height(12.dp))
                        Row(
                            modifier = modifier.fillMaxWidth(),
                        ) {
                            Text(
                                text = "Currency",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                modifier = modifier.width(width = boxWidth),
                                text = "Buy",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.End
                            )
                            Text(
                                modifier = modifier.width(width = boxWidth),
                                text = "Sell",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.End
                            )
                        }

                        Spacer(modifier = modifier.height(8.dp))

                        LazyColumn {
                            items(currencies.size) { index ->
                                CurrencyItem(index = index, width = boxWidth)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencyItem(index: Int, width: Dp, modifier: Modifier = Modifier) {
    val currency = currencies[index]
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .background(GreenStart)
                .padding(4.dp)
        ) {
            Icon(
                imageVector = currency.icon,
                contentDescription = currency.currencyName,
                modifier = modifier.size(18.dp),
                tint = Color.White
            )
        }
        Text(
            modifier = modifier
                .width(width = width)
                .padding(start = 10.dp),
            text = currency.currencyName,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            modifier = modifier.width(width = width),
            text = currency.buy.toString(),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            modifier = modifier.width(width = width),
            text = currency.sell.toString(),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
