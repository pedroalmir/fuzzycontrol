<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-md-11">
		<form id="fclform" action="${pageContext.request.contextPath}/" method="post">
			<!-- progressbar -->
			<ul id="progressbar" style="margin-left: 90px;">
				<li id="basic_pg" class="active">Basic Informations</li>
				<li id="function_pg">Function Blocks</li>
				<li id="input_pg">Input Variables</li>
				<li id="output_pg">Output Variables</li>
				<li id="rules_pg">Rules</li>
				<li id="finish_pg">Finish</li>
			</ul>
			
			<fieldset id="basicInformations" target_pg="basic_pg">
				<jsp:include page="${pageContext.request.contextPath}/views/fuzzy/parts/basicInformations.jsp"></jsp:include>
			</fieldset>
		
			<fieldset id="functionBlocks" target_pg="function_pg">
				<jsp:include page="${pageContext.request.contextPath}/views/fuzzy/parts/functionBlocks.jsp"></jsp:include>
			</fieldset>
			
			<fieldset id="inputVariables" target_pg="input_pg">
				<jsp:include page="${pageContext.request.contextPath}/views/fuzzy/parts/inputVariable.jsp"></jsp:include>
			</fieldset>
			
			<fieldset id="outputVariables" target_pg="output_pg">
				<jsp:include page="${pageContext.request.contextPath}/views/fuzzy/parts/outputVariable.jsp"></jsp:include>
			</fieldset>
			
			<fieldset id="rulesFS" target_pg="rules_pg">
				<jsp:include page="${pageContext.request.contextPath}/views/fuzzy/parts/rules.jsp"></jsp:include>
			</fieldset>
			
			<fieldset id="finishFS" target_pg="finish_pg">
				<jsp:include page="${pageContext.request.contextPath}/views/fuzzy/parts/finish.jsp"></jsp:include>
			</fieldset>
		</form>
	</div>
</div>

<script src="${pageContext.request.contextPath}/js/createFLC.js"></script>