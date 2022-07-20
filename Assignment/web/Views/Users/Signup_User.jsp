<%-- 
    Document   : Signup_User
    Created on : Jun 8, 2022, 9:53:31 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up For Shop</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/signup.css">
    </head>
    <body>
        <div class="main">     
            <div class="container">
                <div class="sign-up-content">
                    <h1>Sign up for user</h1>
                    <form method="POST" class="signup-form">
                        <div class="form-textbox ">
                            <label for="fullname">Full name</label>
                            <input type="text" name="fullname" id="fullname" required/>
                        </div>

                        <div class="form-textbox ">
                            <label for="phonenumber">Phone Number</label>
                            <input type="text" name="phonenumber" id="phonenumber" required/>
                        </div>

                        <div class="form-textbox gender">
                            <label for="email">Gender</label>
                            <input type="radio" name="female" value="f"/>
                            <label for="female">Female</label>
                            <input type="radio" name="male" value="m"/>
                            <label for="male">Male</label>
                        </div>

                        <div class="form-textbox">
                            <label for="dob">Date of birth</label>
                            <input type="date" name="dob" id="dob" required/>
                        </div>

                        <div class="form-textbox">
                            <label for="job">Job</label>
                            <input type="text" name="job" id="job" required/>
                        </div>

                        <div class="form-textbox">
                            <label for="studentId">Student ID</label>
                            <input type="text" name="studentId" id="studentId" />
                        </div>
                        <div class="form-textbox">
                            <label for="address">Address</label>
                            <input type="text" name="address" id="address" required/>
                        </div>
                        <div class="form-textbox">
                            <input type="submit" name="submit" id="submit" class="submit" value="Create account" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
