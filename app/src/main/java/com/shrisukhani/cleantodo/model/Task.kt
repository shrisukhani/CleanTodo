package com.shrisukhani.cleantodo.model

import java.time.LocalDate

data class Task(
    var title: String,
    var priority: TaskPriority = TaskPriority.NONE,
    var parentListName: String? = null,
    var description: String = "",
    var dueDate: LocalDate? = null,
    var completed: Boolean = false
)