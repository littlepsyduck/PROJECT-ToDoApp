package com.example.todoapp.UI.MainApp

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.window.Dialog
import com.example.todoapp.databinding.FragmentBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddTaskBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout và trả về view sử dụng ViewBinding
        _binding = FragmentBottomSheetDialogBinding.inflate(inflater, container, false)

        // Thiết lập sự kiện cho button
        binding.btnAddTask.setOnClickListener {
            val taskName = binding.etTaskName.text.toString()
            if (taskName.isNotEmpty()) {

                dismiss()
            } else {
                binding.etTaskName.error = "Please enter task name"
            }
        }

        binding.btnSelectDate.setOnClickListener {

        }

        binding.btnSelectCategory.setOnClickListener {

        }

        return binding.root
    }

    // Tùy chỉnh dialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.behavior.isDraggable = true
        return dialog
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
//        dialog.behavior.isDraggable = true  // Cho phép kéo lên/xuống
//        dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
//        return dialog
//    }
}

