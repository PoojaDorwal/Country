package com.demo.country.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.country.models.Country

@Dao
interface CountryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountryList(country: List<Country>)

    @Query("SELECT * FROM country")
    suspend fun getCountryList() : List<Country>

    @Query("DELETE FROM country")
    suspend fun deleteAllList()


}