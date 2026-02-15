package com.profs.queezy.data.utils

import com.profs.queezy.R
import com.profs.queezy.data.model.Quiz
import com.profs.queezy.data.model.User
import javax.inject.Inject

class Storage @Inject constructor() {

    fun getQuizzes() = listOf(
        Quiz("Statistics Math Quiz", "Math", 12,  8, R.drawable.image_quiz_1),
        Quiz("Integers Quiz", "Math", 10, 10,R.drawable.image_quiz_2),
        Quiz("Matrices Quiz", "Math", 6, 3,R.drawable.image_quiz_3),
    )

    fun getFriends() = listOf(
        User("1", "Maren", "Workman", 325, R.drawable.flag_germany, "https://dummyimage.com/400x400/000/fff&text=MW"),
        User("2", "Brandon", "Matrovs", 124, R.drawable.flag_czech_republic, "https://dummyimage.com/400x400/000/fff&text=BM"),
        User("3", "Manuela", "Lipshutz", 437, R.drawable.flag_italy, "https://dummyimage.com/400x400/000/fff&text=ML")
    )

}