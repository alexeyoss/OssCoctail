package ru.alexeyoss.osscoctails.navigation

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.alexeyoss.features.coctails_list.presentation.coctails.CoctailsListFragment
import ru.alexeyoss.osscoctails.BuildConfig

object Screens {

    fun coctailsList() = FragmentScreen {
        CoctailsListFragment.getNewInstance()
    }

    fun settingsActivity() = ActivityScreen {
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts(
                "package", BuildConfig.APPLICATION_ID,
                null
            )
        ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
}