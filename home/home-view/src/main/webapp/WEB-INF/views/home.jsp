<html>
    <head>
        <title>Dr.Who</title>
        <style>
            body {
                background-color: black;
                text-align: center;
                color: white;
            }
        </style>
    </head>
    <body>
        <form action="/popcorn/showServices" method="post">
            Enter your username
            <input type="text" name="userName" />
            <input type="submit" value="Get me thru!!!" />
        </form>
        </br>
        ${message}
    </body>
</html>