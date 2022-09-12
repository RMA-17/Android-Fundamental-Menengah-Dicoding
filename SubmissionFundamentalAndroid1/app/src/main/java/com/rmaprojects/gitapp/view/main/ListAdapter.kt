package com.rmaprojects.gitapp.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rmaprojects.gitapp.R
import com.rmaprojects.gitapp.data.UserDataModel
import com.rmaprojects.gitapp.databinding.ItemUserBinding
import com.rmaprojects.gitapp.view.main.ListAdapter.ListAdapterViewHolder

class ListAdapter(private val listUserData:List<UserDataModel>) : RecyclerView.Adapter<ListAdapterViewHolder>() {

    var onclickListener:((UserDataModel) -> Unit)?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListAdapterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun onBindViewHolder(holder: ListAdapterViewHolder, position: Int) {
        val userData = listUserData[position]
        holder.bindView(userData)
        holder.binding.root.setOnClickListener {
            onclickListener?.invoke(userData)
        }
    }

    override fun getItemCount() = listUserData.size

    class ListAdapterViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        lateinit var binding:ItemUserBinding
        fun bindView(userData: UserDataModel) {
            binding = ItemUserBinding.bind(itemView)

            with (binding) {
                txtGithubLogin.text = userData.username
                txtGithubRepoCount.text = "${userData.repository} Repositories"
                txtGithubFollowersCount.text = "${userData.followers} Followers | ${userData.following} Following"
                Glide.with(itemView.context)
                    .load(userData.avatar)
                    .into(circleImageView)
            }
        }

    }

}