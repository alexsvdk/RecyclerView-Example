package ru.a1exs.recyclerviewexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.forEach
import androidx.core.view.get
import com.google.android.material.snackbar.Snackbar
import ru.a1exs.recyclerviewexample.R
import ru.a1exs.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (binding.root[0] as LinearLayout).forEach { (it as? Button)?.setOnClickListener(this) }
    }

    override fun onClick(v: View?) {
        v ?: return
        val intent = when (v.id) {
            R.id.btn_lv_short -> Intent(this, SmallListActivity::class.java)
            R.id.btn_lv_long -> Intent(this, LargeListActivity::class.java)
            //R.id.btn_rv -> Intent(this, RecyclerViewActivity::class.java)
            //R.id.btn_rv_adv -> Intent(this, AdvancedRecyclerViewActivity::class.java)
            else -> null
        }
        intent?.let(::startActivity) ?: Snackbar.make(
            binding.root,
            "Not implemented",
            Snackbar.LENGTH_SHORT
        ).show()
    }
}