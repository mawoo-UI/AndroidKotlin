package cokr.oneweeks.imagsslider

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    private lateinit var addPhotoButton: Button
    private lateinit var startPotoButton: Button
    private lateinit var imageViewList: List<ImageView>
    private val imageList: MutableList<Uri> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addPhotoButton = findViewById(R.id.imageView1)
        startPotoButton = findViewById(R.id.imageView2)
        imageViewList = listOf(
            findViewById(R.id.imageView3),
            findViewById(R.id.imageView2),
            findViewById(R.id.imageView3)
        )

        addPhotoButton.setOnClickListener {
            navigatePhotos()
        }
        startPotoButton.setOnClickListener {
            val intent = Intent(this, PhotoFrameActivity::class.java)
            imageList.forEachIndexed {index, uri ->
                intent.putExtra("photo$index", uri.toString())
            }
            intent.putExtra("photoListSize", imageList.size)
            startActivity(intent)
        }
    }

    private fun navigatePhotos() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent,500)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        when (requestCode) {
            500 -> {
                val selectedImageUri : Uri? = data?.data
                if (selectedImageUri != null) {
                    if (imageList.size == 3) {
                        Toast.makeText(this, "3장의 사진이 선택 완료되었습니다.",
                            Toast.LENGTH_LONG).show()
                        return
                    }
                    imageList.add(selectedImageUri)
                    imageViewList[imageList.size - 1].setImageURI(selectedImageUri)
                }
            }
        }
    }
}