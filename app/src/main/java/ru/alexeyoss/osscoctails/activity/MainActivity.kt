package ru.alexeyoss.osscoctails.activity

import android.Manifest.permission.READ_MEDIA_IMAGES
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.alexeyoss.core_ui.presentation.listeners.BackButtonListener
import ru.alexeyoss.osscoctails.R
import ru.alexeyoss.osscoctails.appComponent
import ru.alexeyoss.osscoctails.databinding.ActivityMainBinding
import ru.alexeyoss.osscoctails.navigation.Screens
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val readMediaPermissionLauncher by lazy {
        registerForActivityResult(ActivityResultContracts.RequestPermission(), ::onReadMediaPermissionResult)
    }


    private val navigator = AppNavigator(
        activity = this@MainActivity, containerId = R.id.navHostContainer, fragmentManager = supportFragmentManager
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this@MainActivity)

        setContentView(binding.root)
        setSupportActionBar(binding.customToolbar)

        navigator.applyCommands(arrayOf(Forward(Screens.coctailsList())))

        // TODO extract logic to photo picker step
        if (!checkPermissionsStatus(arrayOf(READ_MEDIA_IMAGES))) {
            readMediaPermissionLauncher.launch(READ_MEDIA_IMAGES)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun onReadMediaPermissionResult(result: Boolean) {
        if (result) {
            Unit
        } else {
            if (shouldShowRequestPermissionRationale(this@MainActivity, READ_MEDIA_IMAGES)) {
                readMediaPermissionLauncher.launch(READ_MEDIA_IMAGES)
            } else {
                // TODO AlertDialog
            }
        }
    }

    private fun checkPermissionsStatus(permissions: Array<String>): Boolean {
        return permissions.any { permission ->
            ContextCompat.checkSelfPermission(
                this@MainActivity, permission
            ) == PermissionChecker.PERMISSION_GRANTED
        }
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.navHostContainer)
        if (fragment != null && fragment is BackButtonListener && (fragment as BackButtonListener).onBackPressed()) {
            return
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}