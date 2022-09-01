package com.example.imagegallery.api

import com.example.daggerhiltretrofit.utils.Constants.API_KEY
import com.example.imagegallery.model.ImageItem
import retrofit2.Response
import retrofit2.http.GET

interface ImageService {
    @GET(API_KEY)
    suspend fun getAllImages(): Response<List<ImageItem>>
}