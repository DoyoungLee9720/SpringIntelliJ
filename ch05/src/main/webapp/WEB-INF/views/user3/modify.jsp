<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User3::register</title>
</head>
<body>
<h3>User1 목록</h3>
<a href="/ch05/">처음으로</a>
<a href="/ch05/user3/list">목록</a>

<form action="/ch05/user3/modify" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid" value="${user3DTO.uid}" readonly></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="${user3DTO.name}"></td>
        </tr>
        <tr>
            <td>생년월일</td>
            <td><input type="date" name="birth" value="${user3DTO.birth}"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="hp" value="${user3DTO.hp}"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr" value="${user3DTO.addr}"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="등록하기"/>
            </td>

        </tr>
    </table>
</form>
</body>
</html>