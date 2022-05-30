package br.com.java.carrinhodecomprasandroid.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import br.com.java.carrinhodecomprasandroid.model.SliderModelo;

public class SliderAdapter extends PagerAdapter {

    private List<SliderModelo> sliderModelos;

    public SliderAdapter(List<SliderModelo> sliderModelos) {
        this.sliderModelos = sliderModelos;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
