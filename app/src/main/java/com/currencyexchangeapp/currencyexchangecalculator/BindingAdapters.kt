package com.currencyexchangeapp.currencyexchangecalculator

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter

@BindingAdapter("apiStatus")
fun bindStatusImageView(statusImageView:ImageView, status: ApiStatus?) {
    when(status) {
        ApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiStatus2")
fun bindStatusTextView(statusTextView: TextView, status: ApiStatus?) {
    when(status) {
        ApiStatus.DONE -> {
            statusTextView.visibility = View.GONE
        }
        ApiStatus.ERROR -> {
            statusTextView.visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("apiStatus3")
fun bindStatusCardViewBase(cardViewBase: CardView, status: ApiStatus?) {
    when(status) {
        ApiStatus.DONE -> {
            cardViewBase.visibility = View.VISIBLE
        }
        ApiStatus.ERROR -> {
            cardViewBase.visibility = View.GONE
        }
    }
}

@BindingAdapter("apiStatus4")
fun bindStatusCardViewTarget(cardViewTarget: CardView, status: ApiStatus?) {
    when(status) {
        ApiStatus.DONE -> {
            cardViewTarget.visibility = View.VISIBLE
        }
        ApiStatus.ERROR -> {
            cardViewTarget.visibility = View.GONE
        }
    }
}