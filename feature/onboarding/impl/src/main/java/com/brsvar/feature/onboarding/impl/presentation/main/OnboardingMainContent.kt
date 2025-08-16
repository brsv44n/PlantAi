package com.brsvar.feature.onboarding.impl.presentation.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun OnboardingMainContent(
    modifier: Modifier,
    component: OnboardingMainComponent
) {
    BackHandler {
        component.onEvent(OnboardingMainComponent.Event.BackClicked)
    }

    Box(
        modifier = modifier.background(color = Color.Black)
    ) {

    }
}
