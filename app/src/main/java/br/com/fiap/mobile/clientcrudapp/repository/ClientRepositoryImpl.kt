package br.com.fiap.mobile.clientcrudapp.repository

import br.com.fiap.mobile.clientcrudapp.api.ClientService
import br.com.fiap.mobile.clientcrudapp.model.HealthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClientRepositoryImpl (var clientService: ClientService) :
    ClientRepository {
    override fun checkHealth(onComplete: () -> Unit, onError: (Throwable?) -> Unit) {
        clientService.checkHealth()
            .enqueue(object : Callback<HealthResponse> {
                override fun onFailure(call: Call<HealthResponse>, t: Throwable) {
                    onError(t)
                }
                override fun onResponse(call: Call<HealthResponse>, response:
                Response<HealthResponse>
                ) {
                    onComplete()
                }
            })
    }
}