package com.codeschool.myapplication.ui.ecommerce.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeschool.myapplication.R

class BottomSheetDialogFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = BottomSheetDialogFragment()
    }
}