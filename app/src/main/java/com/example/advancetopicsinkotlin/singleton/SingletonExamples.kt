package com.example.advancetopicsinkotlin.singleton


class SingletonExamples {

    @Volatile //Volatile keyword is used to modify the value of a variable by different threads.
    private var INSTANCE: SingletonExamples? = null

    //this is not thread safe
    fun getInstance(): SingletonExamples? {
        if (INSTANCE == null) {
            INSTANCE = SingletonExamples()
        }

        return INSTANCE
    }


    //this is thread safe
    @Synchronized // makes this function thread safe
    fun getThreadSafeInstance(): SingletonExamples? {
        if (INSTANCE == null) {
            INSTANCE = SingletonExamples()
        }
        return INSTANCE
    }

    //with more optimisation using locker
    fun getThreadSafeInstanceWithOptimisedWay(): SingletonExamples? {
        var lockerRef = INSTANCE
        if (lockerRef == null) {
            synchronized(this) {
                lockerRef = INSTANCE
                if (lockerRef == null) {
                    INSTANCE = SingletonExamples()
                    lockerRef = INSTANCE
                }
            }

        }
        return INSTANCE
    }
}