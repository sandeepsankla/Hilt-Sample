package com.example.hiltsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hiltsampleapp.data.AppDataBase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint // for making a class to get ready for dependency injected
class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName
    //field injection
    @Inject
    lateinit var doSomeThing: DoSomeThing

    @Inject
    lateinit var dataBase: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(TAG, doSomeThing.doSomeThing())
        Log.v(TAG, doSomeThing.doSomeOtherthing())
    }
}
//scope of injected object
@Singleton
class DoSomeThing @Inject constructor(private val doSomeOtherThing:DoSomeOtherThing) {

    fun doSomeThing():String{
        return "Look I did something!"
    }

    fun doSomeOtherthing():String{
        return doSomeOtherThing.doSomeOtherThing()
    }
}

//scope of injected object
@ActivityScoped
class DoSomeOtherThing @Inject constructor(){
    fun  doSomeOtherThing():String{
        return "Look I did some Other thing"
    }
}

