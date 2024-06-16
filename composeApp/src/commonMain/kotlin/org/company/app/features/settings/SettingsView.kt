package org.company.app.features.settings

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
import kmp_project.composeapp.generated.resources.*
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.settings_cameras
import kmp_project.composeapp.generated.resources.settings_servers
import org.company.app.common.button.SettingsMenuItemButtun
import org.company.app.features.settings.models.SettingsEvent
import org.company.app.features.settings.models.SettingsViewState
import org.company.app.theme.AppTheme
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun SettingsView(
    viewState: SettingsViewState,
    eventHandler: (SettingsEvent) -> Unit
) {
    Column (modifier = Modifier.padding(top = 45.dp)) {
        
        SettingsMenuItemButtun(
            text = "Ролей"
        ) {
            
        }
        
        SettingsMenuItemButtun(
            text = "ArgusPro"
        ) {
            
        }
        
        Spacer(Modifier.height(50.dp))
        
        Box(modifier = Modifier.padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart) {
            Text(
                text = stringResource(Res.string.settings_cameras),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
                )   
        }
        
        SettingsMenuItemButtun(
            text = "Добавить камеру"
        ) {
            
        }
        
        SettingsMenuItemButtun(
            text = "Список камер"
        ) {
            
        }
        
        Spacer(Modifier.height(50.dp))
        
        Box(modifier = Modifier.padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart) {
            Text(
                text = stringResource(Res.string.settings_servers),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
                )   
        }
        
        SettingsMenuItemButtun(
            text = "Добавить сервер"
        ) {
            
        }
        
        SettingsMenuItemButtun(
            text = "Список существующих серверов"
        ) {
            
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

@Composable
@Preview
internal fun SettingsView_Preview() {
    AppTheme {
        SettingsView(viewState = SettingsViewState(),
        eventHandler = { }     )
    }
}