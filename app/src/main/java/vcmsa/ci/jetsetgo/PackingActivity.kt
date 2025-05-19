package vcmsa.ci.jetsetgo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class PackingActivity : AppCompatActivity() {
    private lateinit var btnBack:Button
    private lateinit var etClothes:EditText
    private lateinit var etToiletries:EditText
    private lateinit var etShoes:EditText
    private lateinit var etDocuments:EditText
    private lateinit var etTravelDays:EditText
    private lateinit var  btnDisplay:Button
    private lateinit var tvClothes:TextView
    private lateinit var tvToiletries:TextView
    private lateinit var tvShoes:TextView
    private lateinit var tvDocuments:TextView
    private lateinit var btnClear:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_packing)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnBack=findViewById(R.id.btnBack)
        etClothes=findViewById(R.id.etClothes)
        etToiletries=findViewById(R.id.etToiletries)
        etShoes=findViewById(R.id.etShoes)
        etDocuments=findViewById(R.id.etDocuments)
        etTravelDays=findViewById(R.id.etTravelDays)
        btnDisplay=findViewById(R.id.btnDisplay)
        tvClothes=findViewById(R.id.tvClothes)
        tvToiletries=findViewById(R.id.tvToiletries)
        tvShoes=findViewById(R.id.tvShoes)
        tvDocuments=findViewById(R.id.tvDocuments)
        btnClear=findViewById(R.id.btnClear)


        /*
        btnBack.setOnClickListener{performOperation(*takes back to previous screen*)}
        btnDisplay.setOnClickListener{performOperation(*displays the texts in textViews*)}
        btnClear.setOnClickListener{performOperation(*Clears information in the textViews*)}
         */

        btnBack.setOnClickListener {
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        btnDisplay.setOnClickListener {
            val days = etTravelDays.text.toString().trim().toIntOrNull()
            if (days == null || days <= 0) {
                etTravelDays.error = "Please enter a valid number of travel days"
                return@setOnClickListener
            }
            val clothes2=etClothes.text.toString().ifBlank { "items of clothing" }
            val shoes2 = etShoes.text.toString().ifBlank { "pairs of shoes" }
            val toiletries2 =etToiletries.text.toString().ifBlank { "set(s) of toiletries" }
            val documents2 = etDocuments.text.toString().ifBlank { "document" }

            val clothes = days * 3
            val shoes = (days + 1) / 2
            val toiletries = 1
            val documents = 1

            tvClothes.text = "$clothes $clothes2"
            tvShoes.text = "$shoes $shoes2"
            tvToiletries.text = "$toiletries $toiletries2"
            tvDocuments.text = "$documents $documents2"
        }
        btnClear.setOnClickListener {
            etShoes.text.clear()
            etDocuments.text.clear()
            etToiletries.text.clear()
            etTravelDays.text.clear()
            etClothes.text.clear()
            tvShoes.text=""
            tvClothes.text=""
            tvToiletries.text=""
            tvDocuments.text=""

        }



        }


    }
