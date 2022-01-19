package com.alkemy.ongsomosmas.ui.contactus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.databinding.FragmentContactUsBinding
import com.alkemy.ongsomosmas.ui.BaseFragment
import com.alkemy.ongsomosmas.utils.afterTextChanged
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactFragment : BaseFragment(R.layout.fragment_contact_us) {

    private lateinit var binding: FragmentContactUsBinding
    private val contactViewModel: ContactViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactUsBinding.inflate(inflater, container, false)

        validation()

        binding.button.setOnClickListener {
            showProgressDialog()
            contactViewModel.contact(
                0,
                binding.etName.text.toString() + " " + binding.etSurname.text.toString(),
                binding.etEmail.text.toString(),
                "",
                binding.etQuery.text.toString(),
                "",
                "",
                ""
            )
        }

        contactViewModel.contactFormState.observe(viewLifecycleOwner, Observer {
            val contactState = it ?: return@Observer

            binding.button.isEnabled = contactState.isDataValid
            binding.etEmail.error = contactState.emailError?.let { error -> getString(error) }
        })

        contactViewModel.contactResponse.observe(viewLifecycleOwner, Observer {

            binding.loading.progressBar.isVisible = it.status == Resource.Status.LOADING

            when (it.status) {
                Resource.Status.SUCCESS -> {
                    hideProgressDialog()
                    Toast.makeText(
                        context,
                        getString(R.string.contact_us_toast_success),
                        Toast.LENGTH_SHORT
                    ).show()
                    clearFields()
                }
                Resource.Status.ERROR -> {
                    showErrorDialog(
                        getString(R.string.contact_us_dialog_error_title),
                        getString(R.string.contact_us_dialog_error_description)
                    )
                    binding.etEmail.afterTextChanged {
                        binding.tfEmail.error = null
                    }
                }
                else -> {
                }
            }
        })

        return binding.root
    }

    private fun validation() {
        binding.etEmail.afterTextChanged {
            contactViewModel.contactDataChanged(
                binding.etEmail.text.toString(),
                binding.etName.text.toString(),
                binding.etSurname.text.toString(),
                binding.etQuery.text.toString()
            )
        }

        binding.etName.afterTextChanged {
            contactViewModel.contactDataChanged(
                binding.etEmail.text.toString(),
                binding.etName.text.toString(),
                binding.etSurname.text.toString(),
                binding.etQuery.text.toString()
            )
        }

        binding.etSurname.afterTextChanged {
            contactViewModel.contactDataChanged(
                binding.etEmail.text.toString(),
                binding.etName.text.toString(),
                binding.etSurname.text.toString(),
                binding.etQuery.text.toString()
            )
        }

        binding.etQuery.afterTextChanged {
            contactViewModel.contactDataChanged(
                binding.etEmail.text.toString(),
                binding.etName.text.toString(),
                binding.etSurname.text.toString(),
                binding.etQuery.text.toString()
            )
        }
    }

    private fun showErrorDialog(title: String, message: String?) {
        val dialog: AlertDialog? =
            context?.let {
                AlertDialog.Builder(it).setMessage(message).setTitle(title)
                    .setNeutralButton(
                        "Cerrar"
                    ) { _, _ -> }
                    .create()
            }
        dialog?.show()
    }

    private fun clearFields() {
        binding.etSurname.text?.clear()
        binding.etQuery.text?.clear()
        binding.etName.text?.clear()
        binding.etEmail.text?.clear()
    }
}