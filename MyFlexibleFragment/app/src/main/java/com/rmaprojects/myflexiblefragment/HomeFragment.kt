package com.rmaprojects.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Pada HomeFragment terdapat metode onCreateView() di mana layout interface didefinisikan
//        dan ditransformasikan dari layout berupa file xml ke dalam objek view dengan menggunakan
//        metode inflate().
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCategory = view.findViewById<Button>(R.id.btn_category)
        btnCategory.setOnClickListener {
            val mCategoryFragment = CategoryFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction()
                //Jadi fragment nya di replace bambang...
                .replace(R.id.frame_layout, mCategoryFragment, CategoryFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }
}