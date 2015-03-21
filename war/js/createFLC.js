var FCL = new FCL("", "");

var inputs = [];
var outputs = [];
var linguisticTerms = [];
var globalCount = 1;

$(document).ready(function () {
	
	/* #################################################################################### */
	/* ############							ACTIONS							   ############ */
	/* #################################################################################### */
	
    var left, opacity, scale; //fieldset properties which we will animate
    var animating; //flag to prevent quick multi-click glitches
    
    /* Action: Go to function blocks fieldset and create FCL */
    $("#defineFunctionBlocks").click(function(){
    	/* Get input with fuzzy control name */
    	var fuzzyControlNameInput = $("#fuzzyControlName");
    	var name = fuzzyControlNameInput.val();
    	
    	/* Get input with fuzzy control description */
    	var description = $("#fuzzyControlDescription").val();
    	
    	/* Current fieldset: Basic Informations */
		var current_el = $("#basicInformations");
		/* Next fieldset: Function Blocks */
		var next_el = $("#functionBlocks");
		
		/* Execute transition and update progress bar */
		executeTransitionNext(current_el, next_el, animating, $("#functionBlockName"));
		updateProgressBar($("#" + next_el.attr('target_pg')));
    });
    
    /*#################################################################################*/
    
    /* Action: Add linguistic terms to input variable */
    $("#addLinguisticTermInput").click(function(){
    	var linguisticTermInput = $("#linguisticTermInput");
    	var linguisticTermFunctionInput = $("#linguisticTermFunctionIDInput");
    	var linguisticTermFunctionValuesInput = $("#linguisticTermFunctionValuesInput"); 
    	
    	var name = linguisticTermInput.val();
    	var termFunctionName = linguisticTermFunctionInput.val();
    	var values = linguisticTermFunctionValuesInput.val();
    	
    	var ok = validateInputValue(linguisticTermInput, name)
    		&& validateInputValue(linguisticTermFunctionInput, termFunctionName)
    		&& validateInputValue(linguisticTermFunctionValuesInput, values);
    	
    	if(ok){
    		var term = new Term(globalCount, name, termFunctionName, values);
    		linguisticTerms.push(term);
    		globalCount++;
    		
    		// load the template file, then render it with data
    		var html = new EJS({url: '../views/templates/termsTableBody.ejs'}).render({"term" : term, "target" : "termsTableBodyInput"});
    		$("#termsTableBodyInput").append(html);
    		
    		/* Action: Clear inputs */
    		linguisticTermInput.val("");
    		linguisticTermFunctionValuesInput.val("");
    		
    		/* Set focus on linguistic term input name */
    		linguisticTermInput.focus();
    	}
    });
    
    /* Action: Add linguistic terms to output variable */
    $("#addLinguisticTermOuput").click(function(){
    	var linguisticTermOutput = $("#linguisticTermOuput");
    	var linguisticTermFunctionOutput = $("#linguisticTermFunctionIDOuput");
    	var linguisticTermFunctionValuesOutput = $("#linguisticTermFunctionValuesOuput"); 
    	
    	var name = linguisticTermOutput.val();
    	var termFunctionName = linguisticTermFunctionOutput.val();
    	var values = linguisticTermFunctionValuesOutput.val();
    	
    	var ok = validateInputValue(linguisticTermOutput, name)
    		&& validateInputValue(linguisticTermFunctionOutput, termFunctionName)
    		&& validateInputValue(linguisticTermFunctionValuesOutput, values);
    	
    	if(ok){
    		var term = new Term(globalCount, name, termFunctionName, values);
    		linguisticTerms.push(term);
    		globalCount++;
    		
    		// load the template file, then render it with data
    		var html = new EJS({url: '../views/templates/termsTableBody.ejs'}).render({"term" : term, "target" : "termsTableBodyOuput"});
    		$("#termsTableBodyOuput").append(html);
    		
    		/* Action: Clear inputs */
    		linguisticTermOutput.val("");
    		linguisticTermFunctionValuesOutput.val("");
    		
    		/* Set focus on linguistic term input name */
    		linguisticTermOutput.focus();
    	}
    });
    
    /* Action: Save input variable */
    $("#saveInputVariable").click(function(){
    	var linguisticVariableNameInput = $("#linguisticVariableNameInput");
    	var linguisticVariableDescriptionInput = $("#linguisticVariableDescriptionInput");
    	var linguisticVariableTypeInput = $("#linguisticVariableTypeInput");
    	
    	var linguisticTermInput = $("#linguisticTermInput");
    	var linguisticTermFunctionValuesInput = $("#linguisticTermFunctionValuesInput"); 
    	
    	var name = linguisticVariableNameInput.val();
    	var description = linguisticVariableDescriptionInput.val();
    	var type = linguisticVariableTypeInput.val();
    	
    	var ok = validateInputValue(linguisticVariableNameInput, name)
			&& validateInputValue(linguisticVariableTypeInput, type);
    	
    	if(ok){
    		var input = new Input(globalCount, name, description, type, linguisticTerms);
    		inputs.push(input);
    		globalCount++;
    		
    		/* Action: Clear inputs */
    		linguisticTermInput.val("");
    		linguisticTermFunctionValuesInput.val("");
    		
    		linguisticVariableNameInput.val("");
    		linguisticVariableDescriptionInput.val("");
    		
    		$("#termsTableBodyInput").html("");
    		
    		linguisticTerms = [];
    		
    		/* Update input table */
    		var html = new EJS({url: '../views/templates/functionBlockInputTableBody.ejs'}).render({"inputs" : inputs});
    		$("#functionBlockInputTableBody").html(html);
    		
    		/* Back to function blocks */
    		var current_el = $("#inputVariables");
        	var previous_el = $("#functionBlocks");
        	
        	executeTransitionBack(current_el, previous_el, animating, $("#functionBlockName"));
        	updateProgressBar($("#" + previous_el.attr('target_pg')));
    	}
    });
    
    /* Action: Save output variable */
    $("#saveOutputVariable").click(function(){
    	var linguisticVariableNameOutput = $("#linguisticVariableNameOutput");
    	var linguisticVariableDescriptionOutput = $("#linguisticVariableDescriptionOutput");
    	var linguisticVariableTypeOutput = $("#linguisticVariableTypeOutput");
    	
    	var defuzzificationMethod = $("#defuzzificationMethod");
    	var defaultValue = $("#defaultValue");
    	
    	var linguisticTermOuput = $("#linguisticTermOuput");
    	var linguisticTermFunctionValuesOuput = $("#linguisticTermFunctionValuesOuput"); 
    	
    	var name = linguisticVariableNameOutput.val();
    	var description = linguisticVariableDescriptionOutput.val();
    	var type = linguisticVariableTypeOutput.val();
    	
    	var defuzzification = defuzzificationMethod.val();
    	var defaultVal = defaultValue.val();
    	
    	var ok = validateInputValue(linguisticVariableNameOutput, name)
			&& validateInputValue(linguisticVariableTypeOutput, type)
			&& validateInputValue(defaultValue, defaultVal);
    	
    	if(ok){
    		var output = new Output(globalCount, name, description, type, defuzzification, defaultVal);
    		outputs.push(output);
    		globalCount++;
    		
    		/* Action: Clear inputs */
    		linguisticTermOuput.val("");
    		linguisticTermFunctionValuesOuput.val("");
    		
    		linguisticVariableNameOutput.val("");
    		linguisticVariableDescriptionOutput.val("");
    		defaultValue.val("");
    		
    		$("#termsTableBodyOuput").html("");
    		
    		linguisticTerms = [];
    		
    		/* Update output table */
    		var html = new EJS({url: '../views/templates/functionBlockOutputTableBody.ejs'}).render({"outputs" : outputs});
    		$("#functionBlockOutputTableBody").html(html);
    		
    		/* Back to function blocks */
    		var current_el = $("#outputVariables");
        	var previous_el = $("#functionBlocks");
        	
        	executeTransitionBack(current_el, previous_el, animating, $("#functionBlockName"));
        	updateProgressBar($("#" + previous_el.attr('target_pg')));
    	}
    });
    
    /* ################################################################################# */
    /* Action: */
    /* ################################################################################# */
    $("#saveFunctionBlock").click(function(){
    	/* Get function block name */
    	var functionBlockNameInput = $("#functionBlockName"); 
    	var functionBlockName = functionBlockNameInput.val();
    	
    	/* Get function block description */
    	var functionBlockDescription = $("#functionBlockDescription").val();
    	
    	var ok = validateInputValue(functionBlockNameInput, functionBlockName)
    		&& (inputs.length > 0) && (outputs.length > 0);
    	
    	if(ok){
    		/* Current fieldset: Function Blocks */
    		var current_el = $("#functionBlocks");
    		/* Previous fieldset: Basic Informations */
    		var previous_el = $("#basicInformations");
    		
    		/* Execute transition and update progress bar */
    		executeTransitionBack(current_el, previous_el, animating, $("#fuzzyControlName"));
    		updateProgressBar($("#" + previous_el.attr('target_pg')));
    		
    		FCL.addFunctionBlock(new FunctionBlock(globalCount, functionBlockName, functionBlockDescription, inputs, outputs));
    		globalCount++;
    		//console.log(JSON.stringify(FCL));
    		
    		/* Clear inputs */
    		functionBlockNameInput.val("");
    		$("#functionBlockDescription").val("");
    		
    		inputs = [];
    		outputs = [];
    		
    		/* Update input table */
    		$("#functionBlockInputTableBody").html("");
    		
    		/* Update output table */
    		var htmlOutputs = new EJS({url: '../views/templates/functionBlockOutputTableBody.ejs'}).render({"outputs" : outputs});
    		$("#functionBlockOutputTableBody").html("");
    		
    		//console.log({"functionBlocks" : FCL.getFunctions()});
    		
    		var htmlFunctions = new EJS({url: '../views/templates/functionBlocksTableBody.ejs'}).render({"functionBlocks" : FCL.getFunctions()});
    		$("#functionBlocksTableBody").html(htmlFunctions);
    	}
    });
    
    /* Action: */
    $("#gotoRulesDefinition").click(function(){
    	var fuzzyControlName = $("#fuzzyControlName");
    	var fuzzyControlNameValue = fuzzyControlName.val();
    	
    	//var ok = validateInputValue(fuzzyControlName, fuzzyControlNameValue) && (FCL.getFunctions().length > 0);
    	
    	if(true){
    		FCL.setName(fuzzyControlNameValue);
    		FCL.setDescription($("#fuzzyControlDescription").val());
    		
    		var current_el = $("#basicInformations");
        	var next_el = $("#rulesFS");
        	
        	executeTransitionNext(current_el, next_el, animating);
        	updateProgressBar($("#" + next_el.attr('target_pg')));
    	}
    });
    
    /* Action: */
    $("#gotoFinish").click(function(){
		var current_el = $("#rulesFS");
    	var next_el = $("#finishFS");
    	
    	executeTransitionNext(current_el, next_el, animating);
    	updateProgressBar($("#" + next_el.attr('target_pg')));
    });
    
    /* Action: */
    $("#cancelFunctionBlockDefinition").click(function(){
    	var current_el = $("#functionBlocks");
    	var previous_el = $("#basicInformations");
    	
    	executeTransitionBack(current_el, previous_el, animating, $("#fuzzyControlName"));
    	updateProgressBar($("#" + previous_el.attr('target_pg')));
    });
    
    /* Action: */
    $("#addInputsVariables").click(function(){
    	var current_el = $("#functionBlocks");
    	var next_el = $("#inputVariables");
    	
    	executeTransitionNext(current_el, next_el, animating, $("#linguisticVariableNameInput"));
    	updateProgressBar($("#" + next_el.attr('target_pg')));
    });
    
    /* Action: */
    $("#cancelInputVariable").click(function(){
    	var current_el = $("#inputVariables");
    	var previous_el = $("#functionBlocks");
    	
    	executeTransitionBack(current_el, previous_el, animating, $("#functionBlockName"));
    	updateProgressBar($("#" + previous_el.attr('target_pg')));
    });
    
    /* Action: */
    $("#addOutputsVariables").click(function(){
    	var current_el = $("#functionBlocks");
    	var next_el = $("#outputVariables");
    	
    	executeTransitionNext(current_el, next_el, animating, $("#linguisticVariableNameOutput"));
    	updateProgressBar($("#" + next_el.attr('target_pg')));
    });
    
    /* Action: */
    $("#cancelOutputVariable").click(function(){
    	var current_el = $("#outputVariables");
    	var previous_el = $("#functionBlocks");
    	executeTransitionBack(current_el, previous_el, animating, $("#functionBlockName"));
    	updateProgressBar($("#" + previous_el.attr('target_pg')));
    });
    
    /* Action: */
    $("#cancelStepRules").click(function(){
    	var current_el = $("#rulesFS");
    	var previous_el = $("#basicInformations");
    	executeTransitionBack(current_el, previous_el, animating, $("#fuzzyControlName"));
    	updateProgressBar($("#" + previous_el.attr('target_pg')));
    });
    
});

/**
 * Reload linguistic terms table
 * */
function removeTermAndReloadLinguisticTermsTable(id, target){
	
	for(var index in linguisticTerms){
		if(id == linguisticTerms[index].getId()){
			linguisticTerms.splice(index, 1);
			break;
		}
	}
	
	var html = new EJS({url: '../views/templates/termsTableBodyList.ejs'}).render({"linguisticTerms" : linguisticTerms, "target" : target});
	$("#" + target).html(html);
}

/**
 * Remove input and reload inputs table
 * */
function removeInputAndReloadInputsTable(id){
	for(var index in inputs){
		if(id == inputs[index].getId()){
			inputs.splice(index, 1);
			break;
		}
	}
	
	/* Update input table */
	var htmlInputs = new EJS({url: '../views/templates/functionBlockInputTableBody.ejs'}).render({"inputs" : inputs});
	$("#functionBlockInputTableBody").html(htmlInputs);
}

/**
 * Remove output and reload outputs table
 * */
function removeOutputAndReloadOutputsTable(id){
	for(var index in outputs){
		if(id == outputs[index].getId()){
			outputs.splice(index, 1);
			break;
		}
	}
	
	/* Update output table */
	var htmlOutputs = new EJS({url: '../views/templates/functionBlockOutputTableBody.ejs'}).render({"outputs" : outputs});
	$("#functionBlockOutputTableBody").html(htmlOutputs);
}

/**
 * Remove function block and reload function blocks table
 * */
function removeFunctionBlockAndReloadFunctionBlocksTable(id){
	for(var index in FCL.getFunctions()){
		if(id == FCL.getFunctions()[index].getId()){
			FCL.getFunctions().splice(index, 1);
			break;
		}
	}
	
	var htmlFunctions = new EJS({url: '../views/templates/functionBlocksTableBody.ejs'}).render({"functionBlocks" : FCL.getFunctions()});
	$("#functionBlocksTableBody").html(htmlFunctions);
}

/**
 * Validate Input Value
 * */
function validateInputValue(element, value){
	if(value != null && value != ""){
		element.parent(".form-group").attr("class", "form-group");
		return true;
	}else{
		element.parent(".form-group").attr("class", "form-group has-error has-feedback");
		return false;
	}
}

/**
 * Update progress Bar
 * */
function updateProgressBar(element){
	$("#progressbar").find("li.active").removeClass("active");
	element.addClass('active');
}

/**
 * Execute Transition to previous fieldset
 * */
function executeTransitionBack(current_el, previous_el, animating, focus_el){
	if (animating) return false;
    animating = true;
	
    var duration = 800;
    
    //hide the current fieldset with style
    current_el.animate({
        opacity: 0
    }, {
        step: function (now, mx) {
            //as the opacity of current_fs reduces to 0 - stored in "now"
            //1. scale previous_fs from 80% to 100%
            scale = 0.8 + (1 - now) * 0.2;
            //2. take current_fs to the right(50%) - from 0%
            left = ((1 - now) * 50) + "%";
            //3. increase opacity of previous_fs to 1 as it moves in
            opacity = 1 - now;
            current_el.css({
                'left': left
            });
            previous_el.css({
                'transform': 'scale(' + scale + ')',
                'opacity': opacity
            });
        },
        duration: duration,
        complete: function () {
        	current_el.hide();
            animating = false;
            
            $('html, body').animate({
                scrollTop: previous_el.offset().top
            }, 2000);
            
            focus_el.focus();
        },
        //this comes from the custom easing plugin
        easing: 'easeInOutBack'
    });
    
    setTimeout(function(){
    	//show the previous fieldset
    	previous_el.show();
	}, duration);
}

/**
 * Execute Transition to next fieldset
 * */
function executeTransitionNext(current_el, next_el, animating, focus_el){
	if (animating) return false;
    animating = true;
    
    var duration = 800;
    
    current_el.animate({
        opacity: 0
    }, {
        step: function (now, mx) {
            //as the opacity of current_fs reduces to 0 - stored in "now"
            //1. scale current_fs down to 80%
            scale = 1 - (1 - now) * 0.2;
            //2. bring next_fs from the right(50%)
            left = (now * 50) + "%";
            //3. increase opacity of next_fs to 1 as it moves in
            opacity = 1 - now;
            current_el.css({
                'transform': 'scale(' + scale + ')'
            });
            next_el.css({
                'left': left,
                'opacity': opacity
            });
        },
        duration: duration,
        complete: function () {
        	current_el.hide();
            animating = false;
            $('html, body').animate({
                scrollTop: next_el.offset().top
            }, 2000);
            
            focus_el.focus();
        },
        easing: 'easeInOutBack'
    });
	
	setTimeout(function(){
		next_el.show();
	}, duration);
}
/**
 * */
function changePlaceholder(select_el, target){
	var actualOption = $(select_el).find('[value=' + $(select_el).val() + ']');
	
	var description = actualOption.attr('description');
	var inputNumber = actualOption.attr('inputNumber');
	
	$("#" + target).attr("placeholder", description);
}

