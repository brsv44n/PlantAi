package com.brsvar.feature.onboarding.api.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.brsvar.core.decompose.DecomposeComponent

interface OnboardingRootComponent : DecomposeComponent {

    val childStack: Value<ChildStack<*, DecomposeComponent>>

    sealed interface Event {
        data object OnboardingDoneClick : Event
        data object ExitClick : Event
    }

    fun onEvent(event: Event)

    sealed interface Output {
        data object Exit : Output
        data object OnboardingPassed : Output
    }

    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            output: (Output) -> Unit
        ): OnboardingRootComponent
    }
}
