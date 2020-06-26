package com.shrisukhani.cleantodo.components

import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout

@LayoutSpec
class TaskRowComponentSpec {

    companion object {

        @JvmStatic
        @OnCreateLayout
        fun onCreateLayout(c: ComponentContext): Component = Row.create(c)
            .build()
    }
}