package aviles.itzel.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val bundle = intent.extras

        if(bundle != null){
            iv_movie_img.setImageResource(bundle.getInt("header"))
            tv_movie_title.setText(bundle.getInt("title"))
            tv_movie_desc.setText(bundle.getInt("description"))
        }
    }
}