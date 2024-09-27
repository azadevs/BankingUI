package android.azadevs.bankingui.components

import android.azadevs.bankingui.R
import android.azadevs.bankingui.data.CardItem
import android.azadevs.bankingui.ui.theme.BlueEnd
import android.azadevs.bankingui.ui.theme.BlueStart
import android.azadevs.bankingui.ui.theme.GreenEnd
import android.azadevs.bankingui.ui.theme.GreenStart
import android.azadevs.bankingui.ui.theme.OrangeEnd
import android.azadevs.bankingui.ui.theme.OrangeStart
import android.azadevs.bankingui.ui.theme.PurpleEnd
import android.azadevs.bankingui.ui.theme.PurpleStart
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val cards = listOf(
    CardItem(
        cardType = "VISA",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Business",
        cardBalance = 364.532,
        cardColor = getGradientColor(PurpleStart, PurpleEnd)
    ),
    CardItem(
        cardType = "MASTER CARD",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Savings",
        cardBalance = 547.532,
        cardColor = getGradientColor(BlueStart, BlueEnd)
    ),
    CardItem(
        cardType = "VISA",
        cardNumber = "1234 5678 9012 3456",
        cardName = "School",
        cardBalance = 3.446,
        cardColor = getGradientColor(GreenStart, GreenEnd)
    ),
    CardItem(
        cardType = "MASTER CARD",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Trips",
        cardBalance = 23.446,
        cardColor = getGradientColor(OrangeStart, OrangeEnd)
    ),
)

fun getGradientColor(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CardsSection(modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier.fillMaxWidth()) {
        items(cards.size) { index ->
            CardItem(index = index)
        }
    }
}

@Composable
fun CardItem(modifier: Modifier = Modifier, index: Int) {
    val card = cards[index]
    var lastPadding = 0.dp
    if (index == cards.size - 1) {
        lastPadding = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(modifier = modifier.padding(start = 16.dp, end = lastPadding)) {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(20.dp))
                .background(card.cardColor)
                .width(250.dp)
                .height(150.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = modifier
                    .width(50.dp)
            )

            Spacer(modifier = modifier.height(8.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = modifier.height(8.dp))

            Text(
                text = "$ ${card.cardBalance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = modifier.height(8.dp))

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
