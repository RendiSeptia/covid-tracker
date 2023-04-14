package com.rendi.covidtrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rendi.covidtrackerapp.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private TextView cases;
    private TextView recovered;
    private TextView deaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cases = findViewById(R.id.casesResult);
        recovered = findViewById(R.id.recoveredResult);
        deaths = findViewById(R.id.deathsResult);

        getDataFromApi();
    }

    private void getDataFromApi() {

        ApiService.endpoint().getData()
                .enqueue(new Callback<MainModel>() {
                    @Override
                    public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                        if (response.isSuccessful()) {
                            MainModel results = response.body();
                            Log.d(TAG, results.toString());
                            showResult(results);
                        }
                    }
                    @Override
                    public void onFailure(Call<MainModel> call, Throwable t) {
                        Log.d( TAG, t.toString());
                    }
                });
    }


    private void showResult(MainModel mainModels){
        cases.setText(mainModels.getCases());
        recovered.setText(mainModels.getRecovered());
        deaths.setText(mainModels.getDeaths());
    }
}