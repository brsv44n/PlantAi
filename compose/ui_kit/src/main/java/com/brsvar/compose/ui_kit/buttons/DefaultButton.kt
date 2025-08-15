package com.brsvar.compose.ui_kit.buttons

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brsvar.compose.theme.Colors
import com.brsvar.compose.theme.MyDroidPlantAiTheme
import com.brsvar.compose.theme.darkOnBackground
import com.brsvar.compose.theme.darkOnPrimary
import com.brsvar.compose.theme.darkSecondary
import com.brsvar.compose.theme.lightOnBackground
import com.brsvar.compose.theme.lightSecondary

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    isSecondary: Boolean = false,
    enabled: Boolean = true,
    showLoading: Boolean = false,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 13.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
) {

    val isDark = isSystemInDarkTheme()

    val containerColor =
        when {
            isDark && isSecondary -> Colors.darkSecondary()
            isSecondary -> Colors.lightSecondary()
            else -> MaterialTheme.colorScheme.primary
        }

    val contentColor =
        when {
            isDark && isSecondary -> Colors.darkOnBackground()
            isSecondary -> Colors.lightOnBackground()
            else -> MaterialTheme.colorScheme.onPrimary
        }

    Button(
        modifier = modifier,
        enabled = enabled && !showLoading,
        shape = RoundedCornerShape(16.dp),
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        ),
        onClick = onClick,
    ) {
        AnimatedVisibility(visible = showLoading) {
            Row {
                androidx.compose.material3.CircularProgressIndicator(
                    modifier = Modifier.size(14.dp),
                    strokeWidth = 1.5.dp
                )
                Spacer(Modifier.width(12.dp))
            }
        }
        ProvideTextStyle(value = MaterialTheme.typography.headlineMedium) {
            content()
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    MyDroidPlantAiTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DefaultButton(
                enabled = true,
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text("Enabled Button")
            }

            DefaultButton(
                enabled = false,
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text(text = "Disabled button", color = Colors.darkOnPrimary())
            }

            DefaultButton(
                enabled = false,
                showLoading = true,
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text(text = "Show loading button", color = Colors.darkOnPrimary())
            }
        }
    }
}
