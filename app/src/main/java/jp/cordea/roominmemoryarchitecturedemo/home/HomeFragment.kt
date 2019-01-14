package jp.cordea.roominmemoryarchitecturedemo.home


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
import jp.cordea.roominmemoryarchitecturedemo.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : Fragment() {
    companion object {
        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var viewModel: Lazy<HomeViewModel>

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
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

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
