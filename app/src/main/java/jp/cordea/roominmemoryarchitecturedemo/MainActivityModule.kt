package jp.cordea.roominmemoryarchitecturedemo

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jp.cordea.roominmemoryarchitecturedemo.dashboard.DashboardFragmentModule
import jp.cordea.roominmemoryarchitecturedemo.home.HomeFragmentModule
import jp.cordea.roominmemoryarchitecturedemo.notification.NotificationFragmentModule

@Module(
    includes = [
        DashboardFragmentModule::class,
        HomeFragmentModule::class,
        NotificationFragmentModule::class
    ]
)
interface MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainActivityBindModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}

@Module
abstract class MainActivityBindModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideViewModel(
            activity: ComponentActivity,
            factory: ViewModelFactory<MainViewModel>
        ): Lazy<MainViewModel> = activity.viewModels { factory }
    }

    @Binds
    abstract fun bindComponentActivity(activity: MainActivity): ComponentActivity
}
