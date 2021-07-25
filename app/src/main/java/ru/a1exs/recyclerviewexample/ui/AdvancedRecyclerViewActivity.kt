package ru.a1exs.recyclerviewexample.ui

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import ru.a1exs.recyclerviewexample.adapters.UsersRecyclerAdapter
import ru.a1exs.recyclerviewexample.databinding.ActivityRecyclerViewBinding
import ru.a1exs.recyclerviewexample.di.UserDataProviderSize
import ru.a1exs.recyclerviewexample.domain.UserDataProvider

import androidx.core.content.ContextCompat

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator
import ru.a1exs.recyclerviewexample.R


class AdvancedRecyclerViewActivity : AppCompatActivity() {

    private val userDataProvider: UserDataProvider by inject(named(UserDataProviderSize.LARGE))
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: UsersRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Advanced RecyclerView"
        binding.root.layoutManager = LinearLayoutManager(this)
        binding.root.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter = UsersRecyclerAdapter(userDataProvider)
        binding.root.adapter = adapter

        val itemTouchHelper =
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    if (direction == ItemTouchHelper.LEFT) {
                        userDataProvider.users.removeAt(viewHolder.adapterPosition)
                        adapter.notifyItemRemoved(viewHolder.adapterPosition)
                    }
                }

                override fun onChildDraw(
                    c: Canvas,
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    dX: Float,
                    dY: Float,
                    actionState: Int,
                    isCurrentlyActive: Boolean
                ) {
                    RecyclerViewSwipeDecorator.Builder(
                        c,
                        recyclerView,
                        viewHolder,
                        dX,
                        dY,
                        actionState,
                        isCurrentlyActive
                    )
                        .addBackgroundColor(
                            ContextCompat.getColor(
                                this@AdvancedRecyclerViewActivity,
                                R.color.red
                            )
                        )
                        .addActionIcon(R.drawable.ic_baseline_delete_24)
                        .addSwipeRightLabel("Delete")
                        .create()
                        .decorate()

                    super.onChildDraw(
                        c,
                        recyclerView,
                        viewHolder,
                        dX,
                        dY,
                        actionState,
                        isCurrentlyActive
                    )
                }
            })

        itemTouchHelper.attachToRecyclerView(binding.root)
    }
}