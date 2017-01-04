@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode != PAYPAL_REQUEST_CODE)
        return;

    if(resultCode == Activity.RESULT_OK){
        PaymentConfirmation confirm = data.getParcelableExtra(
                PaymentActivity.EXTRA_RESULT_CONFIRMATION);
        if(confirm != null){
            try {
                String paymentDetils = confirm.toJSONObject().toString(4);
                Log.i("payment", paymentDetils);
                startActivity(new Intent(this, ConfirmationActivity.class)
                    .putExtra("PaymentResultJson", paymentDetils)
                    .putExtra("PaymentAmount", paymentAmount));
            } catch(JSONException e) {
                Log.e("payment", "Error occurred on parsing: ", e);
            }
        }
    } else if(resultCode == Activity.RESULT_CANCELED) {
        Log.i("payment", "User canceled");
    } else if(resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
        Log.i("payment", "Invalid payment or PayPalConfiguration");
}
