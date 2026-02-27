package com.example.geradordesenhas

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class HistoryFragment : Fragment(R.layout.fragment_history) {

    private var rv: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.rv_history)
        rv?.adapter = PasswordAdapter(PasswordStorage.obterHistorico())
    }

    override fun onResume() {
        super.onResume()
        rv?.adapter = PasswordAdapter(PasswordStorage.obterHistorico())
    }
}