import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recyclerviewincompose.data.utils.UIState
import com.example.recyclerviewincompose.domain.model.NoteDomain
import com.example.recyclerviewincompose.presentation.ui.theme.RecyclerViewInComposeTheme
import com.example.recyclerviewincompose.presentation.ui.screen.listofnotes.GetAllNoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun ListOfNotesScreen() {
    val viewModel: GetAllNoteViewModel = hiltViewModel()
    val getAllNoteState by viewModel.getAllNoteState.collectAsState()


    RecyclerViewInComposeTheme {
        when (val state = getAllNoteState) {
            is UIState.Loading -> {
                Text(text = "Loading...")
            }
            is UIState.Success -> {
                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    viewModel.getAllNotes()
                    items(state.data) { note ->
                        NoteItem(item = note)
                    }
                }
            }
            is UIState.Error -> {
                Text(text = "Error: ${state.errorMessage}")
            }
            else -> {
                Text(text = "Empty state")
            }
        }
    }
}

@Composable
fun NoteItem(item: NoteDomain) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = item.title, fontSize = 20.sp)
        Text(text = item.desc, fontSize = 16.sp)
    }
}
