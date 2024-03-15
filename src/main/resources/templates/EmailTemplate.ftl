<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email Verification</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
        }
        .cover-photo {
            width: 100%;
            max-height: 200px;
            object-fit: cover;
        }
        .content {
            padding: 20px;
            text-align: center;
        }
        .dear{
            text-align: initial;
        }
        .verify-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            text-decoration: none;
            margin-top: 10px;
            border-radius: 25px;
        }
        .footer {
            background-color: #006994;
            padding: 10px;
            color: #fff;
            text-align: center;
        }
        .headBanner{
            color: #fff;
            text-align: center;
            background-color: #006994;
            font-size: xxx-large;
            padding: 1px;
            font-weight: bold;
            font-family: sans-serif;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="headBanner">
        <p>ZWIGGY</p>
    </div>
    <div class="content">
        <p class ="dear">Dear ${user},</p>
        <p>Thank you for signing up! Please click the link below to verify your email address:</p>
        <a href="[Verification Link]" class="verify-button">Verify Email</a>
        <p>If you didn't sign up for our service, you can safely ignore this email or contact us at suppor@zwiggy.com </p>
        <p>Best regards,<br>Team Zwiggy</p>
    </div>
    <div class="footer">
        <p>&copy; 2024 Zwiggy. All rights reserved.</p>
    </div>
</div>
</body>
</html>
<#--   <img class="cover-photo" src="src/main/resources/templates/EmailBanner.jpg" alt="Cover Photo">-->
