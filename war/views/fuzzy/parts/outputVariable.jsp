<h2 class="">Define Output Variables</h2><hr>
<div id="stepform">
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group" style="text-align: left !important;">
				<label for="linguisticVariableNameOutput">Name</label>
				<input type="text" class="form-control" id="linguisticVariableNameOutput" name="linguisticVariableNameOutput" placeholder="Enter Linguistic Variable Name">
			</div>
			
			<div class="form-group" style="text-align: left !important;">
				<label for="linguisticVariableDescriptionOutput">Description</label>
				<input type="text" class="form-control" id="linguisticVariableDescriptionOutput" name="linguisticVariableDescriptionOutput" placeholder="Enter Linguistic Variable Descrption">
			</div>
			
			<div class="form-group" style="text-align: left !important;">
				<label for="linguisticVariableTypeOutput">Linguistic Variable Type</label>
				<select class="form-control" name="linguisticVariableTypeOutput" id="linguisticVariableTypeOutput">
				  	<option>Real</option>
				  	<option>Integer</option>
				</select>
			</div>
		</div>
		<div class="col-xs-6">
			<div class="form-group" style="text-align: left !important;">
				<label for="defuzzificationMethod">Defuzzification Method</label>
				<select class="form-control" name="defuzzificationMethod" id="defuzzificationMethod">
				  	<option value="COG">COG - Center of Gravity</option>
				  	<option value="COGs">COGs - Center of Gravity from Singletons</option>
				  	<option value="COA">COA - Center of Area</option>
				  	<option value="LM">LM - Left Most Maximum</option>
				  	<option value="RM">RM - Right Most Maximum</option>
				</select>
			</div>
			
			<div class="form-group" style="text-align: left !important;">
				<label for="defaultValue">Default Value</label>
				<input type="text" class="form-control" id="defaultValue" name="defaultValue">
			</div>
		</div>
	</div>
	<br/>
</div>

<jsp:include page="${pageContext.request.contextPath}/views/fuzzy/parts/linguisticTermOutput.jsp"></jsp:include>

<br/>

<div id="footer" class="fieldset-footer">
<button type="button" id="cancelOutputVariable" class="btn btn-default" style="width: 211px;">
	Back <span class="glyphicon glyphicon-remove"></span>
</button>
<button type="button" id="saveOutputVariable" class="btn btn-success" style="width: 211px;">
	Save <span class="glyphicon glyphicon-ok"></span>
</button>
</div>