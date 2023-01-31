package dk.easj.anbo.autocompletetextviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import dk.easj.anbo.autocompletetextviewexample.databinding.ActivityMainBinding

/**
 * As a class AutoCompleteTextView extends EditText (despite the name TextView)
 * AutoCompleteTextView combines EditText + dropdown list:
 *     you can choose from the list of write anything you want
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fishNames = arrayOf(
        "bream", "carp", "grayling", "perch", "pike", "pike-perch", "roach",
        "tench", "eel", "sturgeon", "salmon", "trout", "smelt", "rainbow trout", "whitefish",
        "picked dogfish", "shark", "skate", "smooth hound", "anchovy", "herring", "pilchard",
        "sardine", "sardinella", "sprat", "blue ling", "blue whitling", "cod", "greater forkbeard",
        "haddock", "hake", "ling", "pollack", "poor cod",
        "pout", "saithe", "tush", "whiting", "atherine", "bogue", "mullet", "picaral", "scad",
        "sea bream", "surmullet", "chub mackerel", "garfish",
        "mackerel", "swordfish", "albacore tuna", "bonito tuna", "skipjack tuna", "tuna"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        fishNames.sort()
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, fishNames)

        binding.fishAutoCompleteTextView.setAdapter(adapter)

        binding.showButton.setOnClickListener {
            val fish = binding.fishAutoCompleteTextView.text.trim()
            if (fish.isEmpty()) {
                binding.fishAutoCompleteTextView.error = "No fish!"
                return@setOnClickListener
            }
            binding.messageTextView.text = "You caught a $fish"
        }
    }
}