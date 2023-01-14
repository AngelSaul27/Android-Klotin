package android.example.com.aboutme

import android.content.Context
import android.example.com.aboutme.databinding.ActivityMainBinding
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Angel Saul Pascual Camacho")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.myName = myName

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            addNickname()
        }

        binding.nicknameText.setOnClickListener{
            updateNickname()
        }
    }

    private fun updateNickname(){
        binding.apply {
            binding.nicknameEdit.visibility = View.VISIBLE
            binding.doneButton.visibility = View.VISIBLE
            binding.nicknameText.visibility = View.GONE
            binding.nicknameEdit.requestFocus()
        }
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.showSoftInput(binding.nicknameEdit,0)
    }

    private fun addNickname(){
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            //binding.nicknameText.text = binding.nicknameEdit.text.toString()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE //button hidden
            binding.nicknameText.visibility = View.VISIBLE //we add the visible property
        }
        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)
    }
}