package com.example.shoppinglist.ui.shoppinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog : DialogFragment() {


    private var _binding: DialogAddShoppingItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = DialogAddShoppingItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter the all information", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val entity = ShoppingItem(name = name, amount = amount.toInt())
            val bundle = Bundle().apply {
                putSerializable("itemData",entity)
            }
            setFragmentResult("added",bundle)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            dismiss()
        }
    }
}


