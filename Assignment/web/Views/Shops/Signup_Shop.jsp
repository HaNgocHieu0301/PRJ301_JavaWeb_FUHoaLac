<%-- 
    Document   : Signup_Shop
    Created on : Jun 8, 2022, 9:53:40 PM
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
        <link rel="stylesheet" href="/Assignment/Views/css/signup.css">
    </head>
    <body>
        <div class="main">     
            <div class="container">
                <div class="sign-up-content">
                    <h1>Sign up for shop</h1>
                    <form method="POST" class="signup-form">
                        <div class="form-textbox ">
                            <label for="fullname">Full name</label>
                            <input type="text" name="fullname" id="fullname" required/>
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
                        
                        <div class="form-textbox ">
                            <label for="phonenumber">Phone Number</label>
                            <input type="number" name="phoneNumber" id="phoneNumber" required/>
                        </div>
                        
                        <div class="form-textbox">
                            <label for="citizenId">Citizen ID</label>
                            <input type="text" name="citizenId" id="citizenId" required/>
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
