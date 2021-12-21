package com.mirrorfiction.note.feature

import com.mirrorfiction.note.di.AppModule
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.testing.UninstallModules

/**
 * Create by Neil
 * on 2021/12/21.
 */

@HiltAndroidApp
@UninstallModules(AppModule::class)
class NoteEndToEndTest {


}