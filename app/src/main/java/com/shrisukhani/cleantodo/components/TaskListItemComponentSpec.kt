package com.shrisukhani.cleantodo.components

import android.graphics.Color
import android.os.Build
import android.text.TextUtils
import android.text.format.DateFormat
import android.text.format.DateUtils
import android.util.TimeUtils
import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge
import com.facebook.yoga.YogaJustify
import com.shrisukhani.cleantodo.R
import com.shrisukhani.cleantodo.model.Task
import com.shrisukhani.cleantodo.model.TaskPriority
import java.time.format.DateTimeFormatter
import java.util.*

@LayoutSpec
class TaskListItemComponentSpec {

    companion object {
        private val PRIORITY_BAR_WIDTH_DIP = 24f
        private val TASK_LIST_ITEM_ROW_HEIGHT_DIP = 60f
        private val TITLE_TEXT_SIZE_SP = 22f

        @JvmStatic
        @OnCreateLayout
        fun onCreateLayout(c: ComponentContext, @Prop task: Task): Component {
            val date = task.dueDate?.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")) ?: "Set a due date"
            return Row.create(c)
                .heightDip(TASK_LIST_ITEM_ROW_HEIGHT_DIP)
                .child(getPriorityComponent(c, task.priority))
                .child(
                    Column.create(c)
                        .marginDip(YogaEdge.HORIZONTAL, 8f)
                        .justifyContent(YogaJustify.SPACE_AROUND)
                        .flexGrow(1f)
                        .child(
                            Text.create(c)
                                .text(task.title)
                                .textSizeSp(TITLE_TEXT_SIZE_SP)
                                .ellipsize(TextUtils.TruncateAt.END)
                                .maxLines(1)
                                .textColor(c.getColor(R.color.purple)))
                        .child(
                            Row.create(c)
                                .alignContent(YogaAlign.SPACE_AROUND)
                                .child(
                                    Text.create(c)
                                        .text(task.parentListName ?: "Moving to the Bay")
                                        .textSizeSp(16f)
                                        .textColor(c.getColor(R.color.cyan))
                                        .maxLines(1)
                                        .ellipsize(TextUtils.TruncateAt.END)
                                        .maxTextWidthDip(160f))
                                .child(
                                    Text.create(c)
                                        .text(date)
                                        .textSizeSp(16f)
                                        .maxLines(1)
                                        .textColor(c.getColor(R.color.cyan))
                                        .ellipsize(TextUtils.TruncateAt.END)
                                        .maxTextWidthDip(160f))))
                .build()
        }

        @JvmStatic
        private fun getPriorityComponent(
            c: ComponentContext, priority: TaskPriority): Component =
            Column.create(c)
                .heightDip(TASK_LIST_ITEM_ROW_HEIGHT_DIP)
                .widthDip(PRIORITY_BAR_WIDTH_DIP)
                .justifyContent(YogaJustify.CENTER)
                .alignContent(YogaAlign.CENTER)
                .backgroundColor(
                    when (priority) {
                        TaskPriority.HIGH -> c.getColor(R.color.red)
                        TaskPriority.MEDIUM -> c.getColor(R.color.organge)
                        TaskPriority.LOW -> c.getColor(R.color.cyan)
                        TaskPriority.NONE -> Color.GRAY
                    })
                .build()

    }
}