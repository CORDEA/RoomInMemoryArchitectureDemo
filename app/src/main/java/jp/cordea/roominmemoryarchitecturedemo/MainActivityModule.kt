package jp.cordea.roominmemoryarchitecturedemo

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.roominmemoryarchitecturedemo.dashboard.DashboardFragmentModule
import jp.cordea.roominmemoryarchitecturedemo.home.HomeFragmentModule

@Module(
    includes = [
        DashboardFragmentModule::class,
        HomeFragmentModule::class
    ]
)
interface MainActivityModule {
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}
