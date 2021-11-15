<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

 	
	<h1>Dear ${User123} Welcome to my Glasses Store</h1>
	

	<a href="/add-glass"> <b>Add new Glass</b></a>
	<hr>
		
		<table class="table table-striped">
			<thead>
					<tr>
					 
						<th scope="col">Image</b></th>
						<th scope="col">Year</b></th>
						<th scope="col">Make</b></th>
						<th scope="col">Model</b></th>
						<th scope="col">Update</b></th>
						<th scope="col">Remove Glass</b></th>
						
					</tr>
			</thead>
			<tbody>
			<c:forEach items="${glasses}" var="glass">
				<tr>
					<td  ><img src = "${glass.image}" width="100" height="100" /></td>
					<td  >${glass.year}</td>
					<td  >${glass.make}</td>
					<td  >${glass.model}</td>
					<td><b>&nbsp; &nbsp;
     <a href="/update-glass?id=${glass.id}">Update</a>&nbsp;</b></td>
					<td><b>&nbsp; &nbsp;
     <a href="/delete-glass?id=${glass.id}">Delete</a></b></td>
				</tr>
			</c:forEach>	
			</tbody>
			
			
		</table>
		
<%@ include file="common/footer.jspf"%>
