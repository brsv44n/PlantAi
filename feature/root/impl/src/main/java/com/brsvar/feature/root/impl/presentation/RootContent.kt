package com.brsvar.feature.root.impl.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.brsvar.compose.ui_kit.LocalScreenRendererFactory
import com.brsvar.core.decompose.DecomposeComponent
import com.brsvar.feature.root.api.presentation.RootComponent
import kotlin.reflect.KClass

val rootRenderers = mapOf<KClass<*>, @Composable (Modifier, DecomposeComponent) -> Unit>(
    RootComponent::class to { modifier, component ->
        RootContent(
            modifier,
            component as RootComponent
        )
    }
)

@Composable
internal fun RootContent(
    modifier: Modifier = Modifier,
    component: RootComponent
) {
    val stack by component.stack.subscribeAsState()
    Children(
        modifier = modifier,
        stack = stack,
        animation = stackAnimation(slide())
    ) { child ->
        val childComponent = child.instance
        LocalScreenRendererFactory.current.getRenderer(childComponent)
            .invoke(Modifier.fillMaxSize(), childComponent)
    }
}
