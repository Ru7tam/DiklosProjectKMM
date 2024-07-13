package org.company.app.features.settings.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.bottom_settings
import kmp_project.composeapp.generated.resources.ic_add
import kmp_project.composeapp.generated.resources.ic_arrow_right
import kmp_project.composeapp.generated.resources.ic_groups
import kmp_project.composeapp.generated.resources.ic_list
import kmp_project.composeapp.generated.resources.ic_project
import kmp_project.composeapp.generated.resources.ic_webcam
import kmp_project.composeapp.generated.resources.settings_add_cameras
import kmp_project.composeapp.generated.resources.settings_add_server
import kmp_project.composeapp.generated.resources.settings_argusPro
import kmp_project.composeapp.generated.resources.settings_cameras
import kmp_project.composeapp.generated.resources.settings_list_cameras
import kmp_project.composeapp.generated.resources.settings_list_server
import kmp_project.composeapp.generated.resources.settings_roles
import kmp_project.composeapp.generated.resources.settings_servers
import kmp_project.composeapp.generated.resources.settings_signOut_button
import org.company.app.common.button.SettingsMenuItemButton
import org.company.app.features.settings.models.SettingsEvent
import org.company.app.features.settings.models.SettingsViewState
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


enum class SettingsScreens(val route: String) {
    Roles("roles"),
    ArgusPro("argus_pro"),
    AddCamera("add_camera"),
    CameraList("camera_list"),
    AddServer("add_server"),
    ServerList("server_list")
}

@Composable
internal fun SettingsView(
    viewState: SettingsViewState,
    eventHandler: (SettingsEvent) -> Unit,
    navController: NavController // Добавляем NavController в параметры
) {
    Column(modifier = Modifier.padding(top = 65.dp)) {

        Box(
            modifier = Modifier.padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = stringResource(Res.string.bottom_settings),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
            )
        }

        SettingsMenuItemButton(
            mainImage = painterResource(Res.drawable.ic_groups),
            text = stringResource(Res.string.settings_roles),
            arrowImage = painterResource(Res.drawable.ic_arrow_right)
        ) {
            navController.navigate(SettingsScreens.Roles.route) // Навигация на экран Roles
        }

        SettingsMenuItemButton(
            mainImage = painterResource(Res.drawable.ic_project),
            text =  stringResource(Res.string.settings_argusPro),
            arrowImage = painterResource(Res.drawable.ic_arrow_right)
        ) {
            navController.navigate(SettingsScreens.ArgusPro.route) // Навигация на экран ArgusPro
        }

        Spacer(Modifier.height(50.dp))

        Box(
            modifier = Modifier.padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = stringResource(Res.string.settings_cameras),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
            )
        }

        SettingsMenuItemButton(
            mainImage = painterResource(Res.drawable.ic_add),
            text =  stringResource(Res.string.settings_add_cameras),
            arrowImage = painterResource(Res.drawable.ic_arrow_right)
        ) {
            navController.navigate(SettingsScreens.AddCamera.route) // Навигация на экран AddCamera
        }

        SettingsMenuItemButton(
            mainImage = painterResource(Res.drawable.ic_webcam),
            text =  stringResource(Res.string.settings_list_cameras),
            arrowImage = painterResource(Res.drawable.ic_arrow_right)
        ) {
            navController.navigate(SettingsScreens.CameraList.route) // Навигация на экран CameraList
        }

        Spacer(Modifier.height(50.dp))

        Box(
            modifier = Modifier.padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = stringResource(Res.string.settings_servers),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
            )
        }

        SettingsMenuItemButton(
            mainImage = painterResource(Res.drawable.ic_add),
            text =  stringResource(Res.string.settings_add_server),
            arrowImage = painterResource(Res.drawable.ic_arrow_right)
        ) {
            navController.navigate(SettingsScreens.AddServer.route) // Навигация на экран AddServer
        }

        SettingsMenuItemButton(
            mainImage = painterResource(Res.drawable.ic_list),
            text =  stringResource(Res.string.settings_list_server),
            arrowImage = painterResource(Res.drawable.ic_arrow_right)
        ) {
            navController.navigate(SettingsScreens.ServerList.route) // Навигация на экран ServerList
        }

        Spacer(Modifier.height(50.dp))

        Button(
            modifier = Modifier.fillMaxWidth().height(60.dp)
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = FamousTheme.colors.buttonColor,
                contentColor = FamousTheme.colors.primaryText
            ),
            onClick = {

            }
        ) {
            Text(text = stringResource(Res.string.settings_signOut_button))
        }

    }
}

/*
@Composable
@Preview
internal fun SettingsView_Preview() {
    AppTheme {
        SettingsView(
            viewState = SettingsViewState(),
            eventHandler = { }
        )
    }
}*/
