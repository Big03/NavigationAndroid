package com.example.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Memory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Memory extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Memory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Memory.
     */
    // TODO: Rename and change types and number of parameters
    public static Memory newInstance(String param1, String param2) {
        Memory fragment = new Memory();
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
        View root = inflater.inflate(R.layout.fragment_memory, container, false);
        // Inflate the layout for this fragment
        Button bt = root.findViewById(R.id.buttonMemoryReturn);
        Button bt2 = root.findViewById(R.id.buttonListaWynikow);
        Button bt3 = root.findViewById(R.id.buttonUstawienia);
        bt.setOnClickListener(view ->
                Navigation.findNavController(view)
                        .navigate(R.id.dodawanieUzytkownika)
        );

        bt2.setOnClickListener(view ->
                Navigation.findNavController(view)
                        .navigate(R.id.listaWynikow)
        );

        bt3.setOnClickListener(view ->
                Navigation.findNavController(view)
                        .navigate(R.id.ustawienia)
        );
        return root;
    }



}