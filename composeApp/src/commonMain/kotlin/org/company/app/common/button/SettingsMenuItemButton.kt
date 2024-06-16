package org.company.app.common.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.company.app.theme.AppTheme
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SettingsMenuItemButtun (
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp).height(50.dp),
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = FamousTheme.colors.secondaryBackground,
            disabledBackgroundColor = FamousTheme.colors.secondaryBackground
        )
    ) {
        
        Box (modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart) {
            Column {
                
                
                
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light)      
            }
        }
    }
}

@Composable
@Preview
fun SettingsMenuItemButtun_Preview () {
    AppTheme {
        SettingsMenuItemButtun(
            text = "Roles",
        ) {
            
        }
    }
}