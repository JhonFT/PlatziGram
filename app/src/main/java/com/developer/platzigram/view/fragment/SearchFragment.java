package com.developer.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.platzigram.R;
import com.developer.platzigram.adapter.PrictureAdapterRecyclerView;
import com.developer.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        RecyclerView searchRecycle = (RecyclerView) view.findViewById(R.id.searhRecycler);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        searchRecycle.setLayoutManager(layoutManager);
        PrictureAdapterRecyclerView adapterRecyclerView = new PrictureAdapterRecyclerView(buidPicture(),
                R.layout.cardview_picture,getActivity());
        searchRecycle.setAdapter(adapterRecyclerView);
        return view;
    }
    public ArrayList<Picture> buidPicture(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://3.bp.blogspot.com/-mWyznU_aLxg/T4sT9yb_C6I/AAAAAAAAARc/9ly-u0vbud0/s1600/Cuba-Paisaje-Natural_3.jpg","Uriel Ramirez","4 días","3 Me Gusta"));
        pictures.add(new Picture("https://s-media-cache-ak0.pinimg.com/originals/e1/00/1e/e1001e86903d5fccba2a7e83a0547bd4.jpg","Juan Pablo","1 días","10 Me Gusta"));
        pictures.add(new Picture("http://1.bp.blogspot.com/-kjh6bxfAaqU/T7Pjw5hs9lI/AAAAAAAAN14/7x932jj3HU0/s1600/Fondos+de+pantalla+con+bellos+rincones+de+la+naturaleza+(72).jpg","Anahi Salgado","2 días","9 Me Gusta"));
        return pictures;
    }

}
