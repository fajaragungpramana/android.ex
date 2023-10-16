package com.github.fajaragungpramana.ex.core.domain.di

import com.github.fajaragungpramana.ex.core.data.remote.auth.AuthRepository
import com.github.fajaragungpramana.ex.core.domain.auth.AuthInteractor
import com.github.fajaragungpramana.ex.core.domain.auth.AuthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun authUseCase(authRepository: AuthRepository): AuthUseCase = AuthInteractor(
        mAuthRepository = authRepository
    )

}