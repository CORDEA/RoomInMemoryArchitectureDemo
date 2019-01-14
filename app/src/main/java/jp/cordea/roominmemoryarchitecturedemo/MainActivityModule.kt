package jp.cordea.roominmemoryarchitecturedemo

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.roominmemoryarchitecturedemo.dashboard.DashboardFragmentModule

@Module(
    includes = [
        DashboardFragmentModule::class
    ]
)
interface MainActivityModule {
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}
