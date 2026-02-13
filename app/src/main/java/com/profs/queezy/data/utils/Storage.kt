package com.profs.queezy.data.utils

import com.profs.queezy.R
import com.profs.queezy.data.model.Quiz
import javax.inject.Inject

class Storage @Inject constructor() {

    fun getQuizzes() = listOf(
        Quiz("Statistics Math Quiz", "Math", 12,  8, R.drawable.quiz_1),
        Quiz("Integers Quiz", "Math", 10, 10,R.drawable.quiz_2),
        Quiz("Matrices Quiz", "Math", 6, 3,R.drawable.quiz_3),
    )

}