package com.example.juancarlosmilena.exemplerecyclerview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


public class PartidaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private PartidasListener mListener;

    RecyclerView recyclerView;
    List<Partida> clasificacion;
    ClasifAdapter miAdapter;

    public PartidaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartidaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PartidaFragment newInstance(String param1, String param2) {
        PartidaFragment fragment = new PartidaFragment();
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
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_partida, container, false);
        recyclerView = view.findViewById(R.id.recyclerV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        clasificacion = mListener.cargar_partidas();
        miAdapter = new ClasifAdapter(clasificacion);

        recyclerView.setAdapter(miAdapter);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PartidasListener) {
            mListener = (PartidasListener) context;
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

    public interface PartidasListener {
        // TODO: Update argument type and name
         List<Partida> cargar_partidas();
    }

    public class ClasifAdapter extends RecyclerView.Adapter<ClasifAdapter.PartidaHolder>{

        List<Partida> clasif;

        public ClasifAdapter(List<Partida> clasif) {
            this.clasif = clasif;
        }

        @NonNull
        @Override
        public PartidaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = getLayoutInflater();

            return new PartidaHolder(layoutInflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull PartidaHolder partidaHolder, int i) {

            Partida p = clasif.get(i);

            partidaHolder.fecha.setText(p.getDate());
            partidaHolder.jugador.setText(p.getJugador());
            partidaHolder.puntuacion.setText(Integer.toString(p.getPuntuacion()));

        }

        @Override
        public int getItemCount() {
            return clasif.size();
        }

        public class PartidaHolder extends RecyclerView.ViewHolder{

            TextView fecha, jugador, puntuacion;

            public PartidaHolder(LayoutInflater layoutInflater, ViewGroup parent) {
                super(layoutInflater.inflate(R.layout.partidaholder, parent,false));

                fecha = itemView.findViewById(R.id.fecha);
                jugador = itemView.findViewById(R.id.jugador);
                puntuacion = itemView.findViewById(R.id.puntuacion);
            }
        }
    }
}
