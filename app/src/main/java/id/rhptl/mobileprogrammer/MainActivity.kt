package id.rhptl.mobileprogrammer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import  android.view.View
import android.widget.Button
import  android.widget.EditText
import  android.widget.TextView
import  androidx.lifecycle.createSavedStateHandle


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inputPanjang: EditText
    private lateinit var inputLebar: EditText
    private lateinit var inputTinggi: EditText
    private lateinit var result: TextView
    private lateinit var btnHitung: Button

    companion object{
        private const val  STATE_RESULT="state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputPanjang = findViewById(R.id.inputPanjang)
        inputLebar = findViewById(R.id.InputLebar)
        inputTinggi = findViewById(R.id.InputTinggi)
        btnHitung = findViewById(R.id.btnHitung)

        btnHitung.setOnClickListener(this)

        //menampilkan value yang ada di budle
        if (savedInstanceState != null){
            result.text = savedInstanceState.getString(STATE_RESULT)
        }

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnHitung){
            var  tinggi = inputTinggi.text.toString().trim()
            var  lebar = inputLebar.text.toString().trim()
            var panjang  = inputPanjang.text.toString().trim()
            var  volume = panjang.toDouble() * tinggi.toDouble() * lebar.toDouble()
            result.text = volume.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, result.text.toString())
    }
}