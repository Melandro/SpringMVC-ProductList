async function callFunction(brand) {
	const url = "/search?brand=" + brand;
	let product = await fetch(url)
		.then(response => response.json())
		.then(data => data);
	console.log(data);
}

$(document).ready(function(){
	
	$('a','div.res').click(function(){
		var price = $('#price').val();

		var currentAnchor = $(this);
		var value = currentAnchor.attr('href');

		var newValue = value.replace('replace_price', price);
		currentAnchor.attr('href', newValue);
	});
	
	$('#price').change(function(){
		var value = $(this).val();
		
		if (value !== '' && !isNaN( parseFloat( value ) ) ) {
			$('#btnSearch').removeClass("disabled-link");
		}
	});
});