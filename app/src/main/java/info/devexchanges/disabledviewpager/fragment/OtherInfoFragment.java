package info.devexchanges.disabledviewpager.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import info.devexchanges.disabledviewpager.InputActivity;
import info.devexchanges.disabledviewpager.R;

public class OtherInfoFragment extends Fragment {

    private Spinner spinner;
    private TextInputLayout inputLayout;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> genders;
    private View btnNext;

    private String gender;

    private OnInfoChangedListener callback;

    // Container Activity must implement this interface
    public interface OnInfoChangedListener {
        public void onInfoChanged(String age, String gender);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_other_infor, null, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            callback = (OnInfoChangedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinner = (Spinner)view.findViewById(R.id.gender);
        inputLayout = (TextInputLayout)view.findViewById(R.id.age_field);
        btnNext = view.findViewById(R.id.btn_next);

        //set spinner adapter
        genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, genders);
        spinner.setAdapter(adapter);

        //set on item spinner selected
        spinner.setOnItemSelectedListener(onItemSelectedListener());

        //set click event for button
        btnNext.setOnClickListener(onNextListener());

    }

    private View.OnClickListener onNextListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputLayout.getEditText().getText().toString().trim().equals("")) {
                    Toast.makeText(getActivity(), "Please input your age", Toast.LENGTH_SHORT).show();
                } else {
                    callback.onInfoChanged(inputLayout.getEditText().getText().toString(), gender);
                    ((InputActivity) getActivity()).goToResultActivity();
                }
            }
        };
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }
}
