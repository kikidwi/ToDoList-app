package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID
import com.google.android.material.textfield.TextInputEditText

class DetailTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action
        val Title : TextInputEditText = findViewById(R.id.detail_ed_title)
        val Desc : TextInputEditText = findViewById(R.id.detail_ed_description)
        val DueDate : TextInputEditText = findViewById(R.id.detail_ed_due_date)
        val BtnDelete : Button = findViewById(R.id.btn_delete_task)


        val viewModel = ViewModelProvider(
            this,
            ViewModelFactory.getInstance(this)
        )[DetailTaskViewModel::class.java]

        viewModel.setTaskId(intent.getIntExtra(TASK_ID, 0))

        viewModel.task.observe(this, { task ->
            if (task != null) {
                Title.setText(task.title)
                Desc.setText(task.description)
                DueDate.setText(DateConverter.convertMillisToString(task.dueDateMillis))
            }
        })

        BtnDelete.setOnClickListener {
            viewModel.deleteTask()
            onBackPressed()
        }
    }
}