<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
참고 : 출력 결과를 JSP파일로 사용하고 싶을때 사용하는 방법 ! : View page 생성하기
1. pom.xml 변경 아래와 같이 dependency(라이브러리 추가) 
// jsp
<dependency>
	<groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>   
</dependency>

<dependency>
     <groupId>org.apache.tomcat.embed</groupId>
     <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
2. JSP 파일 처리를 위해 아래와 같은 폴더를 만들 것 
main
	webapp
		WEB-INF
			views - list.jsp
3.다음으로 resources/application.properties 파일에 아래와 같은 내용을 추가한다. 
application.properites 파일 수정 *띄어쓰기 주의*
server.port = 80
spring.mvc.view.prefix = /WEB-INF/views/       
spring.mvc.view.suffix = .jsp
4.jsp 파일 사용을 위한 웹 관련 설정 작업을 한 후에는 클라이언트를 통해 호출할 html이나 
jsp 파일은 webapp 폴더에 작성해서 실행하면 된다.

-->

결과는 ${msg}<br>
결과는 ${requestScope.msg}<br>
<%
String ss = (String)request.getAttribute("msg");
out.println("결과는 " + ss);
%>
</body>
</html>