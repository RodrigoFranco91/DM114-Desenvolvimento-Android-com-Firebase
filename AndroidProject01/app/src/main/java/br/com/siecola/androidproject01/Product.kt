package br.com.siecola.androidproject01

import java.io.Serializable

data class Product(var name: String, var description: String, var code: String, var price: Double) : Serializable