package ru.a1exs.recyclerviewexample.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.a1exs.recyclerviewexample.databinding.ItemUserBinding
import ru.a1exs.recyclerviewexample.models.User

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User){
        binding.card.setCardBackgroundColor(user.favoriteColor)
        binding.name.text = "${user.firstName} ${user.lastName}"
        binding.city.text = user.city
        Glide.with(binding.image).asGif().load(user.gitUrl).into(binding.image)
    }

}