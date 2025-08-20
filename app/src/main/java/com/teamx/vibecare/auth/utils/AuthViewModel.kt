package com.teamx.vibecare.auth.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel: ViewModel() {

    private var _dob = MutableStateFlow("")
    val dob = _dob.asStateFlow()
    private var _name = MutableStateFlow("")
    val name = _name.asStateFlow()
    private var _email = MutableStateFlow("")
    val email = _email.asStateFlow()
    private var _password = MutableStateFlow("")
    val password = _password.asStateFlow()
    private var _confirmPassword = MutableStateFlow("")
    val confirmPassword = _confirmPassword.asStateFlow()
    private var _passwordVisibility = MutableStateFlow(false)
    val passwordVisibility = _passwordVisibility.asStateFlow()



    fun changeName(name: String){
        _name.value = name
    }
    fun changeEmail(email: String){
        print(email)
        _email.value = email
    }
    fun changePassword(password: String){
        _password.value = password
    }
    fun changeConfirmPassword(confirmPassword: String){
        _confirmPassword.value = confirmPassword

    }
    fun changePswVisibility(pswVisibility: Boolean){
        _passwordVisibility.value = pswVisibility

    }

    fun changeDOB(date:String){
        _dob.value = date

    }

}