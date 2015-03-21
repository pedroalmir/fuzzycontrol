<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<form role="form" action="${pageContext.request.contextPath}/fuzzy/new" method="post" enctype="multipart/form-data">
	<div class="row">
		<div class="col-xs-6">
			<div class="panel panel-primary">
	        	<div class="panel-heading">
	          		<h3 class="panel-title">Basic Settings</h3>
	        	</div>
	        	<div class="panel-body">
		  			<div class="form-group">
		    			<label for="fuzzyAdjsName">Fuzzy Adjs. Name</label>
		    			<input type="text" class="form-control" id="fuzzyAdjsName" placeholder="Enter a value for name" name="name">
		  			</div>
		  			<div class="form-group">
		    			<label for="email">Email</label>
		    			<input type="email" class="form-control" id="email" placeholder="Enter your email address" name="email">
		  			</div>
		  			<div class="form-group">
		    			<label for="accuracy">Accuracy (Stop Condition)</label>
		    			<input type="text" class="form-control" id="accuracy" placeholder="Accuracy [0..1]" name="accuracy">
		  			</div>
		  			<div class="form-group">
		    			<label for="sampleSize">Sample size (%)</label>
		    			<input type="text" class="form-control" id="sampleSize" placeholder="Sample size [0..1]" name="sampleSize">
		  			</div>
		  			<div class="form-group">
		    			<label for="sampleSize">Fuzzy Output Variable</label>
		    			<input type="text" class="form-control" id="outputVariable" placeholder="Fuzzy Output Variable" name="outputVariable">
		  			</div>
		  			<div class="form-group">
		    			<label for="fclInputFile">FCL Input</label>
		    			<input type="file" id="fclInputFile" name="fclInputFile">
		    			<p class="help-block">FCL File</p>
		  			</div>
	        	</div>
	      	</div>
		</div>
		<div class="col-xs-6">
			<div class="panel panel-primary">
	        	<div class="panel-heading">
	          		<h3 class="panel-title">Ant Colony Optimization Settings</h3>
	        	</div>
	        	<div class="panel-body">
		  			<div class="form-group">
		    			<label for="antNumber">Ant Number</label>
		    			<input type="number" class="form-control" id="antNumber" placeholder="Enter a Ant Number" name="antNumber">
		  			</div>
		  			<div class="form-group">
		    			<label for="iterations">Iterations</label>
		    			<input type="number" class="form-control" id="iterations" placeholder="Enter a Iterations Number" name="iterations">
		  			</div>
		  			<div class="form-group">
		    			<label for="iterations">Executions</label>
		    			<input type="number" class="form-control" id="executions" placeholder="Enter a Executions Number" name="executions">
		  			</div>
		  			<div class="form-group">
		    			<label for="alpha">Alpha</label>
		    			<input type="text" class="form-control" id="alpha" placeholder="Enter a Alpha Value" name="alpha">
		  			</div>
		  			<div class="form-group">
		    			<label for="evaporationRate">Evaporation Rate</label>
		    			<input type="text" class="form-control" id="evaporationRate" placeholder="Enter a Evaporation Rate" name="evaporationRate">
		  			</div>
		  			<div class="form-group">
		    			<label for="csvInputFile">CSV Input</label>
		    			<input type="file" id="csvInputFile" name="csvInputFile">
		    			<p class="help-block">CSV File with data to apply in Fuzzy System</p>
		  			</div>
	        	</div>
	      	</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<button type="submit" class="btn btn-default pull-right col-xs-3">Submit</button>
		</div>
	</div>
</form>