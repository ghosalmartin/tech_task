package com.example.mgh01.techtask.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mgh01.techtask.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable) {
            if (login_email_address_input_field.text.isBlank()
                    || login_password_input_field.text.isBlank()) {
                disableButton()
            } else {
                enableButton()
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        disableButton()
        login_email_address_input_field.addTextChangedListener(textWatcher)
        login_password_input_field.addTextChangedListener(textWatcher)
    }

    private fun disableButton() {
        login_button.alpha = .5f
        login_button.isClickable = false
    }

    private fun enableButton() {
        login_button.alpha = 1f
        login_button.isClickable = true
    }
}