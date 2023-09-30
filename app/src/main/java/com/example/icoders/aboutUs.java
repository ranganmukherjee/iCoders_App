package com.example.icoders;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class aboutUs extends AppCompatActivity {

    private TextView aboutText, collapse, goalText;
    private boolean sw;
    private RecyclerView profile;
    private ArrayList<profileModel> arrProfile=new ArrayList<>();


    private void addData()
    {
        arrProfile.add(new profileModel(R.mipmap.souravjanaface, "Sourav Jana", "President"));
        arrProfile.add(new profileModel(R.mipmap.ranganmukherjeeface, "Rangan Mukherjee", "Secretary"));
        arrProfile.add(new profileModel(R.mipmap.sanskarkeshriface, "Sanskar Keshri", "Event Manager"));
        arrProfile.add(new profileModel(R.mipmap.rahulsinhaface, "Rahul Sinha", "Treasurer"));
        arrProfile.add(new profileModel(R.mipmap.abhishekface, "Abhishek Dasgupta", "Startup Coordinator"));
        arrProfile.add(new profileModel(R.mipmap.dollykumariface, "Dolly Kumari", "Project Coordinator"));
        arrProfile.add(new profileModel(R.mipmap.subhojitgoraiface, "Subhojit Gorai", "PR Manager"));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        aboutText=findViewById(R.id.aboutText);
        collapse=findViewById(R.id.collapse);
        goalText=findViewById(R.id.goalText);
        profile=findViewById(R.id.profile);
        sw=true;
        String about=getString(R.string.about);
        String rm="Read More";
        String col="Collapse";
        String goals=getString(R.string.bullet_list);
        
        aboutText.setText(about.substring(0, 123));
        collapse.setText(rm);
        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw)
                {
                    aboutText.setText(about);
                    collapse.setText(col);
                    sw=false;
                }
                else
                {
                    aboutText.setText(about.substring(0, 122));
                    collapse.setText(rm);
                    sw=true;
                }
            }
        });

        goalText.setText(Html.fromHtml(goals, Html.FROM_HTML_MODE_COMPACT));

//        profile.setNestedScrollingEnabled(false);
        profile.setLayoutManager(new LinearLayoutManager(this));
        addData();
        recyclerProfileAdapter adapter=new recyclerProfileAdapter(this, arrProfile);
        profile.setAdapter(adapter);


    }
}