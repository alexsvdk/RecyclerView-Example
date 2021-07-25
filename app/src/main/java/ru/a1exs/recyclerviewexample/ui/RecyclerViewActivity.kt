package ru.a1exs.recyclerviewexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.core.qualifier.named
import org.koin.android.ext.android.get
import ru.a1exs.recyclerviewexample.adapters.UsersRecyclerAdapter
import ru.a1exs.recyclerviewexample.databinding.ActivityRecyclerViewBinding
import ru.a1exs.recyclerviewexample.di.UserDataProviderSize
import ru.a1exs.recyclerviewexample.domain.UserDataProvider

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "RecyclerView"
        binding.root.layoutManager = LinearLayoutManager(this)
        binding.root.adapter = UsersRecyclerAdapter(get(named(UserDataProviderSize.LARGE)))
    }
}