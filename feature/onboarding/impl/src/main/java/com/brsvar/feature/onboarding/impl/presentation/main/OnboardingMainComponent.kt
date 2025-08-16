package com.brsvar.feature.onboarding.impl.presentation.main

import com.brsvar.core.decompose.DecomposeComponent

internal interface OnboardingMainComponent : DecomposeComponent {

    sealed interface Event {
        data object BackClicked : Event
        data object OnboardingPassClicked : Event
    }

    sealed interface Output {
        data object Exit : Output
        data object OnboardingPass : Output
        data object OpenLogin : Output
    }

    fun onEvent(event: Event)
}
