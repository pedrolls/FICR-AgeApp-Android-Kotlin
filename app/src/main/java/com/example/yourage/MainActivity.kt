package com.example.yourage

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.provider.Settings
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.time.days
import kotlin.Int as Int1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataAtual = Calendar.getInstance();
        val dia = dataAtual.get(Calendar.DAY_OF_MONTH);
        val mes = dataAtual.get(Calendar.MONTH);
        val ano = dataAtual.get(Calendar.YEAR);
        var font = 25;

        txtDataEscolhida.textSize = font.toFloat();

        floatBtn.setOnClickListener {
            val myBtn = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    if(year<1900){
                        txtDataEscolhida.setText("Você Ta Velinho!");
                    }else if(year>ano){
                        txtDataEscolhida.setText("Digite Uma Data Válida!");
                    }else {
                        txtDataEscolhida.setText("Voce Tem: " + (ano - year) + " Anos");
                    }
                },dia,mes,ano)
            dataAtual.set(1900,Calendar.JANUARY,Calendar.DATE);
            myBtn.datePicker.minDate = dataAtual.timeInMillis;
            myBtn.datePicker.maxDate = System.currentTimeMillis();
            myBtn.updateDate(2020,Calendar.MONTH,Calendar.DAY_OF_MONTH);
            myBtn.show();
        }
        }
    }

