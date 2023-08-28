package com.nifed.cleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.nifed.cleanarch.R
import com.nifed.cleanarch.domain.usecase.SaveDataUseCase
import com.nifed.cleanarch.domain.usecase.GetDataUseCase
import com.nifed.clanarch.data.repository.UserRepositoryImpl
import com.nifed.clanarch.data.storage.sharpref.SharedPrefUserStorage


class MainActivity : AppCompatActivity() {


    private val sharedPrefUserStorage by lazy {
        SharedPrefUserStorage(
            context = applicationContext
        )
    }
    private val userRepositoryImpl by lazy {
        UserRepositoryImpl(
            sharedPrefUserStorage
        )
    }
    private val getDataUseCase by lazy {
        GetDataUseCase(
            userRepositoryImpl
        )
    }
    private val saveDataUseCase by lazy {
        SaveDataUseCase(
            userRepositoryImpl
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getDataTV = findViewById<TextView>(R.id.getDataTV)
        val getDataBut = findViewById<Button>(R.id.getDataBut)
        val saveDataPT = findViewById<EditText>(R.id.saveDataPT)
        val saveDataBut = findViewById<Button>(R.id.saveDataBut)

        getDataBut.setOnClickListener{
            getDataTV.text = getDataUseCase.execute().firstName
        }

        saveDataBut.setOnClickListener{

            val result = saveDataUseCase.execute(
                com.nifed.cleanarch.domain.model.UserNameModel(
                    firstName = saveDataPT.text.toString(),
                    secondName = saveDataPT.text.toString()
                )
            )

            getDataTV.text = result.toString()
        }

    }
}