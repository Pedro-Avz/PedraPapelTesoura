package com.example.pedrapapeltesoura.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.R
import com.example.pedrapapeltesoura.databinding.ActivityGameBinding

class GameActivity1v1: AppCompatActivity() {
    private val agb: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }
    private var mao: String? = null
    private var aplicativo1: String? = null

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
        }

    }

    //verificacao do vencedor
    private fun dueloJokenpo(maoUsuario:String?, maoAplicativo:String?){

        if (maoUsuario == maoAplicativo){
            Toast.makeText(this , "      O jogo EMPATOU!!!\n" +
                    "Você escolheu " + maoUsuario + "\nJogador 2 escolheu " + maoAplicativo, Toast.LENGTH_SHORT).show()
        }else if((
            maoUsuario == "pedra" && maoAplicativo == "tesoura" ||
            maoUsuario == "papel" && maoAplicativo == "pedra" ||
            maoUsuario == "tesoura" && maoAplicativo == "papel"    
        )){
            Toast.makeText(this, "         Você VENCEU !!!\n" +
                    "Você escolheu " + maoUsuario + "\nJogador 2 escolheu " + maoAplicativo, Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "         Você PERDEU !!!\n" +
                    "Você escolheu " + maoUsuario + "\nJogador 2 escolheu " + maoAplicativo, Toast.LENGTH_SHORT).show()
        }
    }
    //pegar um jogada random do app
    private fun jogadaAplicativo(): String {
        val maos = arrayOf("pedra", "papel", "tesoura")
        val maoAplicativo = (0 until maos.size).random()
        return maos[maoAplicativo]
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
}