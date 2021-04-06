package com.hansung.android.tablephonefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "index"; //Bundle 객체에 넣을 키값
    private int mIndex;

    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param index selected position in the ListView.
     * @return A new instance of fragment DetailsFragment.
     */

    //팩토리 메소드 : 객체 인스턴스를 만들어서 Bundle 타입에 정보를 담아서(키:값) fragment객체를 전달
    public static DetailsFragment newInstance(int index) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle(); // 인자값을 저장할 번들 객체 생성
        args.putInt(ARG_PARAM1, index); // 인자 값을 (키,값) 페어로 번들 객체에 설정
        fragment.setArguments(args); //인자값을 저장한 번들 객체를 프래그먼트로 전달
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIndex = getArguments().getInt(ARG_PARAM1); //키값이 ARG_PARAM1에 적혀 있는 값(int)값을 mIndex에 저장
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        TextView tv = (TextView)view.findViewById(R.id.textview);

        if (mIndex >=0) //mIndex = 선택된 항목 위치 번호
            tv.setText(Shakespeare.DIALOGUE[mIndex]); //데이터를 textview에 뿌려줌
        return view;
    }
}