package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question> ()

        // Question 1
        val que1 = Question (
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Austria",
            "Australia",
            "Armenia",
            "Argentina",
            4
        )

        questionsList.add(que1)

        // Question 2
        val que2 = Question (
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola",
            "Australia",
            "Algeria",
            "Azerbaijan",
            2
        )

        questionsList.add(que2)

        // Question 3
        val que3 = Question (
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Barbados",
            "Belgium",
            "Belize",
            3
        )

        questionsList.add(que3)

        // Question 4
        val que4 = Question (
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Belarus",
            "Belize",
            "Brunei",
            1
        )

        questionsList.add(que4)

        // Question 5
        val que5 = Question (
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Djibouti",
            "Denmark",
            "Dominican Republic",
            3
        )

        questionsList.add(que5)

        // Question 6
        val que6 = Question (
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Federal Government of Germany",
            "France",
            "Finland",
            "Fiji",
            4
        )

        questionsList.add(que6)

        // Question 7
        val que7 = Question (
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "Ghana",
            1
        )

        questionsList.add(que7)

        // Question 8
        val que8 = Question (
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "Iran",
            "Italy",
            "India",
            4
        )

        questionsList.add(que8)

        // Question 9
        val que9 = Question (
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kenya",
            "Korea",
            "Kuwait",
            "Kosovo",
            3
        )

        questionsList.add(que9)

        // Question 10
        val que10 = Question (
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Norway",
            "Nigeria",
            "New Zealand",
            "Unites States of America",
            3
        )

        questionsList.add(que10)

        return questionsList

    }
}