package com.maxonpatison.chtotoschemto

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.renderscript.ScriptGroup.Binding
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.maxonpatison.chtotoschemto.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val naborCB = arrayListOf(false,false,false)
        var dostavka = 0
        var master = false
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        (binding.NaborRB[0] as RadioButton).isChecked = true


        binding.Button.setOnClickListener{
            (binding.NaborCB1[0] as CheckBox).isChecked
            (binding.NaborCB1[1] as CheckBox).isChecked
            (binding.NaborCB1[2] as CheckBox).isChecked

            dostavka = if ((binding.NaborRB[0] as RadioButton).isChecked){0} else if ((binding.NaborRB[1] as RadioButton).isChecked){1} else{2}

            master = binding.Switch.isChecked

            if(dostavka == 0){
                Snackbar.make(binding.root, "Можете приезжать и забирать свой хлам", Snackbar.LENGTH_SHORT).show()
            }
            else if(dostavka == 1){
                Snackbar.make(binding.root, "Курьер с вашим хламом уже едет", Snackbar.LENGTH_SHORT).show()
            }
            else{
                Snackbar.make(binding.root, "Дрон с вашим хламом уже летит", Snackbar.LENGTH_SHORT).show()
            }
        }

    }
}
