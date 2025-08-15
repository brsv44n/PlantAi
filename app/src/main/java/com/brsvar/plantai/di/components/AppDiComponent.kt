package com.brsvar.plantai.di.components

import android.app.Application
import android.content.Context
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.brsvar.core.di.annotations.Singleton
import com.brsvar.core.utils.BuildInfo
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Singleton
@Component
abstract class AppDiComponent(
    @get:Provides val application: Application,
    @get:Provides val storeFactory: StoreFactory,
    @get:Provides val buildInfo: BuildInfo
) {
    @get:Provides
    val context: Context by lazy { application }

}
