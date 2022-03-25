package com.example.currencyexchangecalculator

import android.app.Activity
import android.app.ActivityManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangecalculator.network.CurrenciesQuotationsApi
import com.example.currencyexchangecalculator.network.CurrencyList
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.coroutineContext
import kotlin.math.round
import kotlin.math.roundToInt

class MainScreenViewModel: ViewModel() {


    private val _currencies = MutableLiveData<CurrencyList>()
    val currencies: LiveData<CurrencyList> = _currencies

    private val _baseCurrency = MutableLiveData<String>()
    val baseCurrency: LiveData<String> = _baseCurrency

    private val _targetCurrency = MutableLiveData<String>()
    val targetCurrency: LiveData<String> = _targetCurrency

    private var _editTextBaseValue = MutableLiveData<String>()
    val editTextBaseValue: LiveData<String> = _editTextBaseValue

    private var _editTextTargetValue = MutableLiveData<String>()
    val editTextTargetValue: LiveData<String> = _editTextTargetValue

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    var baseFlag: Int = 0
    var targetFlag: Int = 0

    private var baseCurrencyValue: Double = 0.00
    private var targetCurrencyValue: Double = 0.00

    var _onChangeBaseEt = MutableLiveData<Boolean?>()
    var _onChangeTargetEt = MutableLiveData<Boolean?>()
    var _onChangeFlag = MutableLiveData<Boolean?>()

    private var editTextBaseValueDouble: Double = 0.00
    private var editTextTargetValueDouble: Double = 0.00

    init {
        currencyQuotation()
    }

    //receiving base currency chose from spinner in the fragment
    fun setBaseCurrencyCommunicator(baseCurrency: String) {
        _baseCurrency.value = baseCurrency
        setFlag()
    }

    //receiving target currency chose from spinner in the fragment
    fun setTargetCurrencyCommunicator(targetCurrency: String) {
        _targetCurrency.value = targetCurrency
        setFlag()
    }

    private fun currencyQuotation() {
        viewModelScope.launch {
            try {
                val listResult = CurrenciesQuotationsApi.retrofitService.getCurrenciesQuotations()
                _currencies.value = listResult

            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    fun onClickEditTextBaseValue() {
        _onChangeBaseEt.value = true
        inputBaseAndTargetCurrency()
        calcResult()
        _onChangeBaseEt.value = false
    }

    fun onClickEditTextTargetValue() {
        _onChangeTargetEt.value = true
        inputBaseAndTargetCurrency()
        calcResult()
        _onChangeTargetEt.value = false
    }

    //defining base currency and target currency
    private fun inputBaseAndTargetCurrency() {
        when (_baseCurrency.value.toString()) {
            "Euro (EUR)" -> baseCurrencyValue = _currencies.value!!.rates.eur
            "United States Dollar (USD)" -> baseCurrencyValue = _currencies.value!!.rates.usd
            "Pound sterling (GBP)" -> baseCurrencyValue = _currencies.value!!.rates.gbp
            "Brazilian Real (BRL)" -> baseCurrencyValue = _currencies.value!!.rates.brl
            "Argentina (Peso)" -> baseCurrencyValue = _currencies.value!!.rates.ars
            "Canadian Dollar (CAD)" -> baseCurrencyValue = _currencies.value!!.rates.cad
        }
        when (_targetCurrency.value.toString()) {
            "Euro (EUR)" -> targetCurrencyValue = _currencies.value!!.rates.eur
            "United States Dollar (USD)" -> targetCurrencyValue = _currencies.value!!.rates.usd
            "Pound sterling (GBP)" -> targetCurrencyValue = _currencies.value!!.rates.gbp
            "Brazilian Real (BRL)" -> targetCurrencyValue = _currencies.value!!.rates.brl
            "Argentina (Peso)" -> targetCurrencyValue = _currencies.value!!.rates.ars
            "Canadian Dollar (CAD)" -> targetCurrencyValue = _currencies.value!!.rates.cad
        }
    }

    //setting base and target values
    fun setEtBaseValue(etBaseValue: Double) {
        _editTextBaseValue.value = "%.2f".format(etBaseValue)
    }

    fun setEtTargetValue(etTargetValue: Double) {
        _editTextTargetValue.value = "%.2f".format(etTargetValue)
    }

    private fun calcResult() {
        var result: Double

        if (_onChangeBaseEt.value == true) {
            editTextBaseValueDouble = _editTextBaseValue.value?.toDouble()!!
            result = (editTextBaseValueDouble * targetCurrencyValue / baseCurrencyValue * 100.0).roundToInt() / 100.0
            _editTextTargetValue.value = "%.2f".format(result)

        }

        if (_onChangeTargetEt.value == true){
            editTextTargetValueDouble = _editTextTargetValue.value?.toDouble()!!
            result = (editTextTargetValueDouble * baseCurrencyValue / targetCurrencyValue * 100.0).roundToInt() / 100.0
            _editTextBaseValue.value = "%.2f".format(result)
        }
    }

    //clear edit text when on focus
    fun clearInput(etBaseValue: String, etTargetValue: String) {
        _editTextBaseValue.value = etBaseValue
        _editTextTargetValue.value = etTargetValue
    }

    //defining flags
    private fun setFlag() {
        when (_baseCurrency.value.toString()) {
            "Euro (EUR)" -> baseFlag = R.drawable.ic_eu
            "United States Dollar (USD)" -> baseFlag = R.drawable.ic_us
            "Pound sterling (GBP)" -> baseFlag = R.drawable.ic_gb
            "Brazilian Real (BRL)" -> baseFlag = R.drawable.ic_br
            "Argentina (Peso)" -> baseFlag = R.drawable.ic_ar
            "Canadian Dollar (CAD)" -> baseFlag = R.drawable.ic_ca
        }

        when (_targetCurrency.value.toString()) {
            "Euro (EUR)" -> targetFlag = R.drawable.ic_eu
            "United States Dollar (USD)" -> targetFlag = R.drawable.ic_us
            "Pound sterling (GBP)" -> targetFlag = R.drawable.ic_gb
            "Brazilian Real (BRL)" -> targetFlag = R.drawable.ic_br
            "Argentina (Peso)" -> targetFlag = R.drawable.ic_ar
            "Canadian Dollar (CAD)" -> targetFlag = R.drawable.ic_ca
        }
        _onChangeFlag.value = true
    }
}