package ru.accessibility.liveregion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.ACCESSIBILITY_LIVE_REGION_POLITE
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * android:accessibilityLiveRegion - атрибут для оповещения пользователя при изменении значения элемента.
 *
 * У него можно указать 3 значения:
 * none — ничего не обновлять, значение по умолчанию.
 * polite — если значение обновилось, но TalkBack ещё озвучивает что-то в интерфейсе,
 *      новое значение зачитается после того, как TalkBack закончит говорить.
 * assertive — противоположное значению polite. При обновлении значения TalkBack перестанет
 *      зачитывать любую озвучку и сразу начнет зачитывать новое значение. Используется крайне редко.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var label: TextView
    private lateinit var button: Button

    private var currentFood = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.cat_image)
        label = findViewById(R.id.meal_counter)
        button = findViewById(R.id.add_meal_button)

        button.setOnClickListener { addMeal() }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun addMeal() {

//        if (currentFood == 0) {
//            label.accessibilityLiveRegion = ACCESSIBILITY_LIVE_REGION_POLITE
//        }

        if (currentFood < MAX_COUNT) {
            currentFood += PORTION
            label.text = getString(R.string.meal_count, currentFood)
        } else {
            image.setImageDrawable(getDrawable(R.drawable.positive_cat))
            label.text = getString(R.string.max_meal)
            button.isEnabled = false
        }
    }

    companion object {
        private const val MAX_COUNT = 50
        private const val PORTION = 10
    }
}
