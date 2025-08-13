package com.teamx.vibecare.auth.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teamx.vibecare.auth.screens.LoginScreen
import com.teamx.vibecare.auth.screens.SetPasswordScreen
import com.teamx.vibecare.auth.screens.SignUpScreen


//@Composable
//fun AppNavigation(modifier: Modifier = Modifier) {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "SignIn") {
//        composable("SignIn") { LoginScreen(navController) }
//        composable("SignUp") { SignUpScreen(navController) }
//        composable(route = "Password") { SetPasswordScreen(navController) }
//
//}