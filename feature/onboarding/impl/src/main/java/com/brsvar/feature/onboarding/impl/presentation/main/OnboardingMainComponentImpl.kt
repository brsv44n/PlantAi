package com.brsvar.feature.onboarding.impl.presentation.main

import com.arkivanov.decompose.ComponentContext

internal class OnboardingMainComponentImpl(
    componentContext: ComponentContext,
    private val output: (OnboardingMainComponent.Output) -> Unit
) : OnboardingMainComponent, ComponentContext by componentContext {
    override fun onEvent(event: OnboardingMainComponent.Event) {
        when (event) {
            OnboardingMainComponent.Event.OnboardingPassClicked -> output.invoke(
                OnboardingMainComponent.Output.OnboardingPass
            )

            OnboardingMainComponent.Event.BackClicked -> output.invoke(
                OnboardingMainComponent.Output.Exit
            )
        }
    }
}
