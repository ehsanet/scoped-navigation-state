package ir.ehsanet.scopednavigationstate.data.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.ehsanet.scopednavigationstate.data.repository.GlobalRideRepository
import ir.ehsanet.scopednavigationstate.data.repository.RideRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    companion object DataModule {

        @Singleton
        @Provides
        fun provideSharedPreferences(
            @ApplicationContext app: Context
        ): SharedPreferences {
            return app.getSharedPreferences(
                "app_pref",
                Context.MODE_PRIVATE
            )
        }
    }

    @Binds
    abstract fun rideRepository(locationListenerImp: GlobalRideRepository) : RideRepository
}