package com.example.todoapp.UI.MainApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todoapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragment : Fragment() {

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        fabAddTask = view.findViewById(R.id.fabAddTask)

        fabAddTask.setOnClickListener {
            val addTaskBottomSheet = AddTaskBottomSheetDialogFragment()
            addTaskBottomSheet.show(childFragmentManager, addTaskBottomSheet.tag)
        }

        return view
    }
}
