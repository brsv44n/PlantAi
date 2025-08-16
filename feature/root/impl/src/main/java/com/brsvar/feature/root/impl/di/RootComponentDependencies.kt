package com.brsvar.feature.root.impl.di

import com.brsvar.feature.onboarding.api.presentation.OnboardingRootComponent

interface RootComponentDependencies {
    val onboardingRootFactory: OnboardingRootComponent.Factory
}
