package org.company.app.features.login.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.login_ArgusPro
import kmp_project.composeapp.generated.resources.login_api_port
import kmp_project.composeapp.generated.resources.login_forgot
import kmp_project.composeapp.generated.resources.login_ip_address
import kmp_project.composeapp.generated.resources.login_login
import kmp_project.composeapp.generated.resources.login_password
import org.company.app.common.textfield.FTextField
import org.company.app.features.login.models.LoginEvent
import org.company.app.features.login.models.LoginViewState
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun LoginView(
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = {
                    keyboardController?.hide()
                }
            )
        }
    ) {

        Spacer(Modifier.height(60.dp))

        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 12.dp, start = 16.dp)
                .fillMaxWidth()
                .height(28.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.BottomStart),
                text = stringResource(Res.string.login_ArgusPro),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
            )
        }

        FTextField(
            text = viewState.ipAddressValue,
            hint = stringResource(Res.string.login_ip_address),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.IpAddressChanged(it))
        }

        FTextField(
            text = viewState.apiPortValue,
            hint = stringResource(Res.string.login_api_port),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.ApiPortChanged(it))
        }

        FTextField(
            text = viewState.loginValue,
            hint = stringResource(Res.string.login_login),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.LoginChanged(it))
        }

        FTextField(
            text = viewState.passwordValue,
            hint = stringResource(Res.string.login_password),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.PasswordChanged(it))
        }

        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier.size(width = 156.dp, height = 40.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {

                }
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(Res.string.login_forgot),
                    color = FamousTheme.colors.primaryText
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier.size(width = 84.dp, height = 40.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        eventHandler.invoke(LoginEvent.LoginClicked)
                    }
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(Res.string.login_login),
                    color = FamousTheme.colors.primaryText
                )
            }
        }
        viewState.errorMessage?.let { errorMessage ->
            ErrorMessageView(errorMessage = errorMessage) {
                eventHandler.invoke(LoginEvent.ErrorDismissed)
            }
        }
    }
}

@Composable
fun ErrorMessageView(errorMessage: String, onDismiss: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color.Red,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            androidx.compose.material.Text(
                text = errorMessage,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterStart)
            )
            androidx.compose.material.Text(
                text = "Dismiss",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable { onDismiss() }
            )
        }
    }
}