<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Traffic
     Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Violations</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Violations</h3>
                    <hr>
                    <div class="container text-left">
<!--
                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Violation</a>
     -->
     
     <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        
                        <form action="checkStatus" method="post">
                        <caption>
                            <h2>
                                    Check City Status
                            </h2>
                        </caption>

                        <fieldset class="form-group">
                            <label>Country</label> <input type="text" value="" class="form-control" name="country" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>City</label> <input type="text" value="" class="form-control" name="city" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Violation</label> 
                            <select name="violation">
                                <option value="red light crossing">red light crossing</option>
                                <option value="running a stop sign">running a stop sign</option>
                                <option value="jaywalking">jaywalking</option>
                                <option value="littering">littering</option>
                            </select>
                        </fieldset>
                        <button type="submit" class="btn btn-success">Check</button>
                        </form>
                    </div>
                </div>
            </div>
     
   <!--
     red light crossing
running a stop sign
jaywalking
littering
     -->
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>phone</th>
                                <th>country</th>
                                <th>city</th>
                                <th>picture_video</th>
                                <th>violation_type </th>
                                <th>is_approved</th>
                                <th>is_expired</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="violation" items="${listViolation}">

                                <tr>
                                    <td>
                                        <c:out value="${violation.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${violation.phone}" />
                                    </td>
                                    <td>
                                        <c:out value="${violation.country}" />
                                    </td>
                                    <td>
                                        <c:out value="${violation.city}" />
                                    </td>
                                    <td>
                                        <c:out value="${violation.pictureVideo}" />
                                    </td>
                                    <td>
                                        <c:out value="${violation.violationType}" />
                                    </td>
                                    <td>
                                        <c:out value="${violation.isApproved}" />
                                    </td>
                                    <td>
                                        <c:out value="${violation.isExpired}" />
                                    </td>
                                   
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>