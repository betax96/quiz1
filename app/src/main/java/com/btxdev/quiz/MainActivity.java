package com.btxdev.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recCars;
    private List<Car> cars;
    private TextInputLayout tilBrand, tilModel, tilPlate;
    private CarAdapter carAdapter;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recCars = findViewById(R.id.recCars);
        tilBrand = findViewById(R.id.tilBrand);
        tilModel = findViewById(R.id.tilModel);
        tilPlate = findViewById(R.id.tilPlate);
        btnAdd = findViewById(R.id.btnAdd);

        cars = new ArrayList<>();

        carAdapter = new CarAdapter(cars);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recCars.setLayoutManager(layoutManager);

        recCars.setItemAnimator(new DefaultItemAnimator());
        recCars.addItemDecoration(new DividerItemDecoration(recCars.getContext(),DividerItemDecoration.VERTICAL));

        recCars.setAdapter(carAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(tilBrand.getEditText().getText())&&!TextUtils.isEmpty(tilModel.getEditText().getText())
                        &&!TextUtils.isEmpty(tilPlate.getEditText().getText())){
                    cars.add(0, new Car(tilModel.getEditText().getText().toString(),tilBrand.getEditText().getText().toString(),
                            tilPlate.getEditText().getText().toString()));
                    carAdapter.notifyItemInserted(0);
                    recCars.scrollToPosition(0);
                }
            }
        });






    }
}