package com.btxdev.quiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> cars;

    CarAdapter(List<Car> cars){
        this.cars = cars;
    }


    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_car,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.txtBrand.setText(car.getBrand());
        holder.txtModel.setText(car.getModel());
        holder.txtPlate.setText(car.getPlate());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    static class CarViewHolder extends RecyclerView.ViewHolder{
        TextView txtModel;
        TextView txtBrand;
        TextView txtPlate;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBrand = itemView.findViewById(R.id.txtBrand);
            txtModel = itemView.findViewById(R.id.txtModel);
            txtPlate = itemView.findViewById(R.id.txtPlate);
        }
    }
}
