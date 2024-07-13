package org.company.app.common.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.company.app.theme.FamousTheme

@Composable
fun SettingsMenuItemButton(
    text: String,
    mainImage: Painter,
    arrowImage: Painter,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 10.dp).height(50.dp),
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = FamousTheme.colors.secondaryBackground,
            disabledBackgroundColor = FamousTheme.colors.secondaryBackground
        )
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            Row {

                Image(
                    painter = mainImage,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(Alignment.CenterVertically)
                        .size(18.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = arrowImage,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(Alignment.CenterVertically)
                        .size(24.dp)
                )

            }
        }
    }
}

/*
@Composable
@Preview
fun SettingsMenuItemButtun_Preview () {
    AppTheme {
        SettingsMenuItemButtun(
            text = "Roles",
        ) {
            
        }
    }
}*/
