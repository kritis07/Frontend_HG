package com.example.frontend_hg

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.frontend_hg.navigation.Screen
import com.example.frontend_hg.screens.*
import com.example.frontend_hg.ui.components.CenterFabBottomBar
import com.example.frontend_hg.ui.theme.HeartGuardTheme

@Composable
fun HeartGuardApp() {
    HeartGuardTheme {
        val nav = rememberNavController()
        val showBottomBar = remember { mutableStateOf(true) }

        Scaffold(
            bottomBar = {
                if (showBottomBar.value) {
                    CenterFabBottomBar(
                        leftIcon = Icons.Filled.History,
                        rightIcon = Icons.Filled.AccountCircle,
                        onLeft   = { nav.to(Screen.History.route) },
                        onCenter = { nav.to(Screen.Dashboard.route) },
                        onRight  = { nav.to(Screen.Profile.route) }
                    )
                }
            },
            floatingActionButton = {},
            containerColor = MaterialTheme.colorScheme.background
        ) { inner ->
            Box(Modifier.padding(inner)) {
                AppNavHost(nav, showBottomBar)
            }
        }
    }
}

private fun NavHostController.to(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}

@Composable
private fun AppNavHost(
    nav: NavHostController,
    showBottomBar: MutableState<Boolean>
) {
    val backStack by nav.currentBackStackEntryAsState()
    val current = backStack?.destination?.route
    showBottomBar.value = current !in setOf(Screen.Splash.route, Screen.Login.route)

    NavHost(navController = nav, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(onDone = { nav.navigate(Screen.Login.route) }) }
        composable(Screen.Login.route) {
            LoginScreen(
                onSignIn = { nav.navigate(Screen.Dashboard.route) },
                onForgotPassword = { /* open forgot */ }
            )
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                onOpenCalendar = { nav.navigate(Screen.Calendar.route) },
                onOpenLive = { nav.navigate(Screen.LiveMonitoring.route) },
                onOpenSmartTips = { nav.navigate(Screen.SmartTips.route) }
            )
        }
        composable(Screen.Calendar.route) { CalendarScreen(onBack = { nav.popBackStack() }, onOk = { nav.navigate(Screen.History.route) }) }
        composable(Screen.History.route)  { HistoryScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.Profile.route)  {
            ProfileScreen(
                onBack = { nav.popBackStack() },
                onEditProfile = { nav.navigate(Screen.EditProfile.route) },
                onOpen = { route -> nav.navigate(route) }   // ← THIS wires all the tiles
            )
        }
        composable(Screen.EditProfile.route) { EditProfileScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.LiveMonitoring.route) { LiveMonitoringScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.SmartTips.route) { SmartTipsScreen(onBack = { nav.popBackStack() }) }

        // ===== Profile feature pages =====
        composable(Screen.Achievements.route)      { AchievementsScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.WeeklyReports.route)     { WeeklyReportsScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.Notifications.route)     { NotificationsScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.EmergencyContacts.route) { EmergencyContactsScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.Theme.route)             { ThemeScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.PersonalDoctor.route)    { PersonalDoctorScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.HelpSupport.route)       { HelpSupportScreen(onBack = { nav.popBackStack() }) }
        composable(Screen.Logout.route)            { LogoutScreen(onBack = { nav.popBackStack() }) }
    }
}
