package com.example.pedrapapeltesoura.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.R
import com.example.pedrapapeltesoura.databinding.ActivityGameBinding
import com.example.pedrapapeltesoura.model.Jokenpo

class GameActivity1v1: AppCompatActivity() {
    private val agb: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }
    private var mao: String? = null
    private var aplicativo1: String? = null
    private val jokenpo = Jokenpo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(agb.root)
        agb.toolbarIn.toolbar.apply {
            subtitle = this@GameActivity1v1.javaClass.simpleName
            setSupportActionBar(this)
        }

        agb.imgStone.setOnClickListener{
            mao = "pedra"
            resetarDimensaoIcone()
            (it as ImageView).scaleIconSize()
        }

        agb.imgPaper.setOnClickListener{
            mao = "papel"
            resetarDimensaoIcone()
            (it as ImageView).scaleIconSize()
        }

        agb.imgScizor.setOnClickListener{
            mao = "tesoura"
            resetarDimensaoIcone()
            (it as ImageView).scaleIconSize()
        }


        agb.jogarBt.setOnClickListener {
            aplicativo1 = jogadaAplicativo()
            dueloJokenpo(mao, aplicativo1)

            agb.imgAplicativo1.setImageResource(getImageResourceForChoice(aplicativo1))
            agb.aplicativo1Tv.visibility = View.VISIBLE
            agb.imgAplicativo1.visibility = View.VISIBLE
        }

    }

    //verificacao do vencedor
    private fun dueloJokenpo(maoUsuario:String?, maoAplicativo:String?){

        if (maoUsuario == maoAplicativo){
            Toast.makeText(this , "Você EMPATOU!!!", Toast.LENGTH_SHORT).show()
        }else if((
            maoUsuario == "pedra" && maoAplicativo == "tesoura" ||
            maoUsuario == "papel" && maoAplicativo == "pedra" ||
            maoUsuario == "tesoura" && maoAplicativo == "papel"    
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

    //funções apenas para o app indicar a escolha do usuário
    private fun ImageView.scaleIconSize(){
        val largura = resources.getDimensionPixelSize(R.dimen.icon_size) * 1.2f
        val altura = resources.getDimensionPixelSize(R.dimen.icon_size) * 1.2f
        val layoutParams = layoutParams
        layoutParams.width = largura.toInt()
        layoutParams.height = altura.toInt()
        setLayoutParams(layoutParams)
    }
    private fun resetarDimensaoIcone() {
        agb.imgStone.layoutParams.width = resources.getDimensionPixelSize(R.dimen.icon_size)
        agb.imgStone.layoutParams.height = resources.getDimensionPixelSize(R.dimen.icon_size)

        agb.imgPaper.layoutParams.width = resources.getDimensionPixelSize(R.dimen.icon_size)
        agb.imgPaper.layoutParams.height = resources.getDimensionPixelSize(R.dimen.icon_size)

        agb.imgScizor.layoutParams.width = resources.getDimensionPixelSize(R.dimen.icon_size)
        agb.imgScizor.layoutParams.height = resources.getDimensionPixelSize(R.dimen.icon_size)
    }

    private fun getImageResourceForChoice(choice: String?): Int {
        return when (choice) {
            "pedra" -> R.drawable.vetor_pedra
            "papel" -> R.drawable.vetor_papel
            "tesoura" -> R.drawable.vetor_tesoura
            else -> {
                Toast.makeText(this@GameActivity1v1, "Escolha não reconhecida", Toast.LENGTH_SHORT).show()
                R.drawable.vetor_pedra
            }
        }
    }
}