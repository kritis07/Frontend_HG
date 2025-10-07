package com.example.frontend_hg.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object Dashboard : Screen("dashboard")
    data object Calendar : Screen("calendar")
    data object History : Screen("history")
    data object Profile : Screen("profile")
    data object EditProfile : Screen("edit_profile")
    data object LiveMonitoring : Screen("live_monitoring")
    object SmartTips : Screen("smart_tips")
    object Achievements : Screen("achievements")
    object WeeklyReports : Screen("weekly_reports")
    object Notifications : Screen("notifications")
    object EmergencyContacts : Screen("emergency_contacts")
    object Theme : Screen("theme")
    object PersonalDoctor : Screen("personal_doctor")
    object HelpSupport : Screen("help_support")
    object Logout : Screen("logout")
}
