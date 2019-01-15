package jp.cordea.roominmemoryarchitecturedemo

import dagger.Module
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
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}
