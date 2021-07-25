package ru.a1exs.recyclerviewexample.ui


import android.os.Bundle
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import ru.a1exs.recyclerviewexample.di.UserDataProviderSize
import ru.a1exs.recyclerviewexample.domain.UserDataProvider

class LargeListActivity : ListActivity() {

    override val usersProvider by inject<UserDataProvider>(named(UserDataProviderSize.LARGE))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Large ListView"
    }
}