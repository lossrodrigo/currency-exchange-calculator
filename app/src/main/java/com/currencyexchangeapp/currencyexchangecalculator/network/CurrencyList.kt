package com.currencyexchangeapp.currencyexchangecalculator.network

import com.squareup.moshi.Json

data class CurrencyList(
    val success: Boolean,
    val timestamp: String,
    val base: String,
    val date: String,
    val rates: Rates
)

class Rates(
    /*
    @Json(name = "AED") val aed: Double,
    @Json(name = "AFN") val afn: Double,
    @Json(name = "ALL") val all: Double,
    @Json(name = "AMD") val amd: Double,
    @Json(name = "ANG") val ang: Double,
    @Json(name = "AOA") val aoa: Double,

     */
    @Json(name = "ARS") val ars: Double,
    /*
    @Json(name = "AUD") val aud: Double,
    @Json(name = "AWG") val awd: Double,
    @Json(name = "AZN") val azn: Double,

    @Json(name = "BAM") val bam: Double,
    @Json(name = "BBD") val bbd: Double,
    @Json(name = "BDT") val bdt: Double,
    @Json(name = "BGN") val bgn: Double,
    @Json(name = "BHD") val bhg: Double,
    @Json(name = "BIF") val bif: Double,
    @Json(name = "BMD") val bmd: Double,
    @Json(name = "BND") val bnd: Double,
    @Json(name = "BOB") val bob: Double,
    */
    @Json(name = "BRL") val brl: Double,
    /*
    @Json(name = "BSD") val bsd: Double,
    @Json(name = "BTC") val btc: Double,
    @Json(name = "BTN") val btn: Double,
    @Json(name = "BWP") val bwp: Double,
    @Json(name = "BYN") val byn: Double,
    @Json(name = "BYR") val byr: Double,
    @Json(name = "BZD") val bzd: Double,
    */

    @Json(name = "CAD") val cad: Double,
    /*
    @Json(name = "CDF") val cdf: Double,
    @Json(name = "CHF") val chf: Double,
    @Json(name = "CLF") val clf: Double,
    @Json(name = "CLP") val clp: Double,
    @Json(name = "CNY") val cny: Double,
    @Json(name = "COP") val cop: Double,
    @Json(name = "CRC") val crc: Double,
    @Json(name = "CUC") val cuc: Double,
    @Json(name = "CUP") val cup: Double,
    @Json(name = "CVE") val cve: Double,
    @Json(name = "CZK") val czk: Double,

    @Json(name = "DJF") val djf: Double,
    @Json(name = "DKK") val dkk: Double,
    @Json(name = "DOP") val dop: Double,
    @Json(name = "DZD") val dzd: Double,

    @Json(name = "EGP") val egp: Double,
    @Json(name = "ERN") val ern: Double,
    @Json(name = "ETB") val etb: Double,
    */
    @Json(name = "EUR") val eur: Double,
    /*
    @Json(name = "FJD") val fjd: Double,
    @Json(name = "FKP") val fkp: Double,
    */

    @Json(name = "GBP") val gbp: Double,

    /*
    @Json(name = "GEL") val gel: Double,
    @Json(name = "GGP") val ggp: Double,
    @Json(name = "GHS") val ghs: Double,
    @Json(name = "GIP") val gip: Double,
    @Json(name = "GMD") val gmd: Double,
    @Json(name = "GNF") val gnf: Double,
    @Json(name = "GTQ") val gto: Double,
    @Json(name = "GYD") val gyd: Double,


    @Json(name = "HKD") val hkd: Double,
    @Json(name = "HNL") val hnl: Double,
    @Json(name = "HRK") val hrk: Double,
    @Json(name = "HTG") val htg: Double,
    @Json(name = "HUF") val huf: Double,

    @Json(name = "IDR") val idr: Double,
    @Json(name = "ILS") val ils: Double,
    @Json(name = "IMP") val imp: Double,
    @Json(name = "INR") val inr: Double,
    @Json(name = "IQD") val iqd: Double,
    @Json(name = "IRR") val irr: Double,
    @Json(name = "ISK") val isk: Double,

    @Json(name = "JEP") val jep: Double,
    @Json(name = "JMD") val jmd: Double,
    @Json(name = "JOD") val jod: Double,
    @Json(name = "JPY") val jpy: Double,

    @Json(name = "KES") val kes: Double,
    @Json(name = "KGS") val kgs: Double,
    @Json(name = "KHR") val khr: Double,
    @Json(name = "KMF") val kmf: Double,
    @Json(name = "KPW") val kpw: Double,
    @Json(name = "KRW") val krw: Double,
    @Json(name = "KWD") val kwd: Double,
    @Json(name = "KYD") val kyd: Double,
    @Json(name = "KZT") val kzt: Double,

    @Json(name = "LAK") val lak: Double,
    @Json(name = "LBP") val lbp: Double,
    @Json(name = "LKR") val lkr: Double,
    @Json(name = "LRD") val lrd: Double,
    @Json(name = "LSL") val lsl: Double,
    @Json(name = "LTL") val ltl: Double,
    @Json(name = "LVL") val lvl: Double,
    @Json(name = "LYD") val lyd: Double,

    @Json(name = "MAD") val mad: Double,
    @Json(name = "MDL") val mdl: Double,
    @Json(name = "MGA") val mga: Double,
    @Json(name = "MKD") val mkd: Double,
    @Json(name = "MMK") val mmk: Double,
    @Json(name = "MNT") val mnt: Double,
    @Json(name = "MOP") val mop: Double,
    @Json(name = "MRO") val mro: Double,
    @Json(name = "MUR") val mur: Double,
    @Json(name = "MVR") val mvr: Double,
    @Json(name = "MWK") val mwk: Double,
    @Json(name = "MXN") val mxn: Double,
    @Json(name = "MYR") val myr: Double,
    @Json(name = "MZN") val mzn: Double,

    @Json(name = "NAD") val nad: Double,
    @Json(name = "NGN") val ngn: Double,
    @Json(name = "NIO") val nio: Double,
    @Json(name = "NOK") val nok: Double,
    @Json(name = "NPR") val npr: Double,
    @Json(name = "NZD") val nzd: Double,

    @Json(name = "OMR") val omr: Double,
    @Json(name = "PAB") val pab: Double,
    @Json(name = "PEN") val pen: Double,
    @Json(name = "PGK") val pgk: Double,
    @Json(name = "PHP") val php: Double,
    @Json(name = "PKR") val pkr: Double,
    @Json(name = "PLN") val pln: Double,
    @Json(name = "PYG") val pyg: Double,

    @Json(name = "QAR") val qar: Double,

    @Json(name = "RON") val ron: Double,
    @Json(name = "RSD") val rsd: Double,
    @Json(name = "RUB") val rub: Double,
    @Json(name = "RWF") val rwf: Double,

    @Json(name = "SAR") val sar: Double,
    @Json(name = "SBD") val sbd: Double,
    @Json(name = "SCR") val scr: Double,
    @Json(name = "SDG") val sdg: Double,
    @Json(name = "SEK") val sek: Double,
    @Json(name = "SGD") val sgd: Double,
    @Json(name = "SHP") val shp: Double,
    @Json(name = "SLL") val sll: Double,
    @Json(name = "SOS") val sos: Double,
    @Json(name = "SRD") val srd: Double,
    @Json(name = "STD") val std: Double,
    @Json(name = "SVC") val svc: Double,
    @Json(name = "SYP") val syp: Double,
    @Json(name = "SZL") val szl: Double,

    @Json(name = "THB") val thb: Double,
    @Json(name = "TJS") val tjs: Double,
    @Json(name = "TMT") val tnt: Double,
    @Json(name = "TND") val tnd: Double,
    @Json(name = "TOP") val top: Double,
    @Json(name = "TRY") val try: Double,
    @Json(name = "TTD") val ttd: Double,
    @Json(name = "TWD") val twd: Double,
    @Json(name = "TZS") val tzs: Double,

    @Json(name = "UAH") val uah: Double,
    @Json(name = "UGX") val ugx: Double,
    */
    @Json(name = "USD") val usd: Double,
    /*
    @Json(name = "UYU") val uyu: Double,
    @Json(name = "UZS") val uzs: Double,

    @Json(name = "VND") val vnd: Double,
    @Json(name = "VUV") val vuv: Double,

    @Json(name = "WST") val wst: Double,

    @Json(name = "XAF") val xaf: Double,
    @Json(name = "XAG") val xag: Double,
    @Json(name = "XAU") val xau: Double,
    @Json(name = "XCD") val xcd: Double,
    @Json(name = "XDR") val xdr: Double,
    @Json(name = "XOF") val xof: Double,
    @Json(name = "XPF") val xpf: Double,

    @Json(name = "YER") val yer: Double,

    @Json(name = "ZAR") val zar: Double,
    @Json(name = "ZMK") val zmk: Double,
    @Json(name = "ZMW") val zmw: Double,
    @Json(name = "ZWL") val zwl: Double
    */
)

