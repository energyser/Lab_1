package com.example.lab1;


import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab1.Animals.Animal
import com.example.lab1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val contentView = binding.root
        setContentView(contentView)

        binding.detailsButton1.setOnClickListener {
            onClickHandler(createAnimal("chameleon", "fulld_chameleon", "chameleon"))
        }

        binding.detailsButton2.setOnClickListener {
            onClickHandler(createAnimal("owl", "fulld_owl", "owl"))
        }

        binding.detailsButton3.setOnClickListener {
            onClickHandler(createAnimal("octopus", "fulld_octopus", "octopus"))
        }
    }

    private fun onClickHandler(animal: Animal){
        val intent = Intent(this, Description::class.java)

        intent.putExtra("animal", animal)
        startActivity(intent)
    }

    @SuppressLint("DiscouragedApi")
    private fun createAnimal(name: String, description: String, image: String): Animal{
        val res: Resources = resources

        val resNameId = resources.getIdentifier(name, "string", packageName)
        val name: String = res.getString(resNameId)

        val resDescriptionId = resources.getIdentifier(description, "string", packageName)
        val description: String = res.getString(resDescriptionId)

        return Animal(name, description, image)
    }
}
