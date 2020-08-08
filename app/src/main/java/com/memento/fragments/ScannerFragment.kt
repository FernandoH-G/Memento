package com.memento.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memento.databinding.FragmentMainBinding
import com.memento.databinding.FragmentScannerBinding


class ScannerFragment : Fragment() {
    private var tmpBinding: FragmentScannerBinding? = null
    private val sBinding get() = tmpBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tmpBinding = FragmentScannerBinding.inflate(inflater,container,false)
        return sBinding.root
    }

    override fun onDestroyView() {
        tmpBinding = null
        super.onDestroyView()
    }
}