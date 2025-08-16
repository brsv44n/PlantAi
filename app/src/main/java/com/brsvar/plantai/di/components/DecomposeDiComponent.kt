package com.brsvar.plantai.di.components

import com.brsvar.feature.onboarding.api.presentation.OnboardingRootComponent
import com.brsvar.feature.onboarding.impl.di.OnboardingRootDependencies
import com.brsvar.feature.onboarding.impl.presentation.root.OnboardingRootComponentFactory
import com.brsvar.feature.root.api.presentation.RootComponent
import com.brsvar.feature.root.impl.di.RootComponentDependencies
import com.brsvar.feature.root.impl.presentation.RootComponentFactory
import com.brsvar.plantai.di.dependencies.OnboardingRootDependenciesImpl
import com.brsvar.plantai.di.dependencies.RootComponentDependenciesImpl
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class DecomposeDiComponent(
    @Component val appDiComponent: AppDiComponent,
) {

    abstract val rootComponentFactory: RootComponent.Factory

    @Provides
    fun RootComponentFactory.bind(): RootComponent.Factory = this

    @Provides
    fun RootComponentDependenciesImpl.bind(): RootComponentDependencies = this

    @Provides
    fun OnboardingRootComponentFactory.bind(): OnboardingRootComponent.Factory = this

    @Provides
    fun OnboardingRootDependenciesImpl.bind(): OnboardingRootDependencies = this
}
