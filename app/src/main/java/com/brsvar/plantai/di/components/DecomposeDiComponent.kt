package com.brsvar.plantai.di.components

import com.brsvar.feature.root.api.presentation.RootComponent
import com.brsvar.feature.root.impl.di.RootComponentDependencies
import com.brsvar.feature.root.impl.presentation.RootComponentFactory
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
}
