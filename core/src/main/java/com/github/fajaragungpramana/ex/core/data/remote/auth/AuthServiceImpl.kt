package com.github.fajaragungpramana.ex.core.data.remote.auth

import com.github.fajaragungpramana.ex.core.data.remote.auth.request.AuthRequest
import com.github.fajaragungpramana.ex.core.extension.onEmpty
import com.github.fajaragungpramana.ex.core.extension.removeNulls
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

class AuthServiceImpl @Inject constructor(
    private val mFirebaseAuth: FirebaseAuth,
    private val mFirebaseFirestore: FirebaseFirestore
) : AuthService {

    override suspend fun setUser(authRequest: AuthRequest): Boolean {
        if (!authRequest.password.equals(authRequest.confirmPassword)) {
            Timber.d(this::class.simpleName + " : setUser password and confirmation password not match.")

            return false
        }

        val auth = mFirebaseAuth.createUserWithEmailAndPassword(
            authRequest.email.onEmpty(),
            authRequest.password.onEmpty()
        ).await()

        val user = auth.user
        if (user == null) {
            Timber.d(this::class.simpleName + " : createUserWithEmailAndPassword is failure.")
            return false
        }

        authRequest.id = user.uid
        authRequest.password = null
        authRequest.confirmPassword = null

        val userCollection = mFirebaseFirestore.collection("users")
            .add(authRequest.removeNulls())
            .await()

        if (userCollection.id.isEmpty()) {
            Timber.d(this::class.simpleName + " : userCollection set failure.")

            return false
        }

        Timber.d(this::class.simpleName + " : setUser successfully.")
        return true
    }

}