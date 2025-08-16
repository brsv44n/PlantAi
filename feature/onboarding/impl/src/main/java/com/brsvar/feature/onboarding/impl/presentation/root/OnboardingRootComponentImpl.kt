package com.brsvar.feature.onboarding.impl.presentation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import com.brsvar.core.decompose.DecomposeComponent
import com.brsvar.feature.onboarding.api.presentation.OnboardingRootComponent
import com.brsvar.feature.onboarding.impl.di.OnboardingRootDependencies
import com.brsvar.feature.onboarding.impl.presentation.main.OnboardingMainComponent
import com.brsvar.feature.onboarding.impl.presentation.main.OnboardingMainComponentImpl
import kotlinx.serialization.Serializable
import me.tatarka.inject.annotations.Inject

class OnboardingRootComponentImpl(
    componentContext: ComponentContext,
    private val dependencies: OnboardingRootDependencies,
    private val output: (OnboardingRootComponent.Output) -> Unit,
) : OnboardingRootComponent, ComponentContext by componentContext {
    override val childStack: Value<ChildStack<*, DecomposeComponent>>
        get() = stack

    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.OnboardingMain,
        handleBackButton = true,
        childFactory = ::createChild
    )

    override fun onEvent(event: OnboardingRootComponent.Event) {
        when (event) {
            OnboardingRootComponent.Event.OnboardingDoneClick -> {
                output.invoke(OnboardingRootComponent.Output.OnboardingPassed)
            }

            OnboardingRootComponent.Event.ExitClick -> {
                output.invoke(OnboardingRootComponent.Output.Exit)
            }
        }
    }

    private fun createChild(
        config: Config,
        componentContext: ComponentContext,
    ): DecomposeComponent {
        return when (config) {
            Config.OnboardingMain -> {
                OnboardingMainComponentImpl(
                    componentContext = componentContext,
                    output = ::onOnboardingMainOutput
                )
            }

            Config.Login -> {
                TODO()
            }
        }
    }

    private fun onOnboardingMainOutput(output: OnboardingMainComponent.Output) {
        when (output) {
            OnboardingMainComponent.Output.OnboardingPass -> this.output.invoke(
                OnboardingRootComponent.Output.OnboardingPassed
            )

            OnboardingMainComponent.Output.Exit -> this.output.invoke(
                OnboardingRootComponent.Output.Exit
            )

            OnboardingMainComponent.Output.OpenLogin -> navigation.pushNew(
                Config.Login
            )
        }
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object OnboardingMain : Config

        @Serializable
        data object Login : Config
    }
}

@Inject
class OnboardingRootComponentFactory(
    private val dependencies: OnboardingRootDependencies
) : OnboardingRootComponent.Factory {
    override fun invoke(
        componentContext: ComponentContext,
        output: (OnboardingRootComponent.Output) -> Unit
    ) = OnboardingRootComponentImpl(
        componentContext = componentContext,
        output = output,
        dependencies = dependencies
    )
}
