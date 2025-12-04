package com.ssu.portfolio.fooddeliveryapp.data.repoimplement

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.ssu.portfolio.fooddeliveryapp.common.ResultState
import com.ssu.portfolio.fooddeliveryapp.data.models.userData
import com.ssu.portfolio.fooddeliveryapp.domain.repo.Repo
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore
) : Repo {

    companion object {
        const val USER_COLLECTION = "Users"
    }


    // Register User


    override fun registerWithEmailAndPassword(userData: userData): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)

            firebaseAuth.createUserWithEmailAndPassword(userData.email, userData.password)
                .addOnCompleteListener { authTask ->
                    if (authTask.isSuccessful) {

                        // Save user data in Firestore
                        firebaseFirestore.collection(USER_COLLECTION)
                            .document(authTask.result.user?.uid ?: "")
                            .set(userData)
                            .addOnCompleteListener { firestoreTask ->
                                if (firestoreTask.isSuccessful) {
                                    trySend(ResultState.Success("User Registered Successfully"))
                                } else {
                                    trySend(
                                        ResultState.Error(
                                            firestoreTask.exception?.localizedMessage
                                                ?: "Firestore error"
                                        )
                                    )
                                }
                            }

                    } else {
                        trySend(
                            ResultState.Error(
                                authTask.exception?.localizedMessage ?: "Auth error"
                            )
                        )
                    }
                }

            awaitClose { close() }
        }


    // login user
    override fun loginWithEmailAndPassword(userData: userData): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)

            firebaseAuth.signInWithEmailAndPassword(userData.email, userData.password)
                .addOnCompleteListener { loginTask ->
                    if (loginTask.isSuccessful) {
                        trySend(ResultState.Success("Login Successful"))
                    } else {
                        trySend(
                            ResultState.Error(
                                loginTask.exception?.localizedMessage ?: "Login failed"
                            )
                        )
                    }
                }

            awaitClose { close() }
        }
}
