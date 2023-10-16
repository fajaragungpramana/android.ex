package com.github.fajaragungpramana.ex.ui.main

import com.github.fajaragungpramana.ex.R

data class BottomNavigationItem(
    val label: Int,
    val icon: Int,
    val route: BottomNavigationRoute
) {

    companion object {

        fun data(): List<BottomNavigationItem> = listOf(
            BottomNavigationItem(
                label = R.string.home,
                icon = R.drawable.ic_home_unselected,
                route = BottomNavigationRoute.HomeView
            ),
            BottomNavigationItem(
                label = R.string.statistic,
                icon = R.drawable.ic_statistic_unselected,
                route = BottomNavigationRoute.StatisticView
            ),
            BottomNavigationItem(
                label = R.string.profile,
                icon = R.drawable.ic_profile_unselected,
                route = BottomNavigationRoute.ProfileView
            )
        )

    }

}