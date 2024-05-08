package com.example.pedrapapeltesoura.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        amb.toolbarIn.toolbar.apply {
            subtitle = this@MainActivity.javaClass.simpleName
            setSupportActionBar(this)

        }
        amb.botao1v1.setOnClickListener{
            val intent = Intent(this@MainActivity, GameActivity1v1::class.java)
            startActivity(intent)
        }
        amb.botao1v1v1.setOnClickListener{
            val intent = Intent(this@MainActivity, GameActivity1v2::class.java)
            startActivity(intent)
        }

        amb.botaoLagartoSpock.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivityLagartoSpock::class.java)
            startActivity(intent)
        }
    }

}