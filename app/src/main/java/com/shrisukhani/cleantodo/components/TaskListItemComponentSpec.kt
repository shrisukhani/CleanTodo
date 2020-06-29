package com.shrisukhani.cleantodo.components

import android.graphics.Color
import android.text.TextUtils
import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge
import com.facebook.yoga.YogaJustify
import com.shrisukhani.cleantodo.R
import com.shrisukhani.cleantodo.model.Task
import com.shrisukhani.cleantodo.model.TaskPriority
import java.time.format.DateTimeFormatter

@LayoutSpec
class TaskListItemComponentSpec {

    companion object {
        private val PRIORITY_BAR_WIDTH_DIP = 18f
        private val TASK_LIST_ITEM_ROW_HEIGHT_DIP = 60f
        private val CELL_CONTENT_HORIZONTAL_MARGIN_DIP = 8f
        private val TITLE_TEXT_SIZE_SP = 22f
        private val SECONDARY_TEXT_SIZE_SP = 16f
        private val SECOND_ROW_COMPONENT_MAX_WIDTH_DIP = 160f
        private val ARROW_ICON_HEIGHT_WIDTH_DIP = 30f

        @JvmStatic
        @OnCreateLayout
        fun onCreateLayout(c: ComponentContext, @Prop task: Task): Component {
            val date = task.dueDate?.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")) ?: "Set a due date"
            val name = task.title
            val parentListName = task.parentListName ?: "Choose list"

            return Row.create(c)
                .heightDip(TASK_LIST_ITEM_ROW_HEIGHT_DIP)
                .child(getPriorityComponent(c, task.priority))
                .child(
                    Column.create(c)
                        .marginDip(YogaEdge.HORIZONTAL, CELL_CONTENT_HORIZONTAL_MARGIN_DIP)
                        .justifyContent(YogaJustify.SPACE_AROUND)
                        .flexGrow(1f)
                        .child(
                            Text.create(c)
                                .text(name)
                                .textSizeSp(TITLE_TEXT_SIZE_SP)
                                .ellipsize(TextUtils.TruncateAt.END)
                                .maxLines(1)
                                .textColor(c.getColor(R.color.purple)))
                        .child(
                            Row.create(c)
                                .alignContent(YogaAlign.SPACE_AROUND)
                                .child(
                                    Text.create(c)
                                        .text(parentListName)
                                        .textSizeSp(SECONDARY_TEXT_SIZE_SP)
                                        .textColor(c.getColor(R.color.cyan))
                                        .clickHandler(TaskListItemComponent.onClickParentListName(c))
                                        .maxLines(1)
                                        .ellipsize(TextUtils.TruncateAt.END)
                                        .maxTextWidthDip(SECOND_ROW_COMPONENT_MAX_WIDTH_DIP))
                                .child(
                                    Text.create(c)
                                        .text(" | ")
                                        .textSizeSp(SECONDARY_TEXT_SIZE_SP)
                                        .textColor(c.getColor(R.color.cyan))
                                        .maxLines(1)
                                        .ellipsize(TextUtils.TruncateAt.END))
                                .child(
                                    Text.create(c)
                                        .text(date)
                                        .textSizeSp(SECONDARY_TEXT_SIZE_SP)
                                        .maxLines(1)
                                        .textColor(c.getColor(R.color.cyan))
                                        .clickHandler(TaskListItemComponent.onClickDueDate(c))
                                        .ellipsize(TextUtils.TruncateAt.END)
                                        .maxTextWidthDip(SECOND_ROW_COMPONENT_MAX_WIDTH_DIP))))
                    .child(
                        Image.create(c)
                            .drawableRes(R.drawable.ic_arrow_right_filled)
                            .paddingDip(YogaEdge.ALL, 2f)
                            .heightDip(ARROW_ICON_HEIGHT_WIDTH_DIP)
                            .widthDip(ARROW_ICON_HEIGHT_WIDTH_DIP)
                            .alignSelf(YogaAlign.CENTER)
                            .clickHandler(TaskListItemComponent.onClickDetailViewIcon(c))
                            .marginDip(YogaEdge.RIGHT, CELL_CONTENT_HORIZONTAL_MARGIN_DIP)
                            .build())
                .build()
        }

        @JvmStatic
        @OnEvent(ClickEvent::class)
        fun onClickParentListName(c: ComponentContext, @Prop task: Task) {
            // @TODO: Implement later
        }

        @JvmStatic
        @OnEvent(ClickEvent::class)
        fun onClickDueDate(c: ComponentContext, @Prop task: Task) {
            // @TODO: Implement later
        }

        @JvmStatic
        @OnEvent(ClickEvent::class)
        fun onClickDetailViewIcon(c: ComponentContext, @Prop task: Task) {
            // @TODO: Implement later
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