package com.example.gsonfragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = "MAIN_FRAGMENT";
    TextView mTextView;
    Button mButton;
    Data data;
    public MainFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView= view.findViewById(R.id.display_text);
        mButton= view.findViewById(R.id.selector_btn);
        mButton.setOnClickListener(this);
        Gson gson = new GsonBuilder().create();
        //create Data object (list of SampleData) using String-Array in strings.xml
        data = gson.fromJson(getString(R.string.data), Data.class);
        mTextView.setText(data.getNextSample().toString());
        for(Data.SampleData x: data.list_data){
            System.out.println("Test: " + x.toString());
        }
        //convert list of SampleData to String
        String listAsString = gson.toJson(data, Data.class);
        System.out.println("Test: "+listAsString);
    }

    @Override
    public void onClick(View v) {
        mTextView.setText(data.getNextSample().toString());
    }
}
