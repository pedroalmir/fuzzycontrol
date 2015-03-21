<h2 class="">Define Input Variables</h2><hr>
<div id="stepform">
	<div class="row">
		<div class="col-xs-4">
			<div class="form-group" style="text-align: left !important;">
				<label for="linguisticVariableNameInput">Name</label>
				<input type="text" class="form-control" id="linguisticVariableNameInput" name="linguisticVariableNameInput" placeholder="Enter Linguistic Variable Name">
			</div>
		</div>
		<div class="col-xs-5">
			<div class="form-group" style="text-align: left !important;">
				<label for="linguisticVariableDescriptionInput">Description</label>
				<input type="text" class="form-control" id="linguisticVariableDescriptionInput" name="linguisticVariableDescriptionInput" placeholder="Enter Linguistic Variable Descrption">
			</div>
		</div>
		<div class="col-xs-3">
			<div class="form-group" style="text-align: left !important;">
				<label for="linguisticVariableTypeInput">Linguistic Variable Type</label>
				<select class="form-control" name="linguisticVariableTypeInput" id="linguisticVariableTypeInput">
				  	<option value="real">Real</option>
				  	<option value="int">Integer</option>
				</select>
			</div>
		</div>
	</div>
	<br/>
</div>

<jsp:include page="${pageContext.request.contextPath}/views/fuzzy/parts/linguisticTermInput.jsp"></jsp:include>
<br/>

<div id="footer" class="fieldset-footer">
<button type="button" id="cancelInputVariable" class="btn btn-default" style="width: 211px;">
	Back <span class="glyphicon glyphicon-remove"></span>
</button>
<button type="button" id="saveInputVariable" class="btn btn-success" style="width: 211px;">
	Save <span class="glyphicon glyphicon-ok"></span>
</button>
</div>