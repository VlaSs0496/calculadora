package xyz.VlaSsAndroi.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  var nume1: Double = 0.0
    private  var nume2: Double = 0.0
    private  var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_1.setOnClickListener{ numPress("1") }
        btn_2.setOnClickListener{ numPress("2") }
        btn_3.setOnClickListener{ numPress("3") }
        btn_4.setOnClickListener{ numPress("4") }
        btn_5.setOnClickListener{ numPress("5") }
        btn_6.setOnClickListener{ numPress("6") }
        btn_7.setOnClickListener{ numPress("7") }
        btn_8.setOnClickListener{ numPress("8") }
        btn_9.setOnClickListener{ numPress("9") }
        btn_0.setOnClickListener{ numPress("0") }
        btn_punt.setOnClickListener{ numPress(".") }

        btn_sum.setOnClickListener{ operacionLogica(SUMA) }
        btn_res.setOnClickListener{ operacionLogica(RESTA) }
        btn_mul.setOnClickListener{ operacionLogica(MULTIPLICACION) }
        btn_div.setOnClickListener{ operacionLogica(DIVISION) }

        btn_Borrar.setOnClickListener{ borrar() }

        btn_igual.setOnClickListener{ resolverOp() }

    }
    private fun numPress(num: String){

        if (txtResultado.text == "0" && num != ".") {
            txtResultado.text = "$num"
        }else{
            txtResultado.text = "${txtResultado.text}$num"
        }

        if (operacion == NO_OP){
            nume1 = txtResultado.text.toString().toDouble()
        }else{
            nume2 = txtResultado.text.toString().toDouble()
        }
    }
    private fun operacionLogica(operacion: Int ){
        this.operacion = operacion
        txtResultado.text = "0"
    }
    companion object{
        const val SUMA = 1
        const val  RESTA = 2
        const val  MULTIPLICACION = 3
        const val  DIVISION = 4
        const val  NO_OP = 0
    }
    private fun borrar(){
        nume1 = 0.0
        nume2 = 0.0
        txtResultado.text = "0"
        operacion = NO_OP
    }
    private fun resolverOp(){

        val result = when(operacion) {
            SUMA -> nume1 + nume2
            RESTA -> nume1 - nume2
            MULTIPLICACION -> nume1 * nume2
            DIVISION -> nume1 / nume2
            else -> 0
        }

        nume1 = result as Double

        txtResultado.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { "%.2f".format(result) }
    }
}