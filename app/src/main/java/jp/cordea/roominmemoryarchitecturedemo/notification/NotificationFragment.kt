package jp.cordea.roominmemoryarchitecturedemo.notification

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.jakewharton.rxbinding3.view.clicks
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import jp.cordea.roominmemoryarchitecturedemo.databinding.FragmentNotificationBinding
import javax.inject.Inject

class NotificationFragment : Fragment() {
    companion object {
        fun newInstance() = NotificationFragment()
    }

    @Inject
    lateinit var viewModel: Lazy<NotificationViewModel>

    private val compositeDisposable = CompositeDisposable()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNotificationBinding.inflate(inflater, container, false)

        binding.button.clicks()
            .concatMapCompletable { viewModel.value.clicked() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            .addTo(compositeDisposable)

        viewModel.value.text
            .observe(this, Observer { binding.state.text = it })

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
