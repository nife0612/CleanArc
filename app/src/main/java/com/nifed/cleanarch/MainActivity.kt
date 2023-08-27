package com.nifed.cleanarch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.nifed.cleanarch.domain.model.SaveUserName
import com.nifed.cleanarch.domain.usecase.GetDataUseCase
import com.nifed.cleanarch.domain.usecase.SaveDataUseCase

class MainActivity : AppCompatActivity() {

    private val getDataUseCase = GetDataUseCase()
    private val saveDataUseCase = SaveDataUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getDataTV = findViewById<TextView>(R.id.getDataTV)
        val getDataBut = findViewById<Button>(R.id.getDataBut)
        val saveDataPT = findViewById<EditText>(R.id.saveDataPT)
        val saveDataBut = findViewById<Button>(R.id.saveDataBut)

        getDataBut.setOnClickListener{
            getDataUseCase.execute()
        }

        saveDataBut.setOnClickListener{

            val result = saveDataUseCase.execute(
                SaveUserName(
                    saveDataPT.text.toString()
                )
            )

            getDataTV.text = result.toString()
        }

    }
}