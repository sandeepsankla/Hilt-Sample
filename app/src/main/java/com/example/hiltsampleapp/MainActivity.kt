package com.example.hiltsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint // for making a class to get ready for dependency injected
class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName
    //field injection
    @Inject
    lateinit var doSomeThing: DoSomeThing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(TAG, doSomeThing.doSomeThing())
        Log.v(TAG, doSomeThing.doSomeOtherthing())
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

