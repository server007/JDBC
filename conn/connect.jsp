<%@ taglib  uri="my" prefix="MyTag" %>
<html>
<body>
<MyTag:Connection drivername="com.mysql.jdbc.Driver" driverURL="jdbc:mysql://localhost:3306/table?autoReconnect=true&useSSL=false"/>
<MyTag:Database tablename="tab"/>
</body>
</html>