package com.example.geradordesenhas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inicializa storage
        PasswordStorage.inicializar(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        // Conecta bottom nav com navController
        val navHost = supportFragmentManager.findFragmentById(R.id.fragment_container) as? NavHostFragment
        val navController = navHost?.navController
        val bottom = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        if (navController != null) bottom.setupWithNavController(navController)
    }
}

//📋 Status do Projeto
//O que já está pronto:
//
//Navegação: Abas Gerador/Histórico (Bottom Nav + NavHost).
//
//Layouts: Telas completas e design do item da lista.
//
//Lógica: Geração de senha aleatória e salvamento em memória (Singleton).
//
//O que falta ajustar (Código):
//
//Botão Copiar: Clique no CardView para salvar no clipboard.
//
//Validação: Aviso caso todos os Switches estejam desligados.
//
//Ícones: Criar os Vector Assets (ícones) para a barra inferior.
//
//O que falta para a Entrega:
//
//GitHub: Subir o código.
//
//README: Texto explicativo.
//
//Vídeo: Gravar a demonstração.
//
//Quer o código de validação dos switches ou o texto do README?