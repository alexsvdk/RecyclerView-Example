package ru.a1exs.recyclerviewexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.a1exs.recyclerviewexample.databinding.ItemUserBinding
import ru.a1exs.recyclerviewexample.domain.UserDataProvider

class UsersRecyclerAdapter(private val data: UserDataProvider) :
    RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context)))


    override fun onBindViewHolder(holder: UserViewHolder, position: Int){
        if (data.users.size < position + 10)
            data.loadUsers(10)
        holder.bind(data.users[position])
    }

    override fun getItemCount(): Int = data.count
}