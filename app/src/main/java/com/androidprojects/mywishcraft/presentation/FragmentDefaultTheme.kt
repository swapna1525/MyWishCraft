package com.androidprojects.mywishcraft.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.androidprojects.mywishcraft.databinding.LayoutDefaultThemeBinding

class FragmentDefaultTheme : Fragment() {

    private var _binding: LayoutDefaultThemeBinding? = null
    private val binding get() = _binding!!

    // Get arguments using Safe Args
    //  private val args: DefaultThemeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = LayoutDefaultThemeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //  val festivalName = args.festivalName  // Passed from previous fragment

        // Set the title and message dynamically
        // binding.tvFestival.text = "Happy $festivalName"

        val wishMessage =
            "To my dearest KANNA brother, you're not just my protector but also my best friend, my cheerleader, and my forever strength. No matter how far life takes us, my love for you will always wrap around your wrist like this Rakhi — strong, eternal, and full of blessings. With all my heart, I love you Kannaa. Happy Raksha Bandhan!"


        binding.tvWishMessage.text = wishMessage

        // Share wish via intent
        binding.btnShare.setOnClickListener {
            shareText("Happy Raksha Bandhan")
        }

        // Share wish via intent
        binding.btnDownload.setOnClickListener {
            shareText(wishMessage)
        }
    }

    private fun shareText(text: String) {
        try {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Unable to share message", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
