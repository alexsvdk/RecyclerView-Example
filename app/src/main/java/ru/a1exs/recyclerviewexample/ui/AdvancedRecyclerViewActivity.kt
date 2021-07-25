package ru.a1exs.recyclerviewexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.a1exs.recyclerviewexample.R
import ru.a1exs.recyclerviewexample.databinding.ActivityAdvancedRecyclerViewBinding

class AdvancedRecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdvancedRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvancedRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}