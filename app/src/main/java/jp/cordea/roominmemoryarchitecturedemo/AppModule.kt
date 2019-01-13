package jp.cordea.roominmemoryarchitecturedemo

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "roominmemoryarchitecturedemo").build()

    @Provides
    fun provideMainStateDao(database: AppDatabase): MainStateDao = database.mainStateDao()
}
