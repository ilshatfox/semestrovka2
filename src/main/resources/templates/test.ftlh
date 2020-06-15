<#import "/spring.ftl" as spring/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Document</title>
</head>
<body>
<@spring.bind "user"/>
<form action="/signUp" method="post">
    Login:
    <br>
    <@spring.formInput"user.login"/>
    <@spring.showErrors"<br>"/>

    <br>
    Password:
    <br>
    <@spring.formPasswordInput"user.password"/>
    <@spring.showErrors"<br>"/>

    <br>
    Repeat password:
    <br>
    <@spring.formPasswordInput"user.passwordRepeat"/>
    <@spring.showErrors"<br>"/>

    <br>
    <input type="submit" value="Ok">
</form>

</body>
</html>