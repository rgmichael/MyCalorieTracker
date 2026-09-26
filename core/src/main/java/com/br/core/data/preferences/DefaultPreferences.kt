package com.br.core.data.preferences

import android.content.SharedPreferences
import com.br.core.domain.model.ActivityLevel
import com.br.core.domain.model.Gender
import com.br.core.domain.model.GoalType
import com.br.core.domain.model.UserInfo
import com.br.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {
    override fun saveGender(gender: Gender) {
        sharedPref.edit()
            .putString(Preferences.Companion.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit()
            .putInt(Preferences.Companion.KEY_AGE, age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit()
            .putFloat(Preferences.Companion.KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit()
            .putInt(Preferences.Companion.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPref.edit()
            .putString(Preferences.Companion.KEY_ACTIVITY_LEVEL, level.name)
            .apply()
    }

    override fun saveGoalType(type: GoalType) {
        sharedPref.edit()
            .putString(Preferences.Companion.KEY_GOAL_TYPE, type.name)
            .apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPref.edit()
            .putFloat(Preferences.Companion.KEY_CARB_RATIO, ratio)
            .apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref.edit()
            .putFloat(Preferences.Companion.KEY_PROTEIN_RATIO, ratio)
            .apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref.edit()
            .putFloat(Preferences.Companion.KEY_FAT_RATIO, ratio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPref.getInt(Preferences.Companion.KEY_AGE, -1)
        val height = sharedPref.getInt(Preferences.Companion.KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(Preferences.Companion.KEY_WEIGHT, -1f)
        val genderString = sharedPref.getString(Preferences.Companion.KEY_GENDER, null)
        val activityLevelString = sharedPref
            .getString(Preferences.Companion.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPref.getString(Preferences.Companion.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPref.getFloat(Preferences.Companion.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPref.getFloat(Preferences.Companion.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPref.getFloat(Preferences.Companion.KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.Companion.fromString(genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.Companion.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.Companion.fromString(goalType ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING, shouldShow)
            .apply()
    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharedPref.getBoolean(
            Preferences.KEY_SHOULD_SHOW_ONBOARDING,
            true
        )

    }
}
