package com.example.myquizapplication;

public class QuestionAnswer {

    public static String question[] = {
            "What is an APK in the context of Android applications?",
            "What is Android's primary programming language?",
            "What is Android's default database system?",
            "What is used to describe the layout and behavior of UI elements in Android?"
    };

    public static String choices[][] = {
            {"Package", "Bundle", "Archive","Kit"},
            {"Java", "C++","Python","Kotlin"},
            {"SQLite","MySQL", "MongoDB" , "PostgreSQL"},
            {"XML", "JSON" ,"YAML","HTML"}

    };

    public static String correctAnswers[]= {
            "Package",
            "Java",
            "SQLite",
            "XML"
    };

}
