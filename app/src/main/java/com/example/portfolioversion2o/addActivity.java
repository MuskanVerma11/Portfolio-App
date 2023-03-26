package com.example.portfolioversion2o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;

import com.example.portfolioversion2o.model.Course;
import com.example.portfolioversion2o.model.Education;
import com.example.portfolioversion2o.model.Portfolio;

public class addActivity extends AppCompatActivity {

    public static final String MV_Portfolio2="mv_portfolio2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void submitData(View view){
        EditText editName=findViewById(R.id.editName);
        EditText editPosition=findViewById(R.id.editPosition);
        EditText editCollege=findViewById(R.id.editCollege);
        EditText editDegree=findViewById(R.id.editDegree);
        EditText editYear=findViewById(R.id.editYear);
        EditText editCourse=findViewById(R.id.editCourse);
        EditText editOrganization=findViewById(R.id.editOrganization);
        EditText editYear1=findViewById(R.id.editYear1);
        EditText editGitHubUsername=findViewById(R.id.editGithub);

        if(editName.getText().toString().isEmpty() || editPosition.getText().toString().isEmpty() || editCollege.getText().toString().isEmpty() || editDegree.getText().toString().isEmpty() || editYear.getText().toString().isEmpty() || editCourse.getText().toString().isEmpty() || editOrganization.getText().toString().isEmpty() || editYear1.getText().toString().isEmpty() || editGitHubUsername.getText().toString().isEmpty()){
            if(editName.getText().toString()==null || editName.getText().toString().isEmpty()){
            editName.setError("Valid Name Mandatory");
            editName.requestFocus();
                }
            if(editPosition.getText().toString()==null || editPosition.getText().toString().isEmpty()){
                editPosition.setError("Please Enter Your Position");
                editPosition.requestFocus();
                }
            if(editCollege.getText().toString()==null || editCollege.getText().toString().isEmpty()){
                editCollege.setError("Please Enter Your College Name");
                editCollege.requestFocus();
            }
            if(editDegree.getText().toString()==null || editDegree.getText().toString().isEmpty()){
                editDegree.setError("Please Enter Your Degree");
                editDegree.requestFocus();
            }
            if(editYear.getText().toString()==null || editYear.getText().toString().isEmpty()){
                editYear.setError("Please Enter Year");
                editYear.requestFocus();
            }
            if(editCourse.getText().toString()==null || editCourse.getText().toString().isEmpty()){
                editCourse.setError("Please Enter Course Name");
                editCourse.requestFocus();
            }
            if(editOrganization.getText().toString()==null || editOrganization.getText().toString().isEmpty()){
                editOrganization.setError("Please Enter Organization Name");
                editOrganization.requestFocus();
            }
            if(editYear1.getText().toString()==null || editYear1.getText().toString().isEmpty()){
                editYear1.setError("Please Enter year");
                editYear1.requestFocus();
            }
            if(editGitHubUsername.getText().toString()==null || editGitHubUsername.getText().toString().isEmpty()){
                editGitHubUsername.setError("Please Enter a valid GitHub Username");
                editGitHubUsername.requestFocus();
            }
            }
                else{
            Education education=new Education(editCollege.getText().toString(), editDegree.getText().toString(), editYear.getText().toString());

            Course course=new Course(editCourse.getText().toString(), editOrganization.getText().toString(), editYear1.getText().toString());

            Portfolio portfolio=new Portfolio(editName.getText().toString(), editPosition.getText().toString(), education, course, editGitHubUsername.getText().toString());

            Intent intent=new Intent();
            intent.putExtra(MV_Portfolio2, portfolio);
            setResult(RESULT_OK,intent);
            finish();
            }
        }

}