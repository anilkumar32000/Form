<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
<meta charset="ISO-8859-1">
<title>Student Form</title>
<link href="css/1.css"
        rel="stylesheet">
<script src="http:////code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">

	$(document).ready(function(){});
		function formsubmission(){
			var name=$('#name1').val();
			var age=$('#age1').val();
			var branch=$('#branch1').val();
			var data={};
			data["name"]=name;
			data["age"]=age;
			data["branch"]=branch;
		    
			var tempname=name;
			tempname=tempname.split(" ").join("");
			var count=0;
			var letters= /^[A-Za-z]+$/
			if(name.match(letters)){
				count++;
			}
			else{
				alert("Name should only contain alphabets");
			}
			if(age>=16 && age<=25){
				count++;
			}
			else{
				alert("Age should be in the range 16 to 25");
			}
			if(count == 2){
			$.ajax({
				contentType:'application/json; charset=utf-8',
				type:'POST',
				url:'/submitForm',
				dataType :'json',
				data:JSON.stringify(data),
				success: function(callback){
					console.log("Response: Name: "+callback.status + "Message:" + callback.message);
					/* console.log("Response: Age: "+callback.age);
					console.log("Response: Branch: "+callback.branch); */
					$(this).html("callback.message");
				},
				error : function(){
					console.log("error");
				$(this).html("Error!");
				}
			});
			}
		}
		
</script>
</head>
<body>
	
  <div class="form">
  <div class="mail"></div>
  <h1>Student form</h1>
  <form action="">
        <input type="text" placeholder="Student Name" name="name" id="name1"><br>
		<input type="number" placeholder="Student Age" name="age" id="age1"><br>
		<input type="text" placeholder="Student Branch" name="branch" id="branch1"><br>
		<input type="button" id="submitId" class="submit" value="submit" id="addstudent" onclick="formsubmission();" > 
  </form>
  <script src="js/2.js"></script>
</div>
<div class="ok_message">
<span>Details submitted successfully!</span>
<script src="js/2.js"></script></div>

</body>
</html>