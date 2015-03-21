<h4><strong>Define Linguistic Terms</strong></h4><hr>
<div id="stepform">
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group" style="text-align: left !important;">
				<label for="linguisticTermInput">Linguistic Term</label>
				<input type="text" class="form-control" id="linguisticTermInput" name="linguisticTermInput" placeholder="Enter Linguistic Term">
			</div>
			
			<div class="form-group" style="text-align: left !important;">
				<label for="linguisticTermFunctionIDInput">Linguistic Term Function</label>
				<select id="linguisticTermFunctionIDInput" class="form-control" name="linguisticTermFunction" onchange="changePlaceholder(this, 'linguisticTermFunctionValuesInput')">
				  	<option value="trian" description="trian min mid max" inputNumber="3">Triangular</option>
				  	<option value="trape" description="trape min midLow midHigh max" inputNumber="4">Trapetzoidal</option>
				  	<option value="gauss" description="gauss mean stdev" inputNumber="2">Gauss</option>
				  	<option value="gbell" description="gbell a b mean" inputNumber="3">Generalized bell</option>
				  	<option value="sigm" description="sigm gain center" inputNumber="2">Sigmoidal</option>
				  	<option value="singleton" description="Just one number (where singleton membership is 1)" inputNumber="1">Singleton</option>
				  	<option value="piece_wise_linear" description="(x_1, y_1) (x_2, y_2) .... (x_n, y_n)" inputNumber="n">Piece-wise linear</option>
				</select>
			</div>
			
			<div class="form-group" style="text-align: left !important;">
				<label for="linguisticTermFunctionValuesInput">Values</label>
				<input type="text" class="form-control" id="linguisticTermFunctionValuesInput" name="linguisticTermFunctionValues" placeholder="trian min mid max">
			</div>
			
			<div class="form-group" style="text-align: left !important;">
				<div class="row">
					<div class="col-xs-6">
						<button type="button" class="btn btn-primary btn-block" id="addLinguisticTermInput">
							Add Linguistic Term <span class="glyphicon glyphicon-plus"></span>
						</button>
					</div>
					<div class="col-xs-6">
						<button type="button" class="btn btn-default btn-block" id="plotGraphInputTerm">
							Show graph <span class="glyphicon glyphicon-tasks"></span>
						</button>
					</div>	
				</div>
			</div>
		</div>
		
		<div class="col-xs-6">
			<div class="panel panel-default" style="height: 290px;">
			  	<div class="panel-body">
			  		<img alt="" src="${pageContext.request.contextPath}/images/inVar2.png" style="width: 400px;">
			  	</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-12">
			<h4><strong>Linguistic Terms</strong></h4>
			<hr>
		</div>
		<div class="col-xs-12">
			<div class="table-responsive">
	        	<table class="table table-bordered">
	          		<thead>
	            		<tr>
	              			<th>#</th>
	              			<th class="col-md-4">Name</th>
	              			<th class="col-md-4">Function</th>
	              			<th class="col-md-4">Values</th>
	              			<th class="">Options</th>
	            		</tr>
	          		</thead>
	          		<tbody id="termsTableBodyInput">
	          			
	          		</tbody>
	        	</table>
	      	</div>
		</div>
</div>