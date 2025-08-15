package com.brsvar.compose.ui_kit

import androidx.compose.runtime.compositionLocalOf

val LocalScreenRendererFactory = compositionLocalOf<ComponentRendererFactory> {
    error("No LocalScreenRendererFactory provided")
}
