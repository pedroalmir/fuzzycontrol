<h2 class="">Define Function Blocks</h2><hr>
<div id="stepform">
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group" style="text-align: left !important;">
				<label for="functionBlockName">Function Block Name*</label>
				<input type="text" class="form-control" id="functionBlockName" name="functionBlockName" placeholder="Enter Function Block Name">
			</div>
		</div>
		<div class="col-xs-7">
			<div class="form-group" style="text-align: left !important;">
				<label for="functionBlockDescription">Function Block Description</label>
				<input type="text" class="form-control" id="functionBlockDescription" name="functionBlockDescription" placeholder="Enter Function Block Description">
			</div>
		</div>
	</div>
	
	<br/><hr><br/>
	
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-2">
				</div>
				<div class="col-xs-8">
					<h4>List of Inputs</h4>
				</div>
				<div class="col-xs-2">
					<button type="button" id="addInputsVariables" class="btn btn-default" style="width: 100%;">
			  			Add Input <span class="glyphicon glyphicon-plus"></span>
					</button>
				</div>
			</div>
		</div>
		<div class="col-xs-12">
			<div class="table-responsive">
	        	<table class="table table-bordered">
	          		<thead>
	            		<tr>
	              			<th>#</th>
	              			<th class="col-md-3">Name</th>
	              			<th class="col-md-2">Type</th>
	              			<th class="col-md-5">Terms</th>
	              			<th class="col-md-2">Options</th>
	            		</tr>
	          		</thead>
	          		<tbody id="functionBlockInputTableBody">
	          		</tbody>
	        	</table>
	      	</div>
		</div>
	</div>
	
	<br/><hr><br/>
	
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-2">
				</div>
				<div class="col-xs-8">
					<h4>List of Outputs</h4>
				</div>
				<div class="col-xs-2">
					<button type="button" id="addOutputsVariables" class="btn btn-default" style="width: 100%;">
			  			Add Output <span class="glyphicon glyphicon-plus"></span>
					</button>
				</div>
			</div>
		</div>
		<div class="col-xs-12">
			<div class="table-responsive">
	        	<table class="table table-bordered">
	          		<thead>
	            		<tr>
	              			<th>#</th>
	              			<th class="col-md-4">Name</th>
	              			<th class="col-md-2">Type</th>
	              			<th class="col-md-2">Default</th>
	              			<th class="col-md-2">Defuzzification</th>
	              			<th class="col-md-2">Options</th>
	            		</tr>
	          		</thead>
	          		<tbody id="functionBlockOutputTableBody">
	          		</tbody>
	        	</table>
	      	</div>
		</div>
	</div>
</div>
<br/>
<br/>
<div id="footer" class="fieldset-footer">
<button type="button" id="cancelFunctionBlockDefinition" class="next btn btn-default" style="width: 211px;">
	Back <span class="glyphicon glyphicon-remove"></span>
</button>
<button type="button" id="saveFunctionBlock" class="btn btn-success" style="width: 211px;">
	Save <span class="glyphicon glyphicon-ok"></span>
</button>
</div>