package com.brsvar.plantai.di.components

import android.app.Application
import android.content.Context
import com.brsvar.core.di.annotations.Singleton
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Singleton
@Component
abstract class AppDiComponent(
    @get:Provides open val application: Application,
//    open val buildInfo: BuildInfo
) {
    @get:Provides
    val context: Context by lazy { application }

}
