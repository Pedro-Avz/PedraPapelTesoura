package com.example.pedrapapeltesoura.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.R
import com.example.pedrapapeltesoura.databinding.ActivityGame1v2Binding
import com.example.pedrapapeltesoura.model.Jokenpo


class GameActivity1v2: AppCompatActivity() {
    private val agb1v2: ActivityGame1v2Binding by lazy {
        ActivityGame1v2Binding.inflate(layoutInflater)
    }
    private var mao: String? = null
    private var aplicativo1: String? = null
    private var aplicativo2: String? = null
    private val jokenpo = Jokenpo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(agb1v2.root)
        agb1v2.toolbarIn.toolbar.apply {
            subtitle = this@GameActivity1v2.javaClass.simpleName
            setSupportActionBar(this)
        }

        agb1v2.imgStone.setOnClickListener{
            mao = "pedra"
            resetarDimensaoIcone()
            (it as ImageView).scaleIconSize()
        }

        agb1v2.imgPaper.setOnClickListener{
            mao = "papel"
            resetarDimensaoIcone()
            (it as ImageView).scaleIconSize()
        }

        agb1v2.imgScizor.setOnClickListener{
            mao = "tesoura"
            resetarDimensaoIcone()
            (it as ImageView).scaleIconSize()
        }


        agb1v2.jogarBt.setOnClickListener {
            aplicativo1 = jogadaAplicativo()
            aplicativo2 = jogadaAplicativo()
            dueloJokenpo(mao, aplicativo1, aplicativo2)

            agb1v2.imgAplicativo1.setImageResource(getImageResourceForChoice(aplicativo1))
            agb1v2.aplicativo1Tv.visibility = View.VISIBLE
            agb1v2.imgAplicativo1.visibility = View.VISIBLE

            agb1v2.imgAplicativo2.setImageResource(getImageResourceForChoice(aplicativo2))
            agb1v2.aplicativo2Tv.visibility = View.VISIBLE
            agb1v2.imgAplicativo2.visibility = View.VISIBLE
        }

    }

    //verificacao do vencedor
    private fun dueloJokenpo(maoUsuario:String?, maoAplicativo1:String?, maoAplicativo2:String?){

        if ((maoUsuario == maoAplicativo1 && maoUsuario == maoAplicativo2 ||
                    maoUsuario == "pedra" && maoAplicativo1 == "pedra" && maoAplicativo2 == "tesoura" ||
                    maoUsuario == "pedra" && maoAplicativo1 == "tesoura" && maoAplicativo2 == "pedra" ||
                    maoUsuario == "tesoura" && maoAplicativo1 == "tesoura" && maoAplicativo2 == "papel" ||
                    maoUsuario == "tesoura" && maoAplicativo1 == "papel" && maoAplicativo2 == "tesoura" ||
                    maoUsuario == "papel"  && maoAplicativo1 == "papel" && maoAplicativo2 == "pedra" ||
                    maoUsuario == "papel"  && maoAplicativo1 == "pedra" && maoAplicativo2 == "papel" ||
                    maoUsuario != maoAplicativo1 && maoUsuario != maoAplicativo2 && maoAplicativo1 != maoAplicativo2
                ))
        {
            Toast.makeText(this , "Você EMPATOU!!!", Toast.LENGTH_SHORT).show()
        }else if(( maoUsuario == "pedra" && maoAplicativo1 == "tesoura" && maoAplicativo2 == "tesoura" ||
                    maoUsuario == "papel" && maoAplicativo1 == "pedra" && maoAplicativo2 == "pedra" ||
                    maoUsuario == "tesoura" && maoAplicativo1 == "papel" && maoAplicativo2 == "papel"
                    ))
        {
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
        agb1v2.imgStone.layoutParams.width = resources.getDimensionPixelSize(R.dimen.icon_size)
        agb1v2.imgStone.layoutParams.height = resources.getDimensionPixelSize(R.dimen.icon_size)

        agb1v2.imgPaper.layoutParams.width = resources.getDimensionPixelSize(R.dimen.icon_size)
        agb1v2.imgPaper.layoutParams.height = resources.getDimensionPixelSize(R.dimen.icon_size)

        agb1v2.imgScizor.layoutParams.width = resources.getDimensionPixelSize(R.dimen.icon_size)
        agb1v2.imgScizor.layoutParams.height = resources.getDimensionPixelSize(R.dimen.icon_size)
    }

    private fun getImageResourceForChoice(choice: String?): Int {
        return when (choice) {
            "pedra" -> R.drawable.vetor_pedra
            "papel" -> R.drawable.vetor_papel
            "tesoura" -> R.drawable.vetor_tesoura
            else -> {
                Toast.makeText(this@GameActivity1v2, "Escolha não reconhecida", Toast.LENGTH_SHORT).show()
                R.drawable.vetor_pedra
            }
        }
    }
}