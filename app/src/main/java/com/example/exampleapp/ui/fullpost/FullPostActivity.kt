package com.example.exampleapp.ui.fullpost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleapp.databinding.ActivityFullPostBinding

class FullPostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*val client = HttpClient {
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
            defaultRequest {
                host = PostsListActivity.BASE_URL
                url {
                    protocol = URLProtocol.HTTPS
                }
            }
        }
        val postId = intent.getIntExtra(POST_ID_ARG, -1)
        if(postId != -1){
            lifecycleScope.launchWhenCreated {
                try{
                    val post:Post = client.get("posts/$postId")
                    val user: User = client.get("users/${post.userId}")
                    binding.tvTitle.text = post.title.replaceFirstChar { it.uppercaseChar() }
                    binding.tvPostBody.text = post.body.replaceFirstChar { it.uppercaseChar() }
                    binding.tvAuthor.text = user.name
                    binding.tvEmail.text = user.email
                    binding.layoutContent.isVisible = true
                    binding.progressBar.isVisible = false
                } catch(e:Throwable){
                    Toast.makeText(
                        this@FullPostActivity,
                        R.string.loading_error_happened,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        } else {
            Toast.makeText(
                this@FullPostActivity,
                R.string.loading_error_happened,
                Toast.LENGTH_LONG
            ).show()
        }*/
    }

    companion object{
        const val POST_ID_ARG = "postId"
    }
}