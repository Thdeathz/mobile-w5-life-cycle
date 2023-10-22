package com.example.assignment

import android.R
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignment.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var formatDate = SimpleDateFormat("dd/MM/yyyy", Locale.UK)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val firstName = binding.edtFirstName.text
        val lastName = binding.edtLastName.text
        val birth = binding.edtBirth.text
        val address = binding.edtAddress.text
        val email = binding.edtEmail.text

        binding.buttonSelect.setOnClickListener {
            showDialogSelectDate()
        }

        binding.buttonRegister.setOnClickListener {
            if(firstName.isEmpty() || lastName.isEmpty() || birth.isEmpty() || address.isEmpty() || email.isEmpty() || !binding.cbAgree.isChecked){
                Toast.makeText(this@MainActivity, "Bạn chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDialogSelectDate() {
        val getDate = Calendar.getInstance()
        val datePicker = DatePickerDialog(this, R.style.Theme_Holo_Light_Dialog_MinWidth,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                val selectDate: Calendar = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, year)
                selectDate.set(Calendar.MONTH, month)
                selectDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                binding.edtBirth.setText(formatDate.format(selectDate.time))

            }, getDate.get(Calendar.YEAR), getDate.get((Calendar.MONTH)), getDate.get(Calendar.DAY_OF_MONTH))

        datePicker.show()
    }
}