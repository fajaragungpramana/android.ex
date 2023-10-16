package com.github.fajaragungpramana.ex.core.data.remote.auth.di

import com.github.fajaragungpramana.ex.core.data.remote.auth.AuthRepository
import com.github.fajaragungpramana.ex.core.data.remote.auth.AuthRepositoryImpl
import com.github.fajaragungpramana.ex.core.data.remote.auth.AuthService
import com.github.fajaragungpramana.ex.core.data.remote.auth.AuthServiceImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AuthModule {

    @Provides
    fun provideAuthService(
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore
    ): AuthService = AuthServiceImpl(
        mFirebaseAuth = firebaseAuth,
        mFirebaseFirestore = firebaseFirestore
    )

    @Provides
    fun provideAuthRepository(authService: AuthService): AuthRepository = AuthRepositoryImpl(
        mAuthService = authService
    )

}