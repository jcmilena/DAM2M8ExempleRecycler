package com.example.juancarlosmilena.exemplerecyclerview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class JuegoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private JuegoListener mListener;


    Button mContar, mClassif;
    int pulsaciones;

    public JuegoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JuegoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JuegoFragment newInstance(String param1, String param2) {
        JuegoFragment fragment = new JuegoFragment();
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
        pulsaciones =0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_juego, container, false);

        mClassif = view.findViewById(R.id.clasif);
        mContar = view.findViewById(R.id.contar);

        mContar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsaciones++;
                mListener.contar_pulsaciones(pulsaciones);

            }
        });

        mClassif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsaciones = mListener.mostrar_clasificacion();
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof JuegoListener) {
            mListener = (JuegoListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface JuegoListener {
        // TODO: Update argument type and name
        void contar_pulsaciones(int pulsac);
        int mostrar_clasificacion();
    }
}
