package com.rmaprojects.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDetail = view.findViewById<Button>(R.id.btn_detail_category)
        btnDetail.setOnClickListener {
            val mHomeFragment = HomeFragment()
            val mFragmentManager =   parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout, mHomeFragment, HomeFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}