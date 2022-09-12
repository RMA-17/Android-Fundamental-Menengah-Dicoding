package com.rmaprojects.myflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name: ${HomeFragment::class.java.simpleName}")
            mFragmentManager.beginTransaction()
//            FrameLayout memiliki sifat sebagai berikut: semua komponen view di dalam framelayout bersifat menumpuk.
//            Bila pada suatu hirarki framelayout terdapat satu view dengan posisi teratas,
//            maka view tersebut akan menjadi alas untuk view di atasnya.
                .add(R.id.frame_layout, mHomeFragment, HomeFragment::class.java.simpleName)
                .commit()
//            Dengan karakteristik seperti ini, FrameLayout merupakan sebuah layout yang paling optimal
//            dalam proses manipulasi penampilan objek fragment ke layar pengguna.
        }
    }
}