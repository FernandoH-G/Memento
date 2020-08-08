package com.memento.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.memento.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var tmpBinding: FragmentMainBinding? = null
    private val mBinding get() = tmpBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tmpBinding = FragmentMainBinding.inflate(inflater,container, false)
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()
        mBinding.BTNSlideUp.setOnClickListener {
            val toScanner = MainFragmentDirections
                .actionMainFragmentToScannerFragment()
            Navigation.findNavController(mBinding.root)
                .navigate(toScanner)
//            Log.d("Main", "string")
        }
    }

    override fun onDestroyView() {
        tmpBinding = null
        super.onDestroyView()
    }
}