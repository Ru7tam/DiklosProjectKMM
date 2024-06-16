package org.company.app.features.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_project.composeapp.generated.resources.*
import kmp_project.composeapp.generated.resources.Res
import org.company.app.common.textfield.FTextField
import org.company.app.features.login.models.LoginEvent
import org.company.app.features.login.models.LoginViewState
import org.company.app.theme.AppTheme
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
internal fun LoginView(
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {
    Column {
        
        Spacer(Modifier.height(60.dp))

        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 12.dp, start = 16.dp)
                .fillMaxWidth().height(28.dp)
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
                .clickable {
                    
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
                    .clickable {
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
    }
}

@Composable
@Preview
internal fun LoginView_Preview() {
    AppTheme {
        LoginView(
            viewState = LoginViewState(
                ipAddressValue = "192.168.1.100",
                apiPortValue = "5005",
                loginValue = "admin",
                passwordValue = "admin"
            ),
            eventHandler = { }
        )
    }
}