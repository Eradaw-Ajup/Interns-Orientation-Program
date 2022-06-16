<%-- 
    Document   : result
    Created on : 16 Jun, 2022, 12:01:33 AM
    Author     : pujawadare
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Download Link</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1>Download</h1>
            <p>Click the link to download the txt file.</p>
        </div>
        <div align="center">
        <a href="${file}" download>Click Here to download the generated FILE.
            ${file} ${data}
        </a>
        </div>
    </body>
</html>
