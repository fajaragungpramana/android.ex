package com.github.fajaragungpramana.ex.core.domain.auth

import com.github.fajaragungpramana.ex.core.data.remote.auth.AuthRepository
import com.github.fajaragungpramana.ex.core.data.remote.auth.request.AuthRequest
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val mAuthRepository: AuthRepository) :
    AuthUseCase {

    override suspend fun setUser(authRequest: AuthRequest) = mAuthRepository.setUser(authRequest)

}