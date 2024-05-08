package com.example.pedrapapeltesoura.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.R
import com.example.pedrapapeltesoura.databinding.ActivityGameLagartoSpockBinding
import com.example.pedrapapeltesoura.model.Jokenpo

class GameActivityLagartoSpock: AppCompatActivity() {
    private val agls: ActivityGameLagartoSpockBinding by lazy {
        ActivityGameLagartoSpockBinding.inflate(layoutInflater)
    }
    private var mao: String? = null
    private var aplicativo1: String? = null
    private val jokenpo = Jokenpo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(agls.root)
        agls.toolbarIn.toolbar.apply {
            subtitle = this@GameActivityLagartoSpock.javaClass.simpleName
            setSupportActionBar(this)
        }

        agls.imgStone.setOnClickListener{
            mao = "pedra"

        }

        agls.imgPaper.setOnClickListener{
            mao = "papel"

        }

        agls.imgScizor.setOnClickListener{
            mao = "tesoura"

        }
        agls.imgLagarto.setOnClickListener{
            mao = "lagarto"

        }

        agls.imgSpock.setOnClickListener{
            mao = "spock"

        }

        agls.jogarBt.setOnClickListener {
            aplicativo1 = jogadaAplicativo()
            dueloJokenpo(mao, aplicativo1)

            agls.imgAplicativo1.setImageResource(getImageResourceForChoice(aplicativo1))
            agls.aplicativo1Tv.visibility = View.VISIBLE
            agls.imgAplicativo1.visibility = View.VISIBLE
        }

    }

    //verificacao do vencedor
    private fun dueloJokenpo(maoUsuario:String?, maoAplicativo:String?){
        println("MAO USUARIO")
        println(maoUsuario)
        if (maoUsuario == maoAplicativo){
            Toast.makeText(this , "Você EMPATOU!!!", Toast.LENGTH_SHORT).show()
        }else if((
                    maoUsuario == "pedra" && maoAplicativo == "tesoura" ||
                            maoUsuario == "pedra" && maoAplicativo == "lagarto" ||
                            maoUsuario == "tesoura"  && maoAplicativo == "papel"||
                            maoUsuario == "tesoura"  && maoAplicativo == "lagarto"||
                            maoUsuario == "papel" && maoAplicativo == "pedra" ||
                            maoUsuario == "papel" && maoAplicativo == "spock" ||
                            maoUsuario == "lagarto" && maoAplicativo == "papel" ||
                            maoUsuario == "lagarto" && maoAplicativo == "spock" ||
                            maoUsuario == "spock" && maoAplicativo == "pedra" ||
                            maoUsuario == "spock" && maoAplicativo == "tesoura"
        )){
            Toast.makeText(this, "Você VENCEU !!!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Você PERDEU !!!", Toast.LENGTH_SHORT).show()
        }
    }
    //pegar um jogada random do app
    private fun jogadaAplicativo(): String {
        val maos = jokenpo.maos.random()
        return maos
    }


    private fun getImageResourceForChoice(choice: String?): Int {
        return when (choice) {
            "pedra" -> R.drawable.vetor_pedra
            "papel" -> R.drawable.vetor_papel
            "tesoura" -> R.drawable.vetor_tesoura
            "lagarto" -> R.drawable.lagarto_hand
            "spock" -> R.drawable.hand_spock
            else -> {
                Toast.makeText(this@GameActivityLagartoSpock, "Escolha não reconhecida", Toast.LENGTH_SHORT).show()
                R.drawable.vetor_pedra
            }
        }
    }
}