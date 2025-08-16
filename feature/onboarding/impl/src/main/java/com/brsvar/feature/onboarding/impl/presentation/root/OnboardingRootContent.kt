package com.brsvar.feature.onboarding.impl.presentation.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.brsvar.compose.ui_kit.LocalScreenRendererFactory
import com.brsvar.core.decompose.DecomposeComponent
import com.brsvar.feature.onboarding.api.presentation.OnboardingRootComponent
import kotlin.reflect.KClass

val onboardingRootRenderers = mapOf<KClass<*>, @Composable (Modifier, DecomposeComponent) -> Unit>(
    OnboardingRootComponent::class to { modifier, component ->
        OnboardingRootContent(
            modifier,
            component as OnboardingRootComponent
        )
    }
)

@Composable
internal fun OnboardingRootContent(
    modifier: Modifier,
    component: OnboardingRootComponent
) {
    val stack by component.childStack.subscribeAsState()
    Children(
        modifier = modifier,
        stack = stack,
        animation = stackAnimation(scale())
    ) { child ->
        val childComponent = child.instance
        LocalScreenRendererFactory.current.getRenderer(childComponent)
            .invoke(Modifier.fillMaxSize(), childComponent)
    }
}
