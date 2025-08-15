package com.brsvar.plantai

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brsvar.compose.ui_kit.ComponentRendererFactory
import com.brsvar.core.decompose.DecomposeComponent
import com.brsvar.feature.root.impl.presentation.rootRenderers

class MyDroidComponentRenderers : ComponentRendererFactory {

    private val appRenderers = rootRenderers

    override fun getRenderer(component: DecomposeComponent): @Composable (Modifier, DecomposeComponent) -> Unit {
        return appRenderers.entries.firstOrNull {
            it.key.isInstance(component)
        }?.value ?: error("Renderer for ${component::class} is not found")
    }
}
