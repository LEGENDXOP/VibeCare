package com.teamx.vibecare.auth.screens



import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.teamx.vibecare.R
import com.teamx.vibecare.auth.utils.AuthUtils
import com.teamx.vibecare.auth.utils.AuthViewModel
import android.app.DatePickerDialog
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import java.util.*



@Composable
fun SignUpScreen(modifier: Modifier, viewModel: AuthViewModel) {
    val fullName by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val email by viewModel.email.collectAsStateWithLifecycle()
    val mobileNumber by viewModel.email.collectAsStateWithLifecycle()
    val dob by viewModel.email.collectAsStateWithLifecycle()

    val context = LocalContext.current
    var selectedDate by remember { mutableStateOf("") }



    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // DatePicker Dialog
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        }, year, month, day
    )
    var valueStored by remember { mutableStateOf(false) }



    val passwordVisibility by viewModel.passwordVisibility.collectAsStateWithLifecycle()
    val customFont = FontFamily(
        Font(R.font.league_spartan_semibold, weight = FontWeight.SemiBold)
    )
    Column(
        modifier = modifier
    ) {
        Text(
            text = "New Account",
            modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(AuthUtils.PRIMARY_BLUE),
            fontSize = 28.sp,
            fontFamily = customFont
        )
        Spacer(Modifier.height(24.dp))

        Spacer(Modifier.height(32.dp))

        HeadingNames("Full Name")

        textField( fullName , {
            print("1")
            viewModel.changeEmail(it)
        } )

      HeadingNames("Password")
        textField( password , { viewModel.changePassword(it) })

        HeadingNames("Email")
        textField(email, { viewModel.changeEmail(it) })

        HeadingNames("Date of Birth")

//
        Column {
            Text(text = if (selectedDate.isEmpty()) "Select your Date of Birth" else "DOB: $selectedDate")
            Spacer(modifier = Modifier.height(2.dp))
        if (!valueStored){
            Button(
                onClick = {
                    datePickerDialog.show()
                    valueStored = true
                }
            ) {
                Text("Select data birth")
            }
        } else{
            IconButton(
                onClick = {datePickerDialog.show()}
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
            }
        }
        }


        TextButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(end = 26.dp, top = 10.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    append("By continuing you agree to our ")
                    withStyle(style = SpanStyle(color = Color.Blue)){
                        append("Terms & Conditions")
                    }
                },
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.league_spartan_medium)),
                color = Color(AuthUtils.LIGHT_BLACK),

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
                text = "Sign Up",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.league_spartan_medium)),
                color = Color.White
            )
        }




        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton( onClick = { /*TODO*/ }) {
                Icon( painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription= null)

            }
            IconButton( onClick = { /*TODO*/ }) {
                Icon( painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription= null)

            }
            IconButton( onClick = { /*TODO*/ }) {
                Icon( painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription= null)

            }
        }

    }

}

@Composable
fun HeadingNames(string: String) {
    Text(
        text = string,
        modifier = Modifier
            .padding(start = 26.dp),
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(R.font.league_spartan_medium)),
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun textField(email: String, onChange: (String) -> Unit) {
    val focusManager = LocalFocusManager.current



    TextField(
        value = email,
        onValueChange = { newValue ->
            print("2")
            onChange(newValue)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 12.dp),
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
}