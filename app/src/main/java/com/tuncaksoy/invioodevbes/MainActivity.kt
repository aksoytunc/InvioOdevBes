package com.tuncaksoy.invioodevbes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tuncaksoy.invioodevbes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var textViewTotalText: String
    lateinit var textViewLastText: String
    val gatherList = ArrayList<Int?>()
    var gather = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text =
                "0"
            else binding.textViewTotal.text = textViewTotalText + "0"
        }

        binding.button1.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text =
                "1"
            else binding.textViewTotal.text = textViewTotalText + "1"
        }

        binding.button2.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text = "2"
            else binding.textViewTotal.text = textViewTotalText + "2"
        }

        binding.button3.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text = "3"
            else binding.textViewTotal.text = textViewTotalText + "3"
        }

        binding.button4.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text = "4"
            else binding.textViewTotal.text = textViewTotalText + "4"
        }

        binding.button5.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text = "5"
            else binding.textViewTotal.text = textViewTotalText + "5"
        }

        binding.button6.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text = "6"
            else binding.textViewTotal.text = textViewTotalText + "6"
        }

        binding.button7.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text = "7"
            else binding.textViewTotal.text = textViewTotalText + "7"
        }

        binding.button8.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text = "8"
            else binding.textViewTotal.text = textViewTotalText + "8"
        }

        binding.button9.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            if (textViewTotalText == "0" || textViewTotalText.toIntOrNull() == null) binding.textViewTotal.text = "9"
            else binding.textViewTotal.text = textViewTotalText + "9"
        }

        binding.buttonAdd.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            textViewLastText = binding.textViewLast.text.toString()
            if (!gatherList.isEmpty()) {
                if (textViewTotalText.toIntOrNull() == null) {
                    binding.textViewLast.text = textViewTotalText + "+"
                    binding.textViewTotal.text = "0"
                    gatherList.clear()
                    gatherList.add(gather)
                } else if (textViewTotalText != "0") {
                    gatherList.add(textViewTotalText.toInt())
                    binding.textViewLast.text = textViewLastText + textViewTotalText + "+"
                    binding.textViewTotal.text = "0"

                }
            } else if (textViewTotalText != "0") {
                gatherList.add(textViewTotalText.toInt())
                binding.textViewLast.text = textViewLastText + textViewTotalText + "+"
                binding.textViewTotal.text = "0"
            }
        }

        binding.buttonDelete.setOnClickListener {
            var textViewTotalTextDeleted: String
            textViewTotalText = binding.textViewTotal.text.toString()

            if (textViewTotalText.toIntOrNull() == null) {
                textViewTotalTextDeleted = textViewTotalText.drop(1)
                binding.textViewTotal.text = textViewTotalTextDeleted
            } else {
                if (textViewTotalText != "0") {
                    textViewTotalTextDeleted = textViewTotalText.dropLast(1)
                    binding.textViewTotal.text = textViewTotalTextDeleted
                    if (textViewTotalText.length == 1) {
                        binding.textViewTotal.text = "0"
                    }
                }
            }
        }

        binding.buttonAllDelete.setOnClickListener {
            binding.textViewLast.text = ""
            binding.textViewTotal.text = "0"
            gatherList.clear()
            gather = 0
        }

        binding.buttonEqual.setOnClickListener {
            textViewTotalText = binding.textViewTotal.text.toString()
            textViewLastText = binding.textViewLast.text.toString()
            if (!gatherList.isEmpty()) {
                gatherList.add(textViewTotalText.toIntOrNull())
                if (gatherList[gatherList.size - 1] != null) {
                    if (textViewTotalText != "0")
                        binding.textViewLast.text = textViewLastText + textViewTotalText + "+"
                    gather = 0
                    for (i in 0..(gatherList.size - 1)) {
                        gather += gatherList[i]!!
                    }
                    gatherList.clear()
                    gatherList.add(gather)
                    binding.textViewTotal.text = "=" + gatherList[0]
                }
            }
        }
    }
}