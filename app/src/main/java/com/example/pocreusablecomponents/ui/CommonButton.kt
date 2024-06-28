package com.example.pocreusablecomponents.ui
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonButton(
    text: String,
    isLoading: MutableState<Boolean> = mutableStateOf(false),
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: State<Boolean> = mutableStateOf(true),
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: androidx.compose.ui.unit.TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    shape: Shape = RoundedCornerShape(20.dp)
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        enabled = enabled.value,
        shape = shape
    ) {
        if (isLoading.value) {
            CircularProgressIndicator(
                color = contentColor,
                modifier = Modifier.size(20.dp)
            )
        } else {
            Text(
                text = text,
                fontStyle = fontStyle,
                fontSize = fontSize,
                fontWeight = fontWeight
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CommonButtonPreview() {
    CommonButton(
        text = "Click Me to show",
        onClick = {},
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    )
}