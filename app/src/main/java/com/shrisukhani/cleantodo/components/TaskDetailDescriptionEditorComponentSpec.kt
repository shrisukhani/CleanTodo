package com.shrisukhani.cleantodo.components

import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.TextInput
import com.facebook.litho.widget.VerticalScroll
import com.shrisukhani.cleantodo.model.Task

@LayoutSpec
class TaskDetailDescriptionEditorComponentSpec {
    companion object {
        private val FADING_EDGE_LENGTH_DP = 50f

        @JvmStatic
        @OnCreateLayout
        fun onCreateLayout(c: ComponentContext, @Prop task: Task): Component = VerticalScroll.create(c)
            .childComponent(
                TextInput.create(c)
                    .editable(true)
                    .initialText(task.description)
                    .multiline(true)
                    .heightPercent(100f)
                    .widthPercent(100f))
            .flex(1f)
            .verticalFadingEdgeEnabled(true)
            .fadingEdgeLengthDip(FADING_EDGE_LENGTH_DP)
            .build()
    }
}