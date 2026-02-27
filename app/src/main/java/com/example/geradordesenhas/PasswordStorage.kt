package com.example.geradordesenhas

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray

object PasswordStorage {
    // Esta lista vai guardar as senhas na memória enquanto o app estiver aberto
    private val historico = ArrayList<String>()

    private const val PREFS_NAME = "password_prefs"
    private const val KEY_HISTORY = "history"
    private var prefs: SharedPreferences? = null

    // Deve ser chamado uma vez (ex: MainActivity.onCreate)
    fun inicializar(context: Context) {
        if (prefs != null) return
        prefs = context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs?.getString(KEY_HISTORY, null)
        if (!json.isNullOrEmpty()) {
            try {
                val arr = JSONArray(json)
                for (i in 0 until arr.length()) historico.add(arr.getString(i))
            } catch (_: Exception) { /* ignore */ }
        }
    }

    fun adicionarSenha(senha: String) {
        // Adiciona no índice 0 para que a última gerada apareça no topo da lista
        historico.add(0, senha)
        salvar()
    }

    fun obterHistorico(): List<String> {
        return ArrayList(historico)
    }

    private fun salvar() {
        try {
            val arr = JSONArray()
            for (s in historico) arr.put(s)
            prefs?.edit()?.putString(KEY_HISTORY, arr.toString())?.apply()
        } catch (_: Exception) { /* ignore */ }
    }
}