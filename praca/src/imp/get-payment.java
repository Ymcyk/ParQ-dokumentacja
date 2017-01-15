private void getPayment() {
    paymentAmount = amountText.getText().toString();

    PayPalPayment payment = new PayPalPayment(new BigDecimal(
            String.valueOf(paymentAmount)),
            "PLN", "Ticket Fee", PayPalPayment.PAYMENT_INTENT_SALE);

    Intent intent = new Intent(this, PaymentActivity.class);
    intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
    intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);

    startActivityForResult(intent, PAYPAL_REQUEST_CODE);
}
