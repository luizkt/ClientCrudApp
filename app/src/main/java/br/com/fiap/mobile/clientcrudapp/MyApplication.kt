package br.com.fiap.mobile.clientcrudapp

import android.app.Application
import br.com.fiap.mobile.clientcrudapp.di.networkModule
import br.com.fiap.mobile.clientcrudapp.di.repositoryModule
import br.com.fiap.mobile.clientcrudapp.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start stetho
        Stetho.initializeWithDefaults(this)
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    repositoryModule
                )
            )
        }
    }
}