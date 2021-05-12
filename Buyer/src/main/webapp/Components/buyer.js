

$(document).ready(function()

 {
 $("#alertSuccess").hide();
 
 $("#alertError").hide();
});


// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();


// Form validation-------------------
var status = validateItemForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }


// If valid------------------------
var type = ($("#hidbidSave").val() == "") ? "POST" : "PUT";
 $.ajax(
 {
 url : "BuyerAPI",
 type : type,
 data : $("#formBuyer").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
 onItemSaveComplete(response.responseText, status);
 }
 });
});




function onItemSaveComplete(response, status)
{
		if (status == "success")
 			{
 				var resultSet = JSON.parse(response);
 				if (resultSet.status.trim() == "success")
 				{
					 $("#alertSuccess").text("Successfully saved.");
					 $("#alertSuccess").show();
					 $("#divItemsGrid").html(resultSet.data);
 
				} 
				else if (resultSet.status.trim() == "error")
 				{
				 $("#alertError").text(resultSet.data);
 				$("#alertError").show();
 				}
 			} 
		else if (status == "error")
 		{
 			$("#alertError").text("Error while saving.");
		    $("#alertError").show();
 		}
		 else
 		{
 			$("#alertError").text("Unknown error while saving..");
 			$("#alertError").show();
 		} 

 		$("#hidbidSave").val("");
 		$("#formBuyer")[0].reset();
}


$(document).on("click", ".btnUpdate", function(event)
{
$("#hidbidSave").val($(this).data("bidd"));
 //$("#itemID").val($(this).closest("tr").find('td:eq(0)').text());
 $("#fname").val($(this).closest("tr").find('td:eq(0)').text());
 $("#lname").val($(this).closest("tr").find('td:eq(1)').text());
 $("#phone").val($(this).closest("tr").find('td:eq(2)').text());
 $("#bdate").val($(this).closest("tr").find('td:eq(3)').text());
 $("#email").val($(this).closest("tr").find('td:eq(4)').text());
 $("#country").val($(this).closest("tr").find('td:eq(5)').text());
 $("#password").val($(this).closest("tr").find('td:eq(6)').text());
 $("#cpassword").val($(this).closest("tr").find('td:eq(7)').text());
});


$(document).on("click", ".btnRemove", function(event)
{
 $.ajax(
 {
 url : "BuyerAPI",
 type : "DELETE",
 data : "bid=" + $(this).data("bidd"),
 dataType : "text",
 complete : function(response, status)
 {
 onItemDeleteComplete(response.responseText, status);
 }
 });
});


function onItemDeleteComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divItemsGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
}



function validateItemForm()
{
// CODE
if ($("#fname").val().trim() == "")
 {
 return "Insert Item Code.";
 }
// NAME
if ($("#lname").val().trim() == "")
 {
 return "Insert Item Name.";
 }
// PRICE-------------------------------
if ($("#phone").val().trim() == "")
 {
 return "Insert Item Price.";
 }

// DESCRIPTION------------------------
if ($("#bdate").val().trim() == "")
 {
 return "Insert Item Description.";
 }
// NAME
if ($("#email").val().trim() == "")
 {
 return "Insert Item Name.";
 }
// NAME
if ($("#country").val().trim() == "")
 {
 return "Insert Item Name.";
 }
// NAME
if ($("#password").val().trim() == "")
 {
 return "Insert Item Name.";
 }
// NAME
if ($("#cpassword").val().trim() == "")
 {
 return "Insert Item Name.";
 }
return true;
}

