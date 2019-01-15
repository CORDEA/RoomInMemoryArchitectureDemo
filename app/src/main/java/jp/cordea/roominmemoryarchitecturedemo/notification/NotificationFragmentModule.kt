package jp.cordea.roominmemoryarchitecturedemo.notification

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jp.cordea.roominmemoryarchitecturedemo.ViewModelFactory

@Module
interface NotificationFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            NotificationFragmentBindModule::class
        ]
    )
    fun contributeNotificationFragment(): NotificationFragment
}

@Module
abstract class NotificationFragmentBindModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideViewModel(
            fragment: Fragment,
            factory: ViewModelFactory<NotificationViewModel>
        ): Lazy<NotificationViewModel> = fragment.viewModels { factory }
    }

    @Binds
    abstract fun bindFragment(fragment: NotificationFragment): Fragment
}
