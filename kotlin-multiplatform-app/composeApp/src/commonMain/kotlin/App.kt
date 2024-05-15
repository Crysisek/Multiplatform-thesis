import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.navigation.home.homeScreen
import pl.edu.pb.kotlinmultiplatformapp.ui.TopBar
import pl.edu.pb.kotlinmultiplatformapp.ui.theme.KotlinmultiplatformappTheme

@Composable
fun App() {
    KotlinmultiplatformappTheme {
        val navController = rememberNavController()
        val navigateUp = {
            if (navController.currentBackStackEntry?.destination?.route != Destination.Home.route) {
                navController.navigateUp()
            }
        }

        Scaffold(
            topBar = { TopBar(navigateUp) }, // Just for iOS app
        ) {
            NavHost(
                navController = navController,
                startDestination = Destination.Home.route,
                modifier = Modifier.fillMaxSize().padding(it)
            ) {
                homeScreen(navigateTo = navController::navigate)
            }
        }
    }
}
