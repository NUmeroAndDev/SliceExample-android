package com.numero.slice_example


import android.annotation.SuppressLint
import android.net.Uri
import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.ListBuilder

class TestSliceProvider : SliceProvider() {
    override fun onBindSlice(sliceUri: Uri?): Slice? {
        sliceUri ?: return null
        return when (sliceUri.path) {
            "/temperature" -> createTemperatureSlice(sliceUri)
            else -> null
        }
    }

    override fun onCreateSliceProvider(): Boolean = true

    @SuppressLint("Slices")
    private fun createTemperatureSlice(url: Uri): Slice? {
        val listBuilder = ListBuilder(context, url, ListBuilder.INFINITY)

        // Construct the builder for the row
        val temperatureRow = ListBuilder.RowBuilder(listBuilder).apply {
            setTitle("Test")
        }

        // TODO: add actions to row; in later step

        listBuilder.addRow(temperatureRow)
        return listBuilder.build()
    }

}