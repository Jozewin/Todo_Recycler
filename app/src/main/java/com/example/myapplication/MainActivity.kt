package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var todoList = mutableListOf(
            Todo("Test Build Handle with care", false),
            Todo("Just check it bro", false)
        )

        val adapter = TodoAdapter(todoList)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnApply).setOnClickListener {
            val title = findViewById<EditText>(R.id.etNewTodo).text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemChanged(todoList.size-1)
        }

    }
}