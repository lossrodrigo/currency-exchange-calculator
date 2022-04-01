package com.example.currencyexchangecalculator

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.currencyexchangecalculator.databinding.FragmentMainScreenBinding


class MainScreenFragment : Fragment() {

    private val viewModel: MainScreenViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var baseCurrency = "EUR"
        var targetCurrency = "USD"

        // Inflate the layout for this fragment
        val binding = FragmentMainScreenBinding.inflate(inflater)
        //binding lifecycle
        binding.lifecycleOwner = this
        //binding viewModel
        binding.viewmodel = viewModel

        //Created spinnerBase and spinnerTarget
        val spinnerBase: Spinner = binding.spinnerBaseCurrency
        val spinnerTarget: Spinner = binding.spinnerTargetCurrency

        // edit text base and target value sent to viewmodel
        var etBaseValue: String
        var etTargetValue: String


        //createFromresource para pegar a lista de arrays de string local
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.currencies_array_base,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            //Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            //Apply the adapter to the spinner
            spinnerBase.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.currencies_array_target,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            //Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            //Apply the adapter to the spinner
            spinnerTarget.adapter = adapter
        }

        spinnerBase.onItemSelectedListener = (object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                baseCurrency = parent?.getItemAtPosition(position).toString()
                viewModel.setBaseCurrencyCommunicator(baseCurrency)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        })

        spinnerTarget.onItemSelectedListener = (object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                targetCurrency = parent?.getItemAtPosition(position).toString()
                viewModel.setTargetCurrencyCommunicator(targetCurrency)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        })


        //Observing changes in base and target values
        viewModel._onChangeBaseEt.observe(viewLifecycleOwner, Observer { status ->
            status?.let {
                etBaseValue = binding.editTextBase.editText?.text.toString()
                etBaseValue = etBaseValue.replace(",", ".")

                try{
                    viewModel.setEtBaseValue(etBaseValue.toDouble())
                }catch (numberFormatException: NumberFormatException){
                    etBaseValue = "0.00"
                    viewModel.setEtBaseValue(etBaseValue.toDouble())
                    Toast.makeText(activity, "Type a valid number", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel._onChangeTargetEt.observe(viewLifecycleOwner, Observer { status ->
            status?.let {
                etTargetValue = binding.editTextTarget.editText?.text.toString()
                etTargetValue = etTargetValue.replace(",",".")

                try {
                    viewModel.setEtTargetValue(etTargetValue.toDouble())
                }catch (numberFormatException: NumberFormatException){
                    etTargetValue = "0.00"
                    viewModel.setEtTargetValue(etTargetValue.toDouble())
                    Toast.makeText(activity, "Type a valid number", Toast.LENGTH_LONG).show()
                }
            }
        })

        // listener to clean the edit text when on focus
        binding.editTextBase.editText?.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                etBaseValue = ""
                etTargetValue = ""
                viewModel.clearInput(etBaseValue, etTargetValue)
            }
        }

        binding.editTextTarget.editText?.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                etTargetValue = ""
                etTargetValue = ""
                viewModel.clearInput(etTargetValue, etTargetValue)
            }
        }

        //observing changing on the flags
        viewModel._onChangeFlag.observe(viewLifecycleOwner, Observer { status ->
            status?.let{
                etBaseValue = ""
                etTargetValue = ""
                binding.imageViewBase.setImageResource(viewModel.baseFlag)
                binding.imageViewTarget.setImageResource(viewModel.targetFlag)
                viewModel.clearInput(etBaseValue, etTargetValue)
            }
        })


        return binding.root
    }
}