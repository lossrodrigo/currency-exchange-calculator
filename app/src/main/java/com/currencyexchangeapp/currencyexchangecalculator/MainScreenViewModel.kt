package com.currencyexchangeapp.currencyexchangecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.currencyexchangeapp.currencyexchangecalculator.network.CurrenciesQuotationsApi
import com.currencyexchangeapp.currencyexchangecalculator.network.CurrencyList
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class MainScreenViewModel : ViewModel() {

    private val _currencies = MutableLiveData<CurrencyList>()

    private val _baseCurrency = MutableLiveData<String>()

    private val _targetCurrency = MutableLiveData<String>()

    private var _editTextBaseValue = MutableLiveData<String>()
    val editTextBaseValue: LiveData<String> = _editTextBaseValue

    private var _editTextTargetValue = MutableLiveData<String>()
    val editTextTargetValue: LiveData<String> = _editTextTargetValue

    private val _response = MutableLiveData<String>()

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

    /**
     * Receiving baseCurrency and targetCurrency chose from spinner in the fragment
     */
    fun setBaseCurrencyCommunicator(baseCurrency: String) {
        _baseCurrency.value = baseCurrency
        setFlag()
    }

    fun setTargetCurrencyCommunicator(targetCurrency: String) {
        _targetCurrency.value = targetCurrency
        setFlag()
    }

    /**
     * Receiving currencies quotation from third API using coroutine
     */
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

    /**
     * Defining baseCurrencyValue and targetCurrencyValue based on _baseCurrency and
     * _targetCurrency User choices
     */
    private fun inputBaseAndTargetCurrency() {
        when (_baseCurrency.value.toString()) {
            "Euro (EUR)" -> baseCurrencyValue = _currencies.value!!.rates.eur
            "United States Dollar (USD)" -> baseCurrencyValue = _currencies.value!!.rates.usd
            "Pound sterling (GBP)" -> baseCurrencyValue = _currencies.value!!.rates.gbp
            "Brazilian Real (BRL)" -> baseCurrencyValue = _currencies.value!!.rates.brl
            "Argentine Peso (Peso)" -> baseCurrencyValue = _currencies.value!!.rates.ars
            "Argentine Blue Peso (Peso)" -> baseCurrencyValue = 2 * (_currencies.value!!.rates.ars)
            "Canadian Dollar (CAD)" -> baseCurrencyValue = _currencies.value!!.rates.cad
        }
        when (_targetCurrency.value.toString()) {
            "Euro (EUR)" -> targetCurrencyValue = _currencies.value!!.rates.eur
            "United States Dollar (USD)" -> targetCurrencyValue = _currencies.value!!.rates.usd
            "Pound sterling (GBP)" -> targetCurrencyValue = _currencies.value!!.rates.gbp
            "Brazilian Real (BRL)" -> targetCurrencyValue = _currencies.value!!.rates.brl
            "Argentine Peso (Peso)" -> targetCurrencyValue = _currencies.value!!.rates.ars
            "Argentine Blue Peso (Peso)" -> targetCurrencyValue = 2 * (_currencies.value!!.rates.ars)
            "Canadian Dollar (CAD)" -> targetCurrencyValue = _currencies.value!!.rates.cad
        }
    }

    /**
     * Setting etBaseValue and etTargetValue
     */
    fun setEtBaseValue(etBaseValue: Double) {
        var etBaseValueStg = "%.2f".format(etBaseValue)
        etBaseValueStg = etBaseValueStg.replace(",", ".")
        _editTextBaseValue.value = etBaseValueStg
    }

    fun setEtTargetValue(etTargetValue: Double) {
        var etTargetValueStg = "%.2f".format(etTargetValue)
        etTargetValueStg = etTargetValueStg.replace(",", ".")
        _editTextTargetValue.value = etTargetValueStg
    }

    /**
     * Calculate the result
     */
    private fun calcResult() {
        var result: Double
        var resultStg: String

        if (_onChangeBaseEt.value == true) {
            editTextBaseValueDouble = _editTextBaseValue.value?.toDouble()!!
            result =
                (editTextBaseValueDouble * targetCurrencyValue / baseCurrencyValue * 100.0).roundToInt() / 100.0
            resultStg = "%.2f".format(result)
            resultStg = resultStg.replace(",", ".")
            _editTextTargetValue.value = resultStg

        }

        if (_onChangeTargetEt.value == true) {
            editTextTargetValueDouble = _editTextTargetValue.value?.toDouble()!!
            result =
                (editTextTargetValueDouble * baseCurrencyValue / targetCurrencyValue * 100.0).roundToInt() / 100.0
            resultStg = "%.2f".format(result)
            resultStg = resultStg.replace(",", ".")
            _editTextBaseValue.value = resultStg
        }
    }

    /**
     * Clear edit text when on focus
     */
    fun clearInput() {
        _editTextBaseValue.value = ""
        _editTextTargetValue.value = ""
    }

    /**
     * Defining flags
     */
    private fun setFlag() {
        when (_baseCurrency.value.toString()) {
            "Euro (EUR)" -> baseFlag = R.drawable.ic_eu
            "United States Dollar (USD)" -> baseFlag = R.drawable.ic_us
            "Pound sterling (GBP)" -> baseFlag = R.drawable.ic_gb
            "Brazilian Real (BRL)" -> baseFlag = R.drawable.ic_br
            "Argentine Peso (Peso)" -> baseFlag = R.drawable.ic_ar
            "Argentine Blue Peso (Peso)" -> baseFlag = R.drawable.ic_ar
            "Canadian Dollar (CAD)" -> baseFlag = R.drawable.ic_ca
        }

        when (_targetCurrency.value.toString()) {
            "Euro (EUR)" -> targetFlag = R.drawable.ic_eu
            "United States Dollar (USD)" -> targetFlag = R.drawable.ic_us
            "Pound sterling (GBP)" -> targetFlag = R.drawable.ic_gb
            "Brazilian Real (BRL)" -> targetFlag = R.drawable.ic_br
            "Argentine Peso (Peso)" -> targetFlag = R.drawable.ic_ar
            "Argentine Blue Peso (Peso)" -> targetFlag = R.drawable.ic_ar
            "Canadian Dollar (CAD)" -> targetFlag = R.drawable.ic_ca
        }
        _onChangeFlag.value = true
    }
}