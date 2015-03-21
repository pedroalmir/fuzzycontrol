<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-xs-12">
		<a href="${pageContext.request.contextPath}/fuzzy/new" class="btn btn-primary pull-right">New Fuzzy Adjustment</a>
	</div>
</div>

<div class="col-xs-12" style="margin-top: 10px;">
		<div class="table-responsive">
        	<table class="table table-bordered">
          		<thead>
            		<tr>
              			<th>#</th>
              			<th class="col-md-2">System Name</th>
              			<th class="col-md-1">Accuracy</th>
              			<th class="col-md-2">Sample Size</th>
              			<th class="col-md-2">Ant Number</th>
              			<th class="col-md-1">Iterations</th>
              			<th class="col-md-1">Alpha</th>
              			<th class="col-md-1">Evaporation</th>
              			<th class="">Options</th>
            		</tr>
          		</thead>
          		<tbody>
            		<tr>
              			<td><span class="glyphicon glyphicon-refresh"></span></td>
              			<td>${model.name}</td>
              			<td>${model.accuracy}</td>
              			<td>${model.sampleSize}</td>
              			<td>${model.antNumber}</td>
              			<td>${model.iterations}</td>
              			<td>${model.alpha}</td>
              			<td>${model.evaporationRate}</td>
              			<td></td>
            		</tr>
          		</tbody>
        	</table>
      	</div>
	</div>

<div class="row" style="padding: 0px 15px">
	<div class="col-xs-6">
		<div class="panel panel-primary" style="height: 325px;">
        	<div class="panel-heading">
          		<h3 class="panel-title">Graph</h3>
        	</div>
        	<div class="panel-body">
        		<div id="donut" style="height: 250px;">
        		</div>
        	</div>
      	</div>
	</div>
	<div class="col-xs-6">
		<div class="panel panel-primary" style="height: 325px;">
        	<div class="panel-heading">
          		<h3 class="panel-title">Results</h3>
        	</div>
        	<div class="panel-body">
        		<div class="table-responsive">
		        	<table class="table table-bordered">
		        		<thead>
		            		<tr>
		              			<th>#</th>
		              			<th class="col-md-4">Quality</th>
		              			<th class="col-md-7">FCL</th>
		            		</tr>
		          		</thead>
		          		<tbody>
		          			<c:forEach var="result" items="${results}">
			            		<tr>
			              			<td>${result.id}</td>
			              			<td>${result.quality}</td>
			              			<td><a href="#" class="btn btn-success btn-xs fcl" target="#fcl${result.id}">Click here to see FCL</a></td>
			            		</tr>
		          			</c:forEach>
		          			<!-- glyphicon glyphicon-transfer, glyphicon glyphicon-thumbs-up -->
		          		</tbody>
		        	</table>
		      	</div>
        	</div>
      	</div>
	</div>
	<c:forEach var="result" items="${results}">
		<!-- Modal -->
		<div id="fcl${result.id}" class="row fcl_description" style="padding: 0px 15px; display: none;">
			<div class="col-xs-12">
				<div class="panel panel-primary">
		        	<div class="panel-heading">
		          		<h3 class="panel-title">Fuzzy Control Language</h3>
		        	</div>
		        	<div class="panel-body">
		        		${result.fcl}
		        	</div>
		      	</div>
			</div>
		</div>
		
		<div class="modal fade" id="fcl${result.id}" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  	<div class="modal-dialog modal-lg">
		    	<div class="modal-content">
		      		<div class="modal-header">
		        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        		<h4 class="modal-title" id="myModalLabel">Fuzzy Control Language</h4>
		      		</div>
				    <div class="modal-body">
				    	${result.fcl}
				    </div>
		      		<div class="modal-footer">
		        		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      		</div>
		    	</div>
		  	</div>
		</div>
	</c:forEach>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$(".fcl").click(function(e) {
			e.preventDefault();
			$(".fcl_description").each(function(index){
				$(this).hide();
			});
			
		   	var target = $(this).attr("target");
		   	$(target).show("slow","swing");
		});
		
		/*
		 * Play with this code and it'll update in the panel opposite.
		 *
		 * Why not try some of the options above?
		 */
		Morris.Donut({
		  element: 'donut',
		  data: [
		    {label: "Download Sales", value: 12},
		    {label: "In-Store Sales", value: 30},
		    {label: "Mail-Order Sales", value: 20}
		  ]
		});

	});
</script>