package com.teamx.vibecare.auth.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.teamx.vibecare.R
import com.teamx.vibecare.auth.utils.AuthUtils
import com.teamx.vibecare.auth.utils.AuthViewModel

@Composable
fun SignInScreen(modifier: Modifier, viewModel: AuthViewModel) {
    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val passwordVisibility by viewModel.passwordVisibility.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
    ) {
        Text(
            "Log In",
            modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(AuthUtils.PRIMARY_BLUE),
            fontSize = 28.sp,
            fontFamily = AuthUtils.SPARTAN_SEMIBOLD
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Welcome",
            modifier = Modifier
                .padding(start = 26.dp),
            fontSize = 30.sp,
            fontFamily = AuthUtils.SPARTAN_SEMIBOLD,
            color = Color(AuthUtils.PRIMARY_BLUE)
        )
        Spacer(Modifier.height(32.dp))
        Text(
            text = "Email or Mobile Number",
            modifier = Modifier
                .padding(start = 26.dp),
            fontSize = 24.sp,
            fontFamily = AuthUtils.SPARTAN_MEDIUM,
            color = Color.Black,
        )
        val focusManager = LocalFocusManager.current
        TextField(
            value = email,
            onValueChange = { viewModel.changeEmail(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 12.dp),
            placeholder = {Text("example@gmail.com", color = Color(AuthUtils.PRIMARY_BLUE))},
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus(true) }),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(AuthUtils.LIGHT_BLUE),
                focusedContainerColor = Color(AuthUtils.LIGHT_BLUE),
                focusedTextColor = Color(AuthUtils.PRIMARY_BLUE),
                unfocusedTextColor = Color(AuthUtils.PRIMARY_BLUE)

            )

        )

        Text(
            text = "Password",
            modifier = Modifier
                .padding(start = 26.dp, top = 24.dp),
            fontSize = 24.sp,
            fontFamily = AuthUtils.SPARTAN_MEDIUM,
            color = Color.Black,
        )
        TextField(
            value = password,
            onValueChange = { viewModel.changePassword(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 12.dp),
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            trailingIcon = {
                IconButton(
                    onClick = {
                        viewModel.changePswVisibility(!passwordVisibility)
                    }
                ) {
                    Icon(
                        imageVector = if (passwordVisibility) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = "Password Visibility Button"
                    )
                }
            },
            placeholder = {Text("***********", color = Color(AuthUtils.PRIMARY_BLUE))},
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus(true) }),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(AuthUtils.LIGHT_BLUE),
                focusedContainerColor = Color(AuthUtils.LIGHT_BLUE),
                focusedTextColor = Color(AuthUtils.PRIMARY_BLUE),
                unfocusedTextColor = Color(AuthUtils.PRIMARY_BLUE)

            )
        )
        TextButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 22.dp, top = 4.dp)
        ) {
            Text(
                text = "Forgot Password",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.league_spartan_medium)),
                color = Color(AuthUtils.PRIMARY_BLUE),
            )
        }
        Button(
            onClick = {
                //TODO: navigate to home screen
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp)
                .height(55.dp)
                .width(220.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(AuthUtils.PRIMARY_BLUE)
            )
        ) {
            Text(
                text = "Log In",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.league_spartan_medium)),
                color = Color.White
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don’t have an account?",
                color = Color(AuthUtils.LIGHT_BLACK),
                fontFamily = FontFamily(Font(R.font.league_spartan_medium)),
            )
            TextButton(
                onClick = {
                    // TODO: navigate to sign up screen
                },
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Sign Up",
                    color = Color(AuthUtils.PRIMARY_BLUE),
                    fontFamily = FontFamily(Font(R.font.league_spartan_medium)),
                )
            }
        }

    }

}