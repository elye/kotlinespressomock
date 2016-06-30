package com.elyeproj.javadaggeruitest

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(ApplicationTestModule::class))
interface ApplicationTestComponent : ApplicationComponent
