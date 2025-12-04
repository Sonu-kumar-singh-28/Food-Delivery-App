package com.ssu.portfolio.fooddeliveryapp.domain.domainmodule


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.ssu.portfolio.fooddeliveryapp.data.repoimplement.RepoImpl
import com.ssu.portfolio.fooddeliveryapp.domain.repo.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun provideRepo(firebaseAuth: FirebaseAuth, firebaseFirestore: FirebaseFirestore): Repo {
        return RepoImpl(firebaseAuth, firebaseFirestore)
    }
}
