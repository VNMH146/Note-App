package com.example.noteapp

import android.app.Dialog
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.ui.theme.NoteAppTheme
import com.example.noteapp.utils.setupDialog


class MainActivity : AppCompatActivity() {

    private val mainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val addTaskDialog : Dialog by lazy {
        Dialog(this).apply {
            setupDialog(R.layout.add_task_dialog)
        }
    }

    private val updateTaskDialog : Dialog by lazy {
        Dialog(this).apply {
            setupDialog(R.layout.update_task_dialog)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)


        val addCloseImg = addTaskDialog.findViewById<ImageView>(R.id.closeImg)
        val updateCloseImg = updateTaskDialog.findViewById<ImageView>(R.id.closeImg)

        addCloseImg.setOnClickListener{ addTaskDialog.dismiss() }
        updateCloseImg.setOnClickListener{ updateTaskDialog.dismiss() }

        mainBinding.addTaskFABtn.setOnClickListener{
            addTaskDialog.show()
        }
    }

}
