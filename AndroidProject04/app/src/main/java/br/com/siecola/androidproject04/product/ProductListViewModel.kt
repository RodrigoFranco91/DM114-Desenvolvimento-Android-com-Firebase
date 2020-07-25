package br.com.siecola.androidproject04.product

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.siecola.androidproject04.persistence.Product
import br.com.siecola.androidproject04.persistence.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
private const val TAG = "ProductListViewModel"

class ProductListViewModel : ViewModel() {
    private lateinit var _products: MutableLiveData<List<Product>>
    val products: LiveData<List<Product>>
        get() = _products

    init {
        getProducts()
    }



    private fun getProducts() {
        _products = ProductRepository.getProducts()
    }

    override fun onCleared() {
        super.onCleared()
    }
}