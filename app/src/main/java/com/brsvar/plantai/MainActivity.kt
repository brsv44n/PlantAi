package com.brsvar.plantai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.brsvar.compose.theme.MyDroidPlantAiTheme
import com.brsvar.compose.ui_kit.LocalScreenRendererFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val rootFactory = (application as App).decomposeDiComponent.rootComponentFactory
        val component = rootFactory.invoke(componentContext = defaultComponentContext())

        setContent {
            MyDroidPlantAiTheme {
                CompositionLocalProvider(
                    LocalScreenRendererFactory provides MyDroidComponentRenderers()
                ) {
                    LocalScreenRendererFactory.current.getRenderer(component)(
                        Modifier.fillMaxSize(),
                        component
                    )
                }
            }
        }
    }
}
