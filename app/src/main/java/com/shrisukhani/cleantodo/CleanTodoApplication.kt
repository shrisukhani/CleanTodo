package com.shrisukhani.cleantodo

import android.app.Application
import com.facebook.soloader.SoLoader

class CleanTodoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
    }
}