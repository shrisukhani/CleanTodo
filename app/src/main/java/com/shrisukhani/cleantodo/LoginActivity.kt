package com.shrisukhani.cleantodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.shrisukhani.cleantodo.components.TaskListItemComponent
import com.shrisukhani.cleantodo.components.TaskListItemComponent2
import com.shrisukhani.cleantodo.components.TaskListItemComponentSpec
import com.shrisukhani.cleantodo.model.Task
import com.shrisukhani.cleantodo.model.TaskPriority
import java.time.LocalDate

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val componentContext = ComponentContext(this)
        val component = TaskListItemComponent
            .create(componentContext)
            .task(getDummyTask())
            .build()

        setContentView(LithoView.create(componentContext, component))
    }

    private fun getDummyTask() = Task(
        title = "Physics Midterm Prep",
        priority = TaskPriority.HIGH,
        dueDate = LocalDate.of(2021, 6, 25)
    )
}
