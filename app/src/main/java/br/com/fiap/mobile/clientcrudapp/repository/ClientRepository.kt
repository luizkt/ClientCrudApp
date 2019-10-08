package br.com.fiap.mobile.clientcrudapp.repository

interface ClientRepository {
    fun checkHealth(
        onComplete:() -> Unit,
        onError: (Throwable?) -> Unit
    )
}