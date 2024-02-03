package com.example.lovecalculator_is

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lovecalculator_is.databinding.FragmentSecondBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
            .load("https://is5-ssl.mzstatic.com/image/thumb/Purple128/v4/b8/88/27/b88827d7-936f-ffe3-9aae-291a16f46121/AppIcon-1x_U007emarketing-85-220-3.png/1080x800bb.jpg")
            .into(binding.imgSf)

        var result = arguments?.getString("result")
        var fname = arguments?.getString("fname")
        var sname = arguments?.getString("sname")
        var persantage = arguments?.getString("persantage")

        with(binding) {
            tvFirstName.text = fname.toString()
            tvSecondName.text = sname.toString()
            tvPersantage.text = persantage.toString()
            tvResult.text = result.toString()

            btnTryAgain.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
            }
        }
    }
}