package com.rmaprojects.gitapp.view.details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rmaprojects.gitapp.data.UserDataModel
import com.rmaprojects.gitapp.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userData = intent.getParcelableExtra(USER_DATA_KEY) ?: UserDataModel("", "", "", 0, "", 0, 0, 0)

        with(binding) {
            toolBar.setNavigationOnClickListener {
                finish()
            }
            txtName.text = userData.name
            txtLogin.text = userData.username
            txtCompany.text = userData.company
            txtLocation.text = userData.location
            txtRepositoryCount.text = userData.repository.toString()
            txtFollowersCount.text = userData.followers.toString()
            txtFollowingCount.text = userData.following.toString()
            Glide.with(this@UserDetailActivity)
                .load(userData.avatar)
                .into(imgDetail)
            btnShare.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                val dataToShare = "${userData.name} is on GitHub\n\n\nvisit ${userData.name} now on https://github.com/${userData.name}"
                intent.putExtra(Intent.EXTRA_TEXT, dataToShare)
                startActivity(Intent.createChooser(intent, "Share Via"))
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    companion object {
        const val USER_DATA_KEY = "USER_DATA_VALUE"
    }
}