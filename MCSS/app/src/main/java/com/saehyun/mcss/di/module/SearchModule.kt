package com.saehyun.mcss.di.module

import com.saehyun.mcss.data.search.SearchRepository
import com.saehyun.mcss.feature.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    factory { SearchRepository() }
    viewModel { SearchViewModel(get()) }
}
