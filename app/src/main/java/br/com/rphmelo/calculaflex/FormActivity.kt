package br.com.rphmelo.calculaflex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.rphmelo.calculaflex.extensions.getDouble
import br.com.rphmelo.calculaflex.watchers.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        etGasPrice.addTextChangedListener(DecimalTextWatcher(etGasPrice))
        etEthanolPrice.addTextChangedListener(DecimalTextWatcher(etEthanolPrice))
        etGasAverage.addTextChangedListener(DecimalTextWatcher(etGasAverage))
        etEthanolAverage.addTextChangedListener(DecimalTextWatcher(etEthanolAverage))

        btCalculate.setOnClickListener {
            val nextScreen = Intent(this, ResultActivity::class.java)
            nextScreen.putExtra("GAS_PRICE", etGasPrice.getDouble())
            nextScreen.putExtra("ETHANOL_PRICE", etEthanolPrice.getDouble())
            nextScreen.putExtra("GAS_AVERAGE", etGasAverage.getDouble())
            nextScreen.putExtra("ETHANOL_AVERAGE", etEthanolAverage.getDouble())
            startActivity(nextScreen)
        }
    }
}
