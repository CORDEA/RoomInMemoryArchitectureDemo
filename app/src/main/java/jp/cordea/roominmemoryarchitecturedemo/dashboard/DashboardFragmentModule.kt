package jp.cordea.roominmemoryarchitecturedemo.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jp.cordea.roominmemoryarchitecturedemo.ViewModelFactory

@Module
interface DashboardFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            DashboardFragmentBindModule::class
        ]
    )
    fun contributeDashboardFragment(): DashboardFragment
}

@Module
abstract class DashboardFragmentBindModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideViewModel(
            fragment: Fragment,
            factory: ViewModelFactory<DashboardViewModel>
        ): Lazy<DashboardViewModel> = fragment.createViewModelLazy(DashboardViewModel::class, { fragment }, { factory })
    }

    @Binds
    abstract fun bindFragment(fragment: DashboardFragment): Fragment
}
