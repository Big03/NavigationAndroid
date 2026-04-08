package com.example.navigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ustawienia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ustawienia extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TextView textView1;
    public SeekBar seekBar1;

    public Ustawienia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ustawienia.
     */
    // TODO: Rename and change types and number of parameters
    public static Ustawienia newInstance(String param1, String param2) {
        Ustawienia fragment = new Ustawienia();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_ustawienia, container, false);

        Button bt = root.findViewById(R.id.buttonUstawieniaReturn);
        bt.setOnClickListener(view ->
                Navigation.findNavController(view)
                        .navigate(R.id.memory)
        );

        seekBar1 = root.findViewById(R.id.seekBar);
        textView1 = root.findViewById(R.id.textView2);
        seekBar1.setMax(30);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float value = 3f + (progress / 10f);
                textView1.setText(String.format("%.1f", value));
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        ToggleButton toggleButton = root.findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        RadioButton r1 = root.findViewById(R.id.radioButton1);
        RadioButton r2 = root.findViewById(R.id.radioButton2);
        RadioButton r3 = root.findViewById(R.id.radioButton3);
        RadioButton r4 = root.findViewById(R.id.radioButton4);

        View.OnClickListener listener = v -> {
            r1.setChecked(false);
            r2.setChecked(false);
            r3.setChecked(false);
            r4.setChecked(false);

            ((RadioButton) v).setChecked(true);
        };

        r1.setOnClickListener(listener);
        r2.setOnClickListener(listener);
        r3.setOnClickListener(listener);
        r4.setOnClickListener(listener);

        return root;
    }
}