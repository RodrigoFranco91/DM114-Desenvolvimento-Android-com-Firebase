package br.com.siecola.androidproject01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.siecola.androidproject01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnSave.setOnClickListener {
            if (!binding.edtName.text.isEmpty()) {
                binding.txtName.text = binding.edtName.text
                binding.txtDescription.text = binding.edtDescription.text
                binding.txtCode.text = binding.edtCode.text
                binding.txtPrice.text = binding.edtPrice.text
            } else {
                Toast.makeText(this, "Please, enter the name.", Toast.LENGTH_SHORT).show()
            }
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val product = Product(
            name = binding.edtName.text.toString(),
            description = binding.edtDescription.text.toString(),
            code = binding.edtCode.text.toString(),
            price = binding.edtPrice.text.toString().toDouble())
        outState.putSerializable("product", product)

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val product = savedInstanceState.getSerializable("product") as Product
        binding.txtName.text = product.name
        binding.txtDescription.text = product.description
        binding.txtCode.text = product.code
        binding.txtPrice.text = product.price.toString()

    }
}