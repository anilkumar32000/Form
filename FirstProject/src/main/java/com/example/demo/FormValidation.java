package com.example.demo;

import org.springframework.stereotype.Service;

import com.example.demo.controller.StudentForm1;


@Service
public class FormValidation {
	public StudentForm1 validate(String studentname, int studentage) {
	  StudentForm1 studentform =new StudentForm1();
	  if(studentname == null) {
		  studentform.setStatus("Fail");
		  studentform.setMessage("Name can't be blank");
		  return studentform;
	  }
	  else {
		  studentname = studentname.replaceAll(" ", "");
		  studentname = studentname.toLowerCase();
          char[] charArray = studentname.toCharArray();
          for(int i=0; i< charArray.length; i++) {
    	  char ch= charArray[i];
    	  if(!(ch>='a' && ch<='z')) {
    		  studentform.setStatus("Fail");
    		  studentform.setMessage("Name should contain only alphabets");
    		  return studentform;
    	  }
          }
      }
      if(studentage<16 && studentage>25) {
    	  studentform.setStatus("Fail");
	      studentform.setMessage("Age should be between 16 to 25");
	      return studentform;
      }
      studentform.setStatus("Pass");
      studentform.setMessage("Age should be between 16 to 25");
      return studentform;
	}
}
