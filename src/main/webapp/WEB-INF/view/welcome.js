function addPersion(){
	const url= "/product/save";
	const data={
		    "productId": 4,
		    "productName": "SAMSUNG SMART LCD TV"
		};
	$('.btn').click(url, data,function(data, status){
		$('#row').val(data.stringify());
	});
}