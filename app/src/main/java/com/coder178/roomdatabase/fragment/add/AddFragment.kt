package com.coder178.roomdatabase.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.coder178.roomdatabase.R
import com.coder178.roomdatabase.data.User
import com.coder178.roomdatabase.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class AddFragment : Fragment() {

    private lateinit var muserViewModel:UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        muserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstname = addFirstName.text.toString()
        val lastname = addLastName.text.toString()
        val age = addAge.text

        if (inputcheck(firstname, lastname, age)) {
            val user = User(0, firstname, lastname, Integer.parseInt(age.toString()))
            muserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Fill all required details", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputcheck(firstname:String,lastname:String,age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && age.isEmpty())
    }
}