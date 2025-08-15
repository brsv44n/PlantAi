package com.brsvar.compose.ui_kit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brsvar.core.decompose.DecomposeComponent

interface ComponentRendererFactory {
    fun getRenderer(component: DecomposeComponent): @Composable (Modifier, DecomposeComponent) -> Unit
}
