package jp.cordea.roominmemoryarchitecturedemo.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jp.cordea.roominmemoryarchitecturedemo.ViewModelFactory

@Module
interface HomeFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            HomeFragmentBindModule::class
        ]
    )
    fun contributeHomeFragment(): HomeFragment
}

@Module
abstract class HomeFragmentBindModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideViewModel(
            fragment: Fragment,
            factory: ViewModelFactory<HomeViewModel>
        ): Lazy<HomeViewModel> = fragment.createViewModelLazy(HomeViewModel::class, { fragment }, { factory })
    }

    @Binds
    abstract fun bindFragment(fragment: HomeFragment): Fragment
}
