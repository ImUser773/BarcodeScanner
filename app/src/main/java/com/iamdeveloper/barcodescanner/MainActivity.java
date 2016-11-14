package com.iamdeveloper.barcodescanner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView zxingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        zxingScannerView = new ZXingScannerView(this);
        setContentView(zxingScannerView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        zxingScannerView.setResultHandler(this);
        zxingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        zxingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(this,result.getText(),Toast.LENGTH_LONG).show();
        Toast.makeText(this,result.getBarcodeFormat().toString(),Toast.LENGTH_LONG).show();

        zxingScannerView.resumeCameraPreview(this);
    }
}
