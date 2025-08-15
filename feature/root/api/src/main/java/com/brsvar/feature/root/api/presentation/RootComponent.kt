package com.brsvar.feature.root.api.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.brsvar.core.decompose.DecomposeComponent

interface RootComponent : DecomposeComponent {
    val stack: Value<ChildStack<*, DecomposeComponent>>

    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): RootComponent
    }
}
