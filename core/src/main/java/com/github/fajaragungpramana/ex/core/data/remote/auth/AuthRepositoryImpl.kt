package com.github.fajaragungpramana.ex.core.data.remote.auth

import com.github.fajaragungpramana.ex.core.data.remote.auth.request.AuthRequest
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val mAuthService: AuthService) :
    AuthRepository {

    override suspend fun setUser(authRequest: AuthRequest) = mAuthService.setUser(authRequest)

}