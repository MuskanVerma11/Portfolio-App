package com.example.portfolioversion2o;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.portfolioversion2o.model.Portfolio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_CODE=1117;
    private static final String TAG="MainActivity";
    private String githubUsername=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addDetails(View view) {
        Intent intent=new Intent(MainActivity.this, addActivity.class);
        startActivityForResult(intent,REQUEST_CODE);
    }


    public void openGitHub(View view) {
        String gitHubURL="https://github.com/";
        if(githubUsername!=null){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(gitHubURL+githubUsername));
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Not a Valid GitHub Username", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==REQUEST_CODE && resultCode==RESULT_OK && data!=null){
                Portfolio portfolio=data.getParcelableExtra(addActivity.MV_Portfolio2);
                if(portfolio!=null){
                setDetails(portfolio);
                }
            }
    }

    private void setDetails(Portfolio portfolio) {
        TextView Name=findViewById(R.id.name);
        TextView Position=findViewById(R.id.position);
        TextView College=findViewById(R.id.collegeName);
        TextView Degree=findViewById(R.id.branch);
        TextView Year=findViewById(R.id.year);
        TextView Course=findViewById(R.id.course1);
        TextView Organization=findViewById(R.id.organization);
        TextView Year2=findViewById(R.id.year2);

        Name.setText(portfolio.getName());
        Position.setText(portfolio.getPosition());
        College.setText(portfolio.getEducation().getCollegeName());
        Degree.setText(portfolio.getEducation().getDegree());
        Year.setText(portfolio.getEducation().getYear());
        Course.setText(portfolio.getCourse().getCourse());
        Organization.setText(portfolio.getCourse().getOrganization());
        Year2.setText(portfolio.getCourse().getYear1());

        githubUsername=portfolio.getGitHubUserName();
    }
}