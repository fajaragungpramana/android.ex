package com.github.fajaragungpramana.ex.ui.auth.signin

import androidx.lifecycle.ViewModel
import com.github.fajaragungpramana.ex.core.domain.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val mAuthUseCase: AuthUseCase) : ViewModel() {
}