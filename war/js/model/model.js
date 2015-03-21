/* #################################################################################### */
/* ############							 MODEL							   ############ */
/* #################################################################################### */
/**
 * Linguistic Term Object representation
 * */
function Term(id, name, termFunctionName, values){
	this.id = id;
	this.name = name;
	this.termFunctionName = termFunctionName;
	this.values = values;
	
	this.getId = function() {
		return this.id;
	};
	
	this.getName = function() {
		return this.name;
	};
	
	this.getTermFunctionName = function() {
		return this.termFunctionName;
	};
	
	this.getValues = function() {
		return this.values;
	};
}

/**
 * Input Object representation
 * */
function Input(id, name, description, type, terms){
	this.id = id;
	this.name = name;
	this.description = description;
	this.type = type;
	this.terms = terms;
	
	this.getId = function(){
		return this.id;
	};
	
	this.getName = function() {
		return this.name;
	};

	this.getDescription = function() {
		return this.description;
	};
	
	this.getType = function(){
		return this.type;
	}
	
	this.getTerms = function(){
		return this.terms;
	}
	
	this.toStringTerms = function(){
		var result = "[";
		for(var i = 0; i < this.getTerms().length; i++){
			if(i == this.getTerms().length-1){
				result += this.getTerms()[i].getName() + "]";
			}else{
				result += this.getTerms()[i].getName() + ", ";
			}
		}
		return result;
	}
}

/**
 * Output Object representation
 * */
function Output(id, name, description, type, defuzzification, defaultValue, terms){
	this.id = id;
	this.name = name;
	this.description = description;
	this.type = type;
	
	this.defuzzification = defuzzification;
	this.defaultValue = defaultValue;
	
	this.terms = terms;
	
	this.getId = function() {
		return this.id;
	};
	
	this.getName = function() {
		return this.name;
	};

	this.getDescription = function() {
		return this.description;
	};
	
	this.getType = function(){
		return this.type;
	}
	
	this.getDefuzzification = function(){
		return this.defuzzification;
	}
	
	this.getDefaultValue = function(){
		return this.defaultValue;
	}
	
	this.getTerms = function(){
		return this.terms;
	}
	
	this.toStringTerms = function(){
		var result = "[";
		for(var i = 0; i < this.getTerms().length; i++){
			if(i == this.getTerms().length-1){
				result += this.getTerms()[i].getName() + "]";
			}else{
				result += this.getTerms()[i].getName() + ", ";
			}
		}
		return result;
	}
}

/**
 * Function Block Object representation
 * */
function FunctionBlock(id, name, description, inputs, outputs){
	this.id = id;
	this.name = name;
	this.description = description;
	this.inputs = inputs;
	this.outputs = outputs;
	
	this.getId = function() {
		return this.id;
	};
	
	this.getName = function() {
		return this.name;
	};

	this.getDescription = function() {
		return this.description;
	};
	
	this.getInputs = function(){
		return this.inputs;
	}
	
	this.getOutputs = function(){
		return this.outputs;
	}
	
	this.toStringInputs = function(){
		var result = "[";
		for(var i = 0; i < this.getInputs().length; i++){
			if(i == this.getInputs().length-1){
				result += this.getInputs()[i].getName() + "]";
			}else{
				result += this.getInputs()[i].getName() + ", ";
			}
		}
		return result;
	}
	
	this.toStringOutputs = function(){
		var result = "[";
		for(var i = 0; i < this.getOutputs().length; i++){
			if(i == this.getOutputs().length-1){
				result += this.getOutputs()[i].getName() + "]";
			}else{
				result += this.getOutputs()[i].getName() + ", ";
			}
		}
		return result;
	}
}

/**
 * FCL Object representation
 * */
function FCL(name, description){
	this.name = name;
	this.description = description;
	this.functions = [];
	
	this.getName = function() {
		return this.name;
	};
	
	this.setName = function(name) {
		this.name = name;
	};

	this.getDescription = function() {
		return this.description;
	};
	
	this.setDescription = function(description) {
		this.description = description;
	};
	
	this.getFunctions = function() {
		return this.functions;
	};
	
	this.addFunctionBlock = function(functionBlock){
		this.functions.push(functionBlock);
	}
	
	this.toString = function(){
		console.log(this.name + " - " + this.description)
	}
}