package com.github.fajaragungpramana.ex.core.domain.auth

import com.github.fajaragungpramana.ex.core.data.remote.auth.request.AuthRequest

interface AuthUseCase {

    suspend fun setUser(authRequest: AuthRequest): Boolean

}