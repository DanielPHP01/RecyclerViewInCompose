import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recyclerviewincompose.objects.ScreenConstants

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenConstants.CreateNoteScreen.route
    ) {
        composable(ScreenConstants.CreateNoteScreen.route) {
            CreateNoteScreen(
                navigationListOfNote = { navController.navigate(ScreenConstants.ListOfNoteScreen.route) }
            )
        }
        composable(ScreenConstants.ListOfNoteScreen.route) {
            ListOfNotesScreen()
        }
    }
}