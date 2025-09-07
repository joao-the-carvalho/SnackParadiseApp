package com.snackparadise.di

import android.content.Context
import com.snackparadise.data.local.AssetsRepository
import com.snackparadise.data.repository.MenuRepositoryImpl
import com.snackparadise.domain.repository.MenuRepository
import com.snackparadise.domain.usecase.GetMenuUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAssetsRepository(context: Context): AssetsRepository =
        AssetsRepository(context)

    @Provides
    @Singleton
    fun provideMenuRepository(assetsRepository: AssetsRepository): MenuRepository =
        MenuRepositoryImpl(assetsRepository)

    @Provides
    @Singleton
    fun provideGetMenuUseCase(repo: MenuRepository): GetMenuUseCase =
        GetMenuUseCase(repo)
}
