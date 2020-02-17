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

        //Coletando Data atual do sistema
        val dataAtual = Calendar.getInstance();
        //Setando datas individualmente
        val dia = dataAtual.get(Calendar.DAY_OF_MONTH);
        val mes = dataAtual.get(Calendar.MONTH);
        val ano = dataAtual.get(Calendar.YEAR);
        //Fonte a ssr utilizada na exibição da resposta ao usuário
        var font = 25;
        //Setando a fonte
        txtDataEscolhida.textSize = font.toFloat();

        //Evento click do botão a exibir o calendário
        floatBtn.setOnClickListener {
            val myBtn = DatePickerDialog(this,
                //Aqui recebo a data escolhida do calendário exibido
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    //Validações são feitas aqui
                    if(year<1900){
                        txtDataEscolhida.setText("Você Ta Velinho!");
                    }else if(year>ano){
                        txtDataEscolhida.setText("Digite Uma Data Válida!");
                    }else {
                        //Aqui faço a subtração do ano atual pelo ano do nascimento
                        txtDataEscolhida.setText("Voce Tem: " + (ano - year) + " Anos");
                    }
                },dia,mes,ano)
            //Aqui defino as datas limites do calendário, máximo e mínimo
            dataAtual.set(1900,Calendar.JANUARY,Calendar.DATE);
            myBtn.datePicker.minDate = dataAtual.timeInMillis;
            myBtn.datePicker.maxDate = System.currentTimeMillis()-1000;
            myBtn.updateDate(2020,Calendar.MONTH,Calendar.DAY_OF_MONTH);
            myBtn.show();
        }
        }
    }

