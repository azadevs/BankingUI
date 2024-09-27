package android.azadevs.bankingui.components

import android.azadevs.bankingui.data.BottomNavItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

val items = listOf(
    BottomNavItem(
        title = "Home", route = "home", icon = Icons.Rounded.Home
    ), BottomNavItem(
        title = "Wallet", route = "wallet", icon = Icons.Rounded.Wallet
    ), BottomNavItem(
        title = "Notifications", route = "notifications", icon = Icons.Rounded.Notifications
    ), BottomNavItem(
        title = "Account", route = "account", icon = Icons.Rounded.AccountCircle
    )
)

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(selected = index == 0, onClick = {}, icon = {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            },
                label = {
                    Text(
                        text = item.title,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                })
        }
    }
}
