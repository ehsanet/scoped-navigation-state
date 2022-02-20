package ir.ehsanet.scopednavigationstate.screens.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

abstract class BaseScreen : Fragment() {

    abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            handleBackPressEvent()
        }
    }

    @CallSuper
    open fun handleBackPressEvent() {
        Log.d("NavigationLog", "Back Event in ${javaClass.name}")
    }

    override fun onStart() {
        super.onStart()
        onIntentData(arguments)
    }

    protected open fun onIntentData(arguments: Bundle?) {

    }

}