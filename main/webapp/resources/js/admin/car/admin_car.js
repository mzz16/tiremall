function deletecb1(cbbbb) {
	let ok = confirm('정말 삭제하시겠습니까?');
	if (ok) {
		location.href = 'brand.delete.do?cb_name=' + cbbbb;
	}
}



$(document).ready(
		function($) {
			$(".carRegButton").on("click", function(event) { //팝업오픈 버튼 누르면
				$("#carregpopup01").show(); //팝업 오픈
				$("body").append('<div class="backon"></div>'); //뒷배경 생성
			});

			$("body").on(
					"click",
					function(event) {
						if (event.target.className == 'close'
								|| event.target.className == 'backon') {
							$("#carregpopup01").hide(); //close버튼 이거나 뒷배경 클릭시 팝업 삭제
							$(".backon").hide();
						}

					});
		
		});




$(document).ready(
		function($) {
			$(".brandRegButton").on("click", function(event) { //팝업오픈 버튼 누르면
				$("#brandregpopup01").show(); //팝업 오픈
				$("body").append('<div class="backon"></div>'); //뒷배경 생성
			});

			$("body").on(
					"click",
					function(event) {
						if (event.target.className == 'close'
								|| event.target.className == 'backon') {
							$("#brandregpopup01").hide(); //close버튼 이거나 뒷배경 클릭시 팝업 삭제
							$(".backon").hide();
						}

					});
		
		});





function deletecar(carrr) {
	let ok = confirm('정말 삭제하시겠습니까?');
	if (ok) {
		location.href = 'admin.car.delete.do?c_id=' + carrr;
	}


}

function updatecar(id,name,year1,year2,option,brand,ft,bt) {

	
	 $(document).ready(function( $ ){     
		    $(".updatecarbutton").on("click", function(event) {  //팝업오픈 버튼 누르면
		    $("#updatecarpopup01").show();   //팝업 오픈
		    $("body").append('<div class="backon"></div>'); //뒷배경 생성
		    });
		    
		    $("body").on("click", function(event) { 
		        if(event.target.className == 'close' || event.target.className == 'backon'){
		            $("#updatecarpopup01").hide(); //close버튼 이거나 뒷배경 클릭시 팝업 삭제
		              $(".backon").hide();
		        }
		      });
		 
		    
		    
		  });


	 $('#c_id_u').val(id);
	 $('#c_name_u').val(name);
	 $('#c_year1_u').val(year1);
	 $('#c_year2_u').val(year2);
	 $('#c_option_u').val(option);
	 $('#c_brand_u').val(brand);
	 $('#c_ft_u').val(ft);
	 $('#c_bt_u').val(bt);

	

}







	
	