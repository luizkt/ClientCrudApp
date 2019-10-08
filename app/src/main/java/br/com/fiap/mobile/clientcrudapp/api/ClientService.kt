package br.com.fiap.mobile.clientcrudapp.api

import br.com.fiap.mobile.clientcrudapp.model.HealthResponse
import retrofit2.Call
import retrofit2.http.GET

interface ClientService {
    @GET("/health")
    fun checkHealth(): Call<HealthResponse>
}