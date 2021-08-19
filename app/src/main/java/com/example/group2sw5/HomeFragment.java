package com.example.group2sw5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fragment", "onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment", "onCreate()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment", "onStart()");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment", "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment", "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment", "onDestroy()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        //++++++++++++++++++++++++++
        SharedPreferences sharedPreferences = viewGroup.getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        TextView userName = viewGroup.findViewById(R.id.userNameTextView);
        userName.setText(sharedPreferences.getString("firstName", ""));

        // POST DITO
        int profiles[] = {R.drawable.jomar,R.drawable.zyra, R.drawable.michelle, R.drawable.ella, R.drawable.jomar, R.drawable.jazer, R.drawable.exe};
        int post[] = {R.drawable.jomar_1,R.drawable.zyra_1, R.drawable.michelle_1, R.drawable.ella_1, R.drawable.jomar_1, R.drawable.jazer_1, R.drawable.exe_4};
        String names[] = {"Joms","Zyra Marie Ramos", "Michelle Arroyo", "Ella Jane Espiritu", "Jomar Apalat", "Mher Jazer Alabalate", "Exequiel Arroyo"};

        RecyclerView recyclerView = viewGroup.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PostAdapter postAdapter = new PostAdapter(profiles, post, names);
        recyclerView.setAdapter(postAdapter);

        View view = viewGroup.findViewById(R.id.storyLinearLayout);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("name", "Ella Jane Espiritu");
                startActivity(intent);
            }
        });
        viewGroup.findViewById(R.id.storyLinearLayout2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("name", "Michelle Arroyo");
                startActivity(intent);
            }
        });
        viewGroup.findViewById(R.id.storyLinearLayout3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("name", "Zyra Marie Ramos");
                startActivity(intent);
            }
        });
        viewGroup.findViewById(R.id.storyLinearLayout4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("name", "Mher Jazer Alabalate");
                startActivity(intent);
            }
        });
        viewGroup.findViewById(R.id.storyLinearLayout5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("name", "Jomar Apalat");
                startActivity(intent);
            }
        });
        viewGroup.findViewById(R.id.storyLinearLayout6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("name", "Exequiel Arroyo");
                startActivity(intent);
            }
        });

        //++++++++++++++++++++++++++
        viewGroup.findViewById(R.id.updateProfileButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
                userName.setText(sp.getString("firstName", ""));
            }
        });

        viewGroup.findViewById(R.id.preferencesButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PreferencesActivity.class);
                startActivity(intent);
            }
        });

        viewGroup.findViewById(R.id.userNameTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserProfile.class);
                getActivity().startActivity(intent);
            }
        });

        return viewGroup;
    }
}