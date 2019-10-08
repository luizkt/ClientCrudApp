package br.com.fiap.mobile.clientcrudapp.di

import br.com.fiap.mobile.clientcrudapp.api.ClientService
import br.com.fiap.mobile.clientcrudapp.repository.ClientRepository
import br.com.fiap.mobile.clientcrudapp.repository.ClientRepositoryImpl
import br.com.fiap.mobile.clientcrudapp.view.splash.SplashViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private fun createNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://crud-mysql-heroku-cliente.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
}
val repositoryModule = module {
    single<ClientRepository> { ClientRepositoryImpl(get()) }
}
val networkModule = module {
    single { createNetworkClient(get()).create(ClientService::class.java) }
}