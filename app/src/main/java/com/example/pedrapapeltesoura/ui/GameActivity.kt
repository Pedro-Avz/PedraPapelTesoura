package com.example.pedrapapeltesoura.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.databinding.ActivityGameBinding

class GameActivity: AppCompatActivity() {
    private val acb: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }
    private var mao: String? = null
    private var aplicativo1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acb.root)
        acb.toolbarIn.toolbar.apply {
            subtitle = this@GameActivity.javaClass.simpleName
            setSupportActionBar(this)
        }

        acb.imgStone.setOnClickListener{
            mao = "pedra"
        }

        acb.imgPaper.setOnClickListener{
            mao = "papel"
        }

        acb.imgScizor.setOnClickListener{
            mao = "tesoura"
        }


        acb.jogarBt.setOnClickListener {
            aplicativo1 = jogadaAplicativo()
            dueloJokenpo(mao, aplicativo1)
        }

    }

    private fun dueloJokenpo(maoUsuario:String?, maoAplicativo:String?){

        if (maoUsuario == maoAplicativo){
            Toast.makeText(this , "O jogo terminou empatado o adversário também escolheu " + maoAplicativo, Toast.LENGTH_LONG).show()
        }else if((
            maoUsuario == "pedra" && maoAplicativo == "tesoura" ||
            maoUsuario == "papel" && maoAplicativo == "pedra" ||
            maoUsuario == "tesoura" && maoAplicativo == "papel"    
        )){
            Toast.makeText(this, "Você venceu, o adversário escolheu " + maoAplicativo, Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Você perdeu, o adversário escolheu " + maoAplicativo, Toast.LENGTH_LONG).show()
        }

    }
    private fun jogadaAplicativo(): String {
        val maos = arrayOf("pedra", "papel", "tesoura")
        val maoAplicativo = (0 until maos.size).random()
        return maos[maoAplicativo]
    }
}