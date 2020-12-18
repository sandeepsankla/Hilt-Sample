package com.example.hiltsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint // for makking a class to get ready for dependency injected
class MainActivity : AppCompatActivity() {
    //field injection
    @Inject
    lateinit var doSomeThing: DoSomeThing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print(doSomeThing.doSomeThing())
        print(doSomeThing.doSomeOtherthing())
    }
}

class DoSomeThing @Inject constructor(private val doSomeOtherThing:DoSomeOtherThing) {

    fun doSomeThing():String{
        return "Look I did something!"
    }

    fun doSomeOtherthing():String{
        return doSomeOtherThing.doSomeOtherThing()
    }
}

class DoSomeOtherThing @Inject constructor(){
    fun  doSomeOtherThing():String{
        return "Look I did some Other thing"
    }
}