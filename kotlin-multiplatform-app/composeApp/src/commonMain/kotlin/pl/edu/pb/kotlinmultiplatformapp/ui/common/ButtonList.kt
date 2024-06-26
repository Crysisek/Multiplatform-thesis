package pl.edu.pb.kotlinmultiplatformapp.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.navigation.name

@Composable
fun ButtonList(destinations: List<Destination>, navigateTo: (String) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        destinations.forEach {
            Button(onClick = { navigateTo(it.route) }) {
                Text(text = it.name)
            }
        }
    }
}
