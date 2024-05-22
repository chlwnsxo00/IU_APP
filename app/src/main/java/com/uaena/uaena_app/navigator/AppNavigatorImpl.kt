/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uaena.uaena_app.navigator

import androidx.fragment.app.FragmentActivity
import com.example.uaena_app.R
import com.uaena.uaena_app.ui.favorite.FavoriteFragment
import com.uaena.uaena_app.ui.schedule.MypageFragment
import com.uaena.uaena_app.ui.schedule.ScheduleFragment
import com.uaena.uaena_app.ui.video.VideoFragment

/**
 * Navigator implementation.
 */
class AppNavigatorImpl(private val activity: FragmentActivity) : AppNavigator {

    override fun navigateTo(screen: Screens) {
        val fragment = when (screen) {
            Screens.VIDEOS -> VideoFragment()
            Screens.FAVORITE -> FavoriteFragment()
            Screens.SCHEDULE -> ScheduleFragment()
            Screens.MYPAGE -> MypageFragment()
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }
}
