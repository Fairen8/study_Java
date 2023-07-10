<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Java Web Site</title>
</head>
<body>
    <h1>Форма добавления</h1>
    <form action="check" method="post">
        <input type="text" placeholder="Введите имя" name="item_name"><br>
        <input type="number" placeholder="Введите цену" name="price"><br>
        <input type="text" placeholder="Введите текст" name="info"><br>
        <button type="submit">Добавить</button>
    </form>
</body>
</html>
