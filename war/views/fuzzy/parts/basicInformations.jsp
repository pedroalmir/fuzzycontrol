<h2 class="">Basic Informations</h2><hr>
<div id="stepform">
	<div class="row">
		<div class="col-xs-4">
			<div class="form-group" style="text-align: left !important;">
				<label for="fuzzyControlName">Fuzzy Control Name*</label>
				<input type="text" class="form-control" id="fuzzyControlName" name="fuzzyControlName" placeholder="Enter Fuzzy Control Name">
			</div>
		</div>
		<div class="col-xs-8">
			<div class="form-group" style="text-align: left !important;">
				<label for="fuzzyControlDescription">Fuzzy Control Description</label>
				<input type="text" class="form-control" name="fuzzyControlDescription" id="fuzzyControlDescription" placeholder="Enter Fuzzy Control Description">
			</div>
		</div>
	</div>
	<br/><hr><br/>
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-3">
				</div>
				<div class="col-xs-6">
					<h4>List of Function Blocks</h4>
				</div>
				<div class="col-xs-3">
					<button type="button" id="defineFunctionBlocks" class="btn btn-default" style="width: 100%;">
			  			Add Function Blocks <span class="glyphicon glyphicon-plus"></span>
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
	              			<th class="col-md-2">Name</th>
	              			<th class="col-md-4">Inputs</th>
	              			<th class="col-md-4">Ouputs</th>
	              			<th class="col-md-2">Options</th>
	            		</tr>
	          		</thead>
	          		<tbody id="functionBlocksTableBody">
	          		</tbody>
	        	</table>
	      	</div>
		</div>
	</div>
</div>
<br/>
<br/>
<div id="footer" class="fieldset-footer">
<button type="button" id="cancelStepBasicInformation" class="btn btn-default" style="width: 216px;">
	Cancel <span class="glyphicon glyphicon-remove"></span>
</button>
<button type="button" id="gotoRulesDefinition" class="next btn btn-primary" style="width: 216px;">
	Define Rules <span class="glyphicon glyphicon-chevron-right"></span>
</button>
</div>