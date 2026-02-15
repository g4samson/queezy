package com.profs.queezy.domain.di

import com.profs.queezy.domain.service.DomainService
import com.profs.queezy.domain.service.DomainServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainServiceModule {

    @Binds
    @Singleton
    abstract fun bindDomainService(
        impl: DomainServiceImpl
    ): DomainService

}