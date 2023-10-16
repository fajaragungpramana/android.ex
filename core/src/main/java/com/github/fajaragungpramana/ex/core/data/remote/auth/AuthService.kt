package com.github.fajaragungpramana.ex.core.data.remote.auth

import com.github.fajaragungpramana.ex.core.data.remote.auth.request.AuthRequest

interface AuthService {

    suspend fun setUser(authRequest: AuthRequest): Boolean

}