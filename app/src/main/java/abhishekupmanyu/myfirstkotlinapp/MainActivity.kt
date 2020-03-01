package abhishekupmanyu.myfirstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textViewProgress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textViewProgress.text = p1.toString()

                val translationDistance = (initialTextViewTranslationY + p1*resources.getDimension(R.dimen.text_anim_step)*-1)

                textViewProgress.animate().translationY(translationDistance)

                if (!p2)
                    textViewProgress.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewTranslationY)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        buttonReset.setOnClickListener { v ->
            seekBar.progress = 0
        }
    }
}
