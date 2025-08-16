package com.brsvar.plantai.di.dependencies

import com.brsvar.feature.onboarding.api.presentation.OnboardingRootComponent
import com.brsvar.feature.root.impl.di.RootComponentDependencies
import me.tatarka.inject.annotations.Inject

@Inject
class RootComponentDependenciesImpl(
    override val onboardingRootFactory: OnboardingRootComponent.Factory
) : RootComponentDependencies
