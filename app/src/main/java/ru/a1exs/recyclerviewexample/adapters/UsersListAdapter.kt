package ru.a1exs.recyclerviewexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import ru.a1exs.recyclerviewexample.R
import ru.a1exs.recyclerviewexample.databinding.ItemUserBinding
import ru.a1exs.recyclerviewexample.models.User


class UsersListAdapter(context: Context, private val data: List<User>) :
    ArrayAdapter<User>(context, R.layout.item_user, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val user = data[position]
        val binding = ItemUserBinding.inflate(LayoutInflater.from(context))
        binding.card.setCardBackgroundColor(user.favoriteColor)
        binding.name.text = "${user.firstName} ${user.lastName}"
        binding.city.text = user.city
        Glide.with(context).asGif().load(user.gitUrl).into(binding.image)
        return binding.root
    }

}