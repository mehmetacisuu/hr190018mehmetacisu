package com.mehmet.hr190018_mehmet_acisu_final.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import com.mehmet.hr190018_mehmet_acisu_final.R;
import com.mehmet.hr190018_mehmet_acisu_final.model.FutbolcuModel;
import com.mehmet.hr190018_mehmet_acisu_final.util.Constants;
import com.mehmet.hr190018_mehmet_acisu_final.util.GlideUtil;
import com.mehmet.hr190018_mehmet_acisu_final.util.ObjectUtil;

public class FutbolcuDetayActivity extends AppCompatActivity {

    ImageView imgDetay;
    TextView txtBaslik;
    TextView txtDetay;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futbolcu_detay);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void init(){
        String tasinanFutbolcuString = getIntent().getStringExtra(Constants.TIKLANAN_FUTBOLCU_BASLIK);
        FutbolcuModel futbolcuModel = ObjectUtil.jsonStringToFutbolcu(tasinanFutbolcuString);
        
        imgDetay = findViewById(R.id.imgDetay);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);


        txtBaslik.setText(futbolcuModel.getFutbolcuAdSoyad());
        txtDetay.setText(Html.fromHtml(futbolcuModel.getBilgi(),Html.FROM_HTML_MODE_COMPACT));
        GlideUtil.resmiIndiripGoster(getApplicationContext(),futbolcuModel.getBuyukResimUrl(),imgDetay);
    }
}