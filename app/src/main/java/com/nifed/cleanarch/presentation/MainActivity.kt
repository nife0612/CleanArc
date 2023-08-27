package com.nifed.cleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.nifed.cleanarch.R
import com.nifed.cleanarch.data.UserRepositoryImpl
import com.nifed.cleanarch.domain.model.UserNameModel
import com.nifed.cleanarch.domain.usecase.GetDataUseCase
import com.nifed.cleanarch.domain.usecase.SaveDataUseCase

class MainActivity : AppCompatActivity() {


    private val userRepositoryImpl by lazy { UserRepositoryImpl(context = applicationContext) }
    private val getDataUseCase by lazy { GetDataUseCase(userRepositoryImpl) }
    private val saveDataUseCase by lazy { SaveDataUseCase(userRepositoryImpl) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getDataTV = findViewById<TextView>(R.id.getDataTV)
        val getDataBut = findViewById<Button>(R.id.getDataBut)
        val saveDataPT = findViewById<EditText>(R.id.saveDataPT)
        val saveDataBut = findViewById<Button>(R.id.saveDataBut)

        getDataBut.setOnClickListener{
            getDataTV.text = getDataUseCase.execute().name
        }

        saveDataBut.setOnClickListener{

            val result = saveDataUseCase.execute(
                UserNameModel(
                    saveDataPT.text.toString()
                )
            )

            getDataTV.text = result.toString()
        }

    }
}