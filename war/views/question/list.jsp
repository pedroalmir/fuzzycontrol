<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<form id="msform" action="${pageContext.request.contextPath}/questions" method="post">
	<input type="hidden" value="${modelID}" name="id">
	
	<!-- Variables -->
	<c:set var="size" value="${fn:length(questions)}" />
	<c:set var="progress" value="${100/size}" />
	<c:set var="realindex" value="${1}" />
	<c:set var="index" value="${2}" />
	<c:set var="increment" value="${1}" />
	
	<!-- fieldsets -->
	<fieldset id="1">
		<h2 class="">Question 1</h2><br/>
		<div id="stepform">
			<div class="progress progress-striped active">
			  <div class="progress-bar progress-bar-success"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
			  </div>
			</div>
			<div class="form-group" style="text-align: left !important;">
				<label for="">${firstQuestion.enunciation}</label><br/><br/>
				<p>1. ${firstQuestion.firstOption}</p>
		    	<p>2. ${firstQuestion.secondOption}</p>
		    	<br/>
				
				<select class="form-control select-required" name="userAnswer${firstQuestion.id}" title="Enter your answer to this question">
					<option value="0">Please, please choose the appropriate answer...</option>
	  				<option>${firstQuestion.firstOption}</option>
					<option>${firstQuestion.secondOption}</option>
				</select>
				<br/>
			</div>
		</div>
		<button type="button" name="next" class="next btn btn-primary">
  			Next Question <span class="glyphicon glyphicon-chevron-right"></span>
		</button>
	</fieldset>
	
	<c:forEach var="question" items="${questions}">
    	<fieldset id="${realindex + 1}">
			<h2 class="">Question ${index}</h2><br/>
			
			<div id="stepform">
				<div class="progress progress-striped active">
				  <div class="progress-bar progress-bar-success"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
				    ${index}/${size + increment}
				  </div>
				</div>
				<div class="form-group" style="text-align: left !important;">
					<label for="">${question.enunciation}</label><br/><br/>
					<p>1. ${question.firstOption}</p>
			    	<p>2. ${question.secondOption}</p>
			    	<br/>
					
					<select class="form-control select-required" name="userAnswer${question.id}" title="Enter your answer to this question">
						<option value="0">Please, please choose the appropriate answer...</option>
		  				<option>${question.firstOption}</option>
						<option>${question.secondOption}</option>
					</select>
					<br/>
				</div>
			</div>
			<c:choose>
			    <c:when test="${realindex < size}">
			    	<button type="button" name="previous" class="previous btn btn-primary">
			  			<span class="glyphicon glyphicon-chevron-left"></span> Previous Question
					</button>
					<button type="button" name="next" class="next btn btn-primary">
			  			Next Question <span class="glyphicon glyphicon-chevron-right"></span>
					</button>
			    </c:when>
			    <c:otherwise>
			        <button type="button" name="previous" class="previous btn btn-primary">
			  			<span class="glyphicon glyphicon-chevron-left"></span> Previous Question
					</button>
					<button type="submit" name="submit" class="btn btn-success">
			  			Submit Answers <span class="glyphicon glyphicon-ok"></span>
					</button>
			    </c:otherwise>
			</c:choose>
			
			<c:set var="index" value="${index + increment}" />
			<c:set var="realindex" value="${realindex + increment}" />
		</fieldset>
 	</c:forEach>
</form>

<script type="text/javascript">
$(document).ready(function () {
	
    var current_fs, next_fs, previous_fs; //fieldsets
    var left, opacity, scale; //fieldset properties which we will animate
    var animating; //flag to prevent quick multi-click glitches

    $(".next").click(function () {
        current_fs = $(this).parent(); //fieldset
        var current_select = current_fs.find(".select-required");
        
        if (current_select.val() == 0) {
        	current_select.parent(".form-group").attr("class", "form-group has-error has-feedback")
            return false;
        }else{
        	current_select.parent(".form-group").attr("class", "form-group")
        }
        
        if (animating) return false;
        animating = true;
        
        var progress = "${progress}";
        var realindex = current_fs.attr("id");
       
        $(".progress-bar").css("width", (progress*(realindex)) + "%");
        
        next_fs = $(this).parent().next();			//next fieldset
        
        //show the next fieldset
        next_fs.show();
        //hide the current fieldset with style
        current_fs.animate({
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
                current_fs.css({
                    'transform': 'scale(' + scale + ')'
                });
                next_fs.css({
                    'left': left,
                    'opacity': opacity
                });
            },
            duration: 800,
            complete: function () {
                current_fs.hide();
                animating = false;
            },
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
    });

    $(".previous").click(function () {
    	current_fs = $(this).parent();
		var current_select = current_fs.find(".select-required");
        
        if (current_select.val() == 0) {
        	current_select.parent(".form-group").attr("class", "form-group has-error has-feedback")
            return false;
        }else{
        	current_select.parent(".form-group").attr("class", "form-group")
        }
    	
        if (animating) return false;
        animating = true;

        previous_fs = $(this).parent().prev();
        
        var progress = "${progress}";
        var realindex = previous_fs.attr("id");
       
        if(realindex > 1){
        	$(".progress-bar").css("width", (progress*(realindex)) + "%");
        }else{
        	$(".progress-bar").css("width", "0%");
        }

        //show the previous fieldset
        previous_fs.show();
        //hide the current fieldset with style
        current_fs.animate({
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
                current_fs.css({
                    'left': left
                });
                previous_fs.css({
                    'transform': 'scale(' + scale + ')',
                    'opacity': opacity
                });
            },
            duration: 800,
            complete: function () {
                current_fs.hide();
                animating = false;
            },
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
    });
});
</script>
