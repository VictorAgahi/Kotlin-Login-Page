@file:OptIn(ExperimentalMaterial3Api::class)

package com.stu74534.loginpagev2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stu74534.loginpagev2.ui.theme.LoginPageV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*
            Not 4 constant but 5 because I use 2 main functions :
            one for Login,
            one for Sign up.

            And there are 5 notable colors:
            one for the background,
            one for the color of the text on the button,
            one for the color of each field,
            one for the color of the texts and
            finally the borders

            There are similarities between the two pages,
            I made lots of small functions (widgets)
            that I use for login or sign up

            I couldn't find the SVG of the photo indicated
            so I took another one

            */

            // gLogin()
            // gSignUp()
            // bLogin()
            // BSignUp()
        }
    }
}
@Composable
fun gLogin()
{
    val colorText = Color(0x9E636363)
    val colorBackGroundField = Color(0x9EEEEEEE)
    val borderColor = Color(0x9EFFFEFE)
    val backgroundColor = Color(0x9ECFCCCC)
    val textButton = Color.Black
    LoginPage(backgroundColor, colorBackGroundField, colorText , textButton,borderColor)
}
@Composable
fun gSignUp()
{
    val colorText = Color(0x9E636363)
    val colorBackGroundField = Color(0x9EEEEEEE)
    val borderColor = Color(0x9EFFFEFE)
    val backgroundColor = Color(0x9ECFCCCC)
    val textButton = Color.Black
    SignUpPage(backgroundColor, colorBackGroundField, colorText , textButton,borderColor)
}
@Composable
fun bLogin()
{
    val colorText = Color(0x9E636363)
    val colorBackGroundField = Color(0x9E3D3D3D)
    val borderColor = Color(0x9E444343)
    val backgroundColor = Color(0xF8111111)
    val textButton = Color.White
    LoginPage(backgroundColor, colorBackGroundField, colorText , textButton,borderColor)
}
@Composable
fun BSignUp()
{
    val colorText = Color(0x9E636363)
    val colorBackGroundField = Color(0x9E3D3D3D)
    val borderColor = Color(0x9E444343)
    val backgroundColor = Color(0xF8111111)
    val textButton = Color.White
    SignUpPage(backgroundColor, colorBackGroundField, colorText , textButton,borderColor)

}
@Composable
fun LoginPage(
    backgroundColor: Color,
    textFieldColor: Color,
    colorText: Color,
    textButton: Color,
    borderColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 100.dp)
        ) {

            LockImage()
            WelcomeText(colorText,"Welcome Back, you've been missed!")
            TextField(textFieldColor, colorText,"Email")
            TextField(textFieldColor, colorText,"Password")
            Text(
                text = "Forgot Password?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp)
                    .align(Alignment.End),
                textAlign = TextAlign.End,
                fontSize = 14.sp,
                color = colorText,
                fontWeight = FontWeight.Bold
            )
            Button(textFieldColor, textButton,"Login")
            ContinueWithText(borderColor, colorText)
            SocialMediaRow(textFieldColor, borderColor)
            MemberText(colorText,"Not a member?","Register Now")
        }
    }
}

@Composable
fun SignUpPage(
    backgroundColor: Color,
    textFieldColor:Color,
    colorText:Color,
    textButton:Color,
    borderColor:Color
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 150.dp)
        )
        {
            LockImage()
            WelcomeText(colorText = colorText,text="Let's create an account for you")
            TextField(textFieldColor, colorText,"Email")
            TextField(textFieldColor, colorText,"Password")
            TextField(textFieldColor, colorText,"Confirm Password")
            Button(textFieldColor, textButton,"Sign up")
            MemberText(colorText,"Already a member?", "Login Now")
        }
    }
}

@Composable
fun LockImage() {
    Image(
        painter = painterResource(R.drawable.lock_svgrepo_com),
        contentDescription = null,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun WelcomeText(colorText: Color, text:String) {
    Text(
        text = text,
        style = TextStyle(color = colorText, fontSize = 16.sp),
        modifier = Modifier.padding(bottom = 16.dp, top = 30.dp)
    )
}

@Composable
fun TextField(textFieldColor: Color, colorText: Color, text:String) {
    TextField(
        value = TextFieldValue(""),
        onValueChange = { /* No-op */ },
        label = { Text(text) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .height(56.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = textFieldColor,
            unfocusedContainerColor = textFieldColor,
            disabledContainerColor = textFieldColor,
            unfocusedTextColor = colorText,
            cursorColor = textFieldColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(20),
        placeholder = { Text(text = text, color = colorText) },
        singleLine = true,
    )
}

@Composable
fun Button(textFieldColor: Color, colorTextButton: Color, textButton:String) {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(
            containerColor = textFieldColor
        )
    ) {
        Text(
            text = textButton,
            color = colorTextButton,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContinueWithText(borderColor: Color, colorText: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .padding(top = 10.dp)
                .height(2.dp)
                .background(color = borderColor, shape = RoundedCornerShape(percent = 50))
        )
        Text(
            text = "Or Continue With",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .padding(horizontal = 20.dp),
            textAlign = TextAlign.Center,
            color = colorText,
            fontSize = 14.sp
        )
        Box(
            modifier = Modifier
                .width(100.dp)
                .padding(top = 10.dp)
                .height(2.dp)
                .background(color = borderColor, shape = RoundedCornerShape(percent = 50))
        )
    }
}

@Composable
fun SocialMediaRow(textFieldColor: Color, borderColor: Color) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        SocialMediaButton(R.drawable._123025_logo_google_g_icon, textFieldColor, borderColor)
        Spacer(modifier = Modifier.width(10.dp))
        SocialMediaButton(R.drawable._04490_apple_icon, textFieldColor, borderColor)
    }
}

@Composable
fun SocialMediaButton(iconId: Int, textFieldColor: Color, borderColor: Color) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp
                )
            )
            .background(textFieldColor)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun MemberText(colorText: Color, memberText:String, memberBoldText:String) {
    Row(
        modifier = Modifier.padding(start = 5.dp, top = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = memberText,
            color = colorText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = memberBoldText,
            color = colorText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginPageV2Theme {

    }
}