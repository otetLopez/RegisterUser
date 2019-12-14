package com.f19.rosette_768425_ft;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonDetailsFragment extends Fragment {

//    private int id;
//    private int pos;

    public void displayDetails(int id, Person person) {
        View view = getView();
        if (view != null) {

            ImageView imageView = view.findViewById(R.id.detail_img);
            TextView name = view.findViewById(R.id.detail_name);
            TextView email = view.findViewById(R.id.detail_email);
            TextView phone = view.findViewById(R.id.detail_num);

            imageView.setImageResource(person.getImg());
            name.setText(person.getName());
            email.setText(person.getEmail());
            phone.setText(String.valueOf(person.getPhone()));
            Log.i("TAG", "displayDetails: " + id);
        }
    }

    /*
    public void setPos(int pos) {
        this.pos = pos;
    }


    public void setPosition_id(int position_id) {
        this.id = position_id;
    }
     */
    public PersonDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_details, container, false);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        View view = getView();
//        if (view != null) {
//            TextView title_text = view.findViewById(R.id.title_position);
//            TextView description_text = view.findViewById(R.id.description_position);
////            Position position = Position.positions[(int) position_id];
//            Position position = Position.positions[pos];
//            title_text.setText(position.getTitle());
//            description_text.setText(position.getDescription());
//
//        }
//    }


}



//
//
///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link PersonDetailsFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link PersonDetailsFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class PersonDetailsFragment extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
//
//    public PersonDetailsFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment PersonDetailsFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static PersonDetailsFragment newInstance(String param1, String param2) {
//        PersonDetailsFragment fragment = new PersonDetailsFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_person_details, container, false);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
//}