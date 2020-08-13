package com.memento.fragments

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.memento.databinding.FragmentMainBinding
import com.memento.databinding.FragmentScannerBinding

object CameraPermissionHelper {
    private val CAMERA_PERMISSION_CODE = 0
    private val CAMERA_PERMISSION = Manifest.permission.CAMERA

    fun hasCameraPermission(activity: Activity): Boolean {
        return (ContextCompat.checkSelfPermission(activity, CAMERA_PERMISSION)
                == PackageManager.PERMISSION_GRANTED)
    }

    fun requestCameraPermission(activity: Activity) {
        val perm = arrayOf(CAMERA_PERMISSION)
        ActivityCompat.requestPermissions(activity, perm, CAMERA_PERMISSION_CODE)
    }

    fun shouldShowRequestPermissionRationale(activity: Activity): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, CAMERA_PERMISSION)
    }

    // fun launchPermissionSettings(activity : Activity) {//}

}

class ScannerFragment : Fragment() {
    private var tmpBinding: FragmentScannerBinding? = null
    private val sBinding get() = tmpBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tmpBinding = FragmentScannerBinding.inflate(inflater, container, false)
        return sBinding.root
    }

    //The permission should be handled by the ARFragment!!!

    override fun onResume() {
        super.onResume()
        if (!CameraPermissionHelper.hasCameraPermission(requireActivity())) {
            CameraPermissionHelper.requestCameraPermission(requireActivity())
        }
    }

    override fun onDestroyView() {
        tmpBinding = null
        super.onDestroyView()
    }

}