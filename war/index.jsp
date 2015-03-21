<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-xs-12">
		<a href="${pageContext.request.contextPath}/fuzzy/new" class="btn btn-primary pull-right">New Fuzzy System</a>
	</div>
</div>
<div class="row" style="margin-top: 10px;">
	<div class="col-xs-12">
		<div class="table-responsive">
        	<table class="table table-bordered">
          		<thead>
            		<tr>
              			<th class="col-md-1 text-center">#</th>
              			<th class="col-md-3">Name</th>
              			<th class="col-md-3">Inputs</th>
              			<th class="col-md-3">Outputs</th>
              			<th class="col-md-2 text-center">Options</th>
            		</tr>
          		</thead>
          		<tbody>
          			<tr>
          				<td>1</td>
          				<td>Infer the criticality of Java classes</td>
          				<td>[Importance, Coupling, Complexity]</td>
          				<td>[Criticality]</td>
          				<td>
          					<a class="btn btn-primary btn-xs" style="width: 48%;">Edit</a>
							<a class="btn btn-danger btn-xs" style="width: 48%;">Remove</a>
          				</td>
          			</tr>
          			<c:forEach var="system" items="${systems}">
	            		<tr>
	              			<td class="text-center">${system.id}</td>
	              			<td>${system.name}</td>
	              			<td>${system.inputs}</td>
	              			<td>${system.outputs}</td>
	              			<td>
	              				<a class="btn btn-primary btn-xs" style="width: 48%;">Edit</a>
								<a class="btn btn-danger btn-xs" style="width: 48%;">Remove</a>
	              			</td>
	            		</tr>
          			</c:forEach>
          			<!-- glyphicon glyphicon-transfer, glyphicon glyphicon-thumbs-up -->
          		</tbody>
        	</table>
      	</div>
	</div>
</div>

<div class="row">
	<div class="col-xs-6">
		<div class="panel panel-default">
		  	<div class="panel-heading">
		    	<h3 class="panel-title">Process Description</h3>
		  	</div>
		  	<div class="panel-body" style="text-align: justify;">
		    	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In venenatis quis dolor a auctor. Suspendisse lobortis magna lacus, sed porta nisl fermentum vitae. Pellentesque pulvinar hendrerit diam, non porttitor velit ullamcorper et. Vivamus dictum tempus lorem et scelerisque. Maecenas libero massa, scelerisque nec molestie vel, sodales eu lectus. Aliquam erat volutpat. Nulla ut eros eget arcu auctor pharetra. Maecenas fermentum gravida placerat. Phasellus vel nunc sed diam pulvinar sollicitudin. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam in ullamcorper eros, sit amet imperdiet orci. Donec ultricies aliquet aliquet. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
		    	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In venenatis quis dolor a auctor. Suspendisse lobortis magna lacus, sed porta nisl fermentum vitae. Pellentesque pulvinar hendrerit diam, non porttitor velit ullamcorper et. Vivamus dictum tempus lorem et scelerisque. Maecenas libero massa, scelerisque nec molestie vel, sodales eu lectus. Aliquam erat volutpat. Nulla ut eros eget arcu auctor pharetra. Maecenas fermentum gravida placerat.</p>
		  	</div>
		</div>
	</div>
	<div class="col-xs-6">
		<img src="${pageContext.request.contextPath}/img/FLS1.png" alt="Fuzzy Control System" class="img-thumbnail" style="height: 390px;">
	</div>
</div>