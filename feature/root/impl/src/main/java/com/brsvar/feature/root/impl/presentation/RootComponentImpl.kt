package com.brsvar.feature.root.impl.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import com.brsvar.core.decompose.DecomposeComponent
import com.brsvar.feature.onboarding.api.presentation.OnboardingRootComponent
import com.brsvar.feature.root.api.presentation.RootComponent
import com.brsvar.feature.root.impl.di.RootComponentDependencies
import kotlinx.serialization.Serializable
import me.tatarka.inject.annotations.Inject

internal class RootComponentImpl(
    private val dependencies: RootComponentDependencies,
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    override val stack: Value<ChildStack<*, DecomposeComponent>>
        get() = _stack

    private val stackNavigation = StackNavigation<Config>()

    private val _stack = childStack(
        source = stackNavigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Onboarding,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Config,
        context: ComponentContext
    ): DecomposeComponent = when (config) {
        Config.Main -> TODO("factory needed to delegate")

        Config.Onboarding -> dependencies.onboardingRootFactory.invoke(
            componentContext = context,
            output = ::onOnboardingOutput
        )
    }

    private fun onOnboardingOutput(output: OnboardingRootComponent.Output) {
        when (output) {
            OnboardingRootComponent.Output.OnboardingPassed -> stackNavigation.pushNew(Config.Main)

            OnboardingRootComponent.Output.Exit -> stackNavigation.pop()
        }
    }

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Onboarding : Config

        @Serializable
        data object Main : Config
    }
}

@Inject
class RootComponentFactory(
    private val dependencies: RootComponentDependencies
) : RootComponent.Factory {
    override fun invoke(componentContext: ComponentContext): RootComponent =
        RootComponentImpl(
            dependencies = dependencies,
            componentContext = componentContext
        )
}
