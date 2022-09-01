package com.example.imagegallery.repository

import com.example.imagegallery.api.ImageService
import javax.inject.Inject

class ImageRepository
@Inject
constructor(private val api: ImageService) {

    suspend fun getAllImages() = api.getAllImages()

}