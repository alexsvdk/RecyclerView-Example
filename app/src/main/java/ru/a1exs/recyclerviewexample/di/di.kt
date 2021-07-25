package ru.a1exs.recyclerviewexample.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.a1exs.recyclerviewexample.domain.DataGenerator
import ru.a1exs.recyclerviewexample.domain.UserDataProvider

enum class UserDataProviderSize(val size: Int) {
    SMALL(100),
    LARGE(5000),
}

val module = module {

    single { DataGenerator() }

    UserDataProviderSize.values().forEach { size ->
        single(named(size)) { UserDataProvider(get(), size.size) }
    }

}