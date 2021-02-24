<!--
JSP는 JSP 자체가 동작하는 것이 아닌  
모든 JSP는 Servlet으로 바뀌어 동작한다.
지시자는 Servlet으로 어떻게 바뀌어얀하는 것을 알려주기 위함니다. 
 --> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sum10</title>
</head>
<body>
<!-- 스크립트리: 자바 코드를 넣을 수 있는 부분  -->
<% 
    int total = 0;
    for(int i = 1; i <= 10; i++){
        total = total + i;
    }
%>
<!-- %= 표현식이라고 한다.  -->

1부터 10까지의 합 : <%=total %>
<!-- 이 JSP가 서블릿으로 바뀔 때 어떻게 바뀔까? 룰 생각하면 좋다. -->


</body>
</html>