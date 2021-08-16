package com.example.customdrawables

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.palette.graphics.Palette
import com.example.customdrawables.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {


    private lateinit var bind: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentThirdBinding.bind(view)
        val bitmap = bind.img.drawable.toBitmap()
        createPaletteAsync(bitmap)

    }

    private fun createPaletteAsync(bitmap: Bitmap) {
        Palette.from(bitmap).generate { palette ->
            bind.container.setBackgroundColor(palette?.vibrantSwatch?.rgb!!)
        }
    }


}