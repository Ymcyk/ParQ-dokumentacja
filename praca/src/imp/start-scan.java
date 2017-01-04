public void startScanOnClick(View view) {
    IntentIntegrator integrator = new IntentIntegrator(this)
            .setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
            .setPrompt("Scan")
            .setOrientationLocked(true);
    integrator.initiateScan();
}
