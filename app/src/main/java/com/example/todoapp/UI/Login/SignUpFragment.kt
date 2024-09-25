package com.example.todoapp.UI.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController() // Lấy NavController

        binding.signupHint.setOnClickListener {
            // Điều hướng quay lại màn hình đăng nhập
            navController.popBackStack() // Thay thế cho supportFragmentManager.popBackStack()
        }

        binding.signupButton.setOnClickListener {
            // Thực hiện đăng ký
            val fullName = binding.signupName.text.toString()
            val phone = binding.signupPhone.text.toString()
            val password = binding.signupPass1.text.toString()
            val confirmPassword = binding.signupPass2.text.toString()

            if (fullName.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Please complete all information", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(requireContext(), "Password and re-enter password do not match", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Registered successfully", Toast.LENGTH_SHORT).show()

                // Tạo Bundle để truyền dữ liệu cho màn hình đăng nhập
                val bundle = bundleOf("EXTRA_PHONE" to phone, "EXTRA_PASSWORD" to password)

                // Điều hướng quay lại màn hình đăng nhập và truyền bundle
                navController.popBackStack() // Quay lại LoginFragment
                navController.navigate(R.id.signInFragment, bundle) // Điều hướng đến LoginFragment với bundle
            }
        }
    }

}