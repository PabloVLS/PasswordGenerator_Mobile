package com.example.geradordesenhas

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.switchmaterial.SwitchMaterial

class GeneratorFragment : Fragment(R.layout.fragment_generator) {

    // Variáveis para os componentes
    private lateinit var tvSenha: TextView
    private lateinit var tvTamanho: TextView
    private lateinit var sbTamanho: SeekBar
    private lateinit var swMaius: SwitchMaterial
    private lateinit var swNum: SwitchMaterial
    private lateinit var swSimbol: SwitchMaterial
    private lateinit var btnGerar: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar componentes
        tvSenha = view.findViewById(R.id.tv_password_display)
        tvTamanho = view.findViewById(R.id.tv_length_label)
        sbTamanho = view.findViewById(R.id.sb_length)
        swMaius = view.findViewById(R.id.sw_uppercase)
        swNum = view.findViewById(R.id.sw_numbers)
        swSimbol = view.findViewById(R.id.sw_symbols)
        btnGerar = view.findViewById(R.id.btn_generate)

        // Inicializa o label
        tvTamanho.text = getString(R.string.length_label, sbTamanho.progress)

        // Atualizar o label do comprimento quando mexer no SeekBar
        sbTamanho.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvTamanho.text = getString(R.string.length_label, progress)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        // Copiar senha ao clicar
        tvSenha.setOnClickListener { copiar() }

        // Regenerar senha ao pressionar longo
        tvSenha.setOnLongClickListener {
            regenerar(); true
        }

        // Ação do Botão
        btnGerar.setOnClickListener { gerar() }
    }

    private fun copiar() {
        val txt = tvSenha.text.toString()
        if (txt.isNotEmpty() && txt != getString(R.string.click_to_generate)) {
            val cb = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            cb.setPrimaryClip(ClipData.newPlainText("senha", txt))
            Toast.makeText(requireContext(), getString(R.string.copied_to_clip), Toast.LENGTH_SHORT).show()
        }
    }

    private fun regenerar() {
        val tam = sbTamanho.progress
        if (tam < 1) { Toast.makeText(requireContext(), getString(R.string.min_length), Toast.LENGTH_SHORT).show(); return }
        if (!swMaius.isChecked && !swNum.isChecked && !swSimbol.isChecked) { Toast.makeText(requireContext(), getString(R.string.select_one_option), Toast.LENGTH_SHORT).show(); return }
        val s = gerarSenha(tam)
        tvSenha.text = s
        if (s.isNotEmpty()) PasswordStorage.adicionarSenha(s)
        Toast.makeText(requireContext(), getString(R.string.regenerated), Toast.LENGTH_SHORT).show()
    }

    private fun gerar() {
        val tam = sbTamanho.progress
        if (tam < 1) { Toast.makeText(requireContext(), getString(R.string.min_length), Toast.LENGTH_SHORT).show(); return }
        if (!swMaius.isChecked && !swNum.isChecked && !swSimbol.isChecked) { Toast.makeText(requireContext(), getString(R.string.select_one_option), Toast.LENGTH_SHORT).show(); return }
        val s = gerarSenha(tam)
        tvSenha.text = s
        if (s.isNotEmpty()) PasswordStorage.adicionarSenha(s)
    }

    private fun gerarSenha(tam: Int): String {
        val min = "abcdefghijklmnopqrstuvwxyz"
        val mai = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val num = "0123456789"
        val sim = "!@#$%^&*()-_=+"
        var pool = min
        if (swMaius.isChecked) pool += mai
        if (swNum.isChecked) pool += num
        if (swSimbol.isChecked) pool += sim
        return (1..tam).map { pool.random() }.joinToString("")
    }
}
