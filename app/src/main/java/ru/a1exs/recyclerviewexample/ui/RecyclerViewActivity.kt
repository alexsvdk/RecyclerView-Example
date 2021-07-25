package ru.a1exs.recyclerviewexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.a1exs.recyclerviewexample.R
import ru.a1exs.recyclerviewexample.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}