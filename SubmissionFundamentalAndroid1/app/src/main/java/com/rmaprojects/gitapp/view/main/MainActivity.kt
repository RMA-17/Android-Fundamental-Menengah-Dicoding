package com.rmaprojects.gitapp.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rmaprojects.gitapp.R
import com.rmaprojects.gitapp.data.UserDataModel
import com.rmaprojects.gitapp.databinding.ActivityMainBinding
import com.rmaprojects.gitapp.view.details.UserDetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userDataList = getUserDataLists()

        val adapter = ListAdapter(userDataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.onclickListener = { userData ->
            val intent = Intent(this, UserDetailActivity::class.java)
            intent.putExtra(UserDetailActivity.USER_DATA_KEY, userData)
            startActivity(intent)
        }
    }

    private fun getUserDataLists(): MutableList<UserDataModel> {
        val userList = mutableListOf<UserDataModel>()
        val name = resources.getStringArray(R.array.name)
        val username = resources.getStringArray(R.array.username)
        val avatar = getImageList()
        val company = resources.getStringArray(R.array.company)
        val followers = resources.getIntArray(R.array.followers)
        val following = resources.getIntArray(R.array.following)
        val location = resources.getStringArray(R.array.location)
        val repository = resources.getIntArray(R.array.repository)

        for (i in name.indices) {
            val userData = UserDataModel(
                name = name[i],
                avatar = avatar[i],
                username = username[i],
                company = company[i],
                followers = followers[i],
                following = following[i],
                location = location[i],
                repository = repository[i],
            )
            userList.add(userData)
        }
        return userList
    }

    private fun getImageList() : List<Int> {
        return listOf(
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
            R.drawable.user6,
            R.drawable.user7,
            R.drawable.user8,
            R.drawable.user9,
            R.drawable.user10
        )
    }
}