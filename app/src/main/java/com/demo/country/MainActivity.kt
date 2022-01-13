package com.demo.country

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.demo.country.data.adapters.CountryAdapter
import com.demo.country.data.api.RetrofitBuilder
import com.demo.country.data.local.AppDatabase
import com.demo.country.databinding.ActivityMainBinding
import com.demo.country.models.Country
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setAdapter()
        getDataFromNetwork()

        binding.ivDelete.setOnClickListener {
            deleteCountryListFromDatabase()
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        }

        binding.ivRefresh.setOnClickListener {
            getDataFromNetwork()
        }


    }

    private fun setAdapter() {
        adapter = CountryAdapter()
        binding.rvCountry.adapter = adapter
    }


    private fun getDataFromDatabase() {

        val db = AppDatabase.getInstance(this)
        val countryDAO = db.countryDAO()

        lifecycleScope.launch {
            val list = countryDAO.getCountryList()
            adapter.submitList(list)

        }
    }

    private fun deleteCountryListFromDatabase() {

        val db = AppDatabase.getInstance(this)
        val countryDAO = db.countryDAO()

        lifecycleScope.launch {
            countryDAO.deleteAllList()
            getDataFromDatabase()
        }

    }

    private fun saveCountryListInDatabase(list: List<Country>) {

        val db = AppDatabase.getInstance(this)
        val countryDAO = db.countryDAO()

        lifecycleScope.launch {
            countryDAO.insertCountryList(list)
            getDataFromDatabase()
        }

    }

    private fun getDataFromNetwork() {

        lifecycleScope.launch {

            try {
                getDataFromDatabase()

                val res = RetrofitBuilder.apiService.getCountries()

                saveCountryListInDatabase(res)

            } catch (e: Exception) {

                Log.d("ERROR", "${e.message}")
            }

        }
    }
}