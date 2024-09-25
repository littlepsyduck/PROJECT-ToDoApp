package com.example.todoapp.UI.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private var registeredPhone: String? = null
    private var registeredPassword: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController() // Lấy NavController

        registeredPhone = arguments?.getString("EXTRA_PHONE")
        registeredPassword = arguments?.getString("EXTRA_PASSWORD")

        binding.loginName.setText(registeredPhone)

        binding.loginHint.setOnClickListener {
            // Điều hướng sang màn hình đăng ký
            navController.navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.loginButton.setOnClickListener {
            val phone = binding.loginName.text.toString()
            val password = binding.loginPass.text.toString()

            if (phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please complete all information", Toast.LENGTH_SHORT).show()
            } else if (phone == registeredPhone && password == registeredPassword) {
                Toast.makeText(requireContext(), "Logged in successfully", Toast.LENGTH_SHORT).show()

                // Điều hướng đến màn hình chính sau khi đăng nhập thành công
                navController.navigate(R.id.action_signInFragment_to_mainFragment)
            } else {
                Toast.makeText(requireContext(), "Incorrect username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }


}