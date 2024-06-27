package org.company.app.features.settings.ui

import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kmp_project.composeapp.generated.resources.*
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.settings_cameras
import kmp_project.composeapp.generated.resources.settings_servers
import org.company.app.common.button.SettingsMenuItemButtun
import org.company.app.features.archive.ui.ArchiveScreen
import org.company.app.features.home.ui.HomeScreen
import org.company.app.features.roles.ui.RolesScreen
import org.company.app.features.settings.models.SettingsEvent
import org.company.app.features.settings.models.SettingsViewState
import org.company.app.navigation.AppScreens
import org.company.app.navigation.main.MainScreens
import org.company.app.theme.AppTheme
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


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
    Column(modifier = Modifier.padding(top = 55.dp)) {

        SettingsMenuItemButtun(
            text = "Ролей",
        ) {
            navController.navigate(SettingsScreens.Roles.route) // Навигация на экран Roles
        }

        SettingsMenuItemButtun(
            text = "ArgusPro"
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

        SettingsMenuItemButtun(
            text = "Добавить камеру"
        ) {
            navController.navigate(SettingsScreens.AddCamera.route) // Навигация на экран AddCamera
        }

        SettingsMenuItemButtun(
            text = "Список камер"
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

        SettingsMenuItemButtun(
            text = "Добавить сервер"
        ) {
            navController.navigate(SettingsScreens.AddServer.route) // Навигация на экран AddServer
        }

        SettingsMenuItemButtun(
            text = "Список посещенных серверов"
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
            Text(text = stringResource(Res.string.settings_signout_button))
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
