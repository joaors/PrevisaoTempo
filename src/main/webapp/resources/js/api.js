var vUrlAPI = 'http://localhost:8090/PrevisaoTempo/api/previsao';

$(document).ready(function(){
	$('#btnConsultar').click(selecionar);
});

function selecionar(){	
	$('#dados').empty();
	$('#msg').empty();
	$('#msg').removeClass( "alert alert-danger");
	$('#btnConsultar').attr("disabled", true);		
	hideMsg();
	showLoading();
	$.ajax({
		url: vUrlAPI,
		dataType: 'json',
		type: "GET",
	})
	.done(sucesso)
	.fail(fail)
	.always(function(data) {
		$('#btnConsultar').attr("disabled", false);			
	});
}

function sucesso(data) {
	hideMsg();
	if (data.currentLocation != null) {
		html = '<div class="row"> <div class="col-md-2"> Local:</div>';
		html += '<div class="col-md-6">'+data.currentLocation+'</div>';
		html += '</div>';
	}
	if (data.currenttime != null) {
		html += '<div class="row"> <div class="col-md-2"> Tempo Atual:</div>';
		html += '<div class="col-md-6">'+data.currenttime+'</div>';
		html += '</div>';		
	}
	if (data.wind != null) {
		html += '<div class="row"> <div class="col-md-2"> Cond. do Vento:</div>';
		html += '<div class="col-md-6">'+data.wind+'</div>';
		html += '</div>';		
	}
	if (data.visibility != null) {
		html += '<div class="row"> <div class="col-md-2"> Visibilidade:</div>';
		html += '<div class="col-md-6">'+data.visibility+'</div>';
		html += '</div>';		
	}
	if (data.skyConditions != null) {
		html += '<div class="row"> <div class="col-md-2"> Cond. C\u00E9u:</div>';
		html += '<div class="col-md-6">'+data.skyConditions+'</div>';
		html += '</div>';
	}
	if (data.temperature != null) {
		html += '<div class="row"> <div class="col-md-2"> Temperatura:</div>';
		html += '<div class="col-md-6">'+data.temperature+'</div>';
		html += '</div>';		
	}
	if (data.dewPoint != null) {
		html += '<div class="row"> <div class="col-md-2"> Dew Point:</div>';
		html += '<div class="col-md-6">'+data.dewPoint+'</div>';
		html += '</div>';		
	}
	if (data.relativeHumidity != null) {
		html += '<div class="row"> <div class="col-md-2"> Humidade Rel. Ar:</div>';
		html += '<div class="col-md-6">'+data.relativeHumidity+'</div>';
		html += '</div>';		
	}
	if (data.pressure != null) {
		html += '<div class="row"> <div class="col-md-2"> Press\u00E3o Atm.:</div>';
		html += '<div class="col-md-6">'+data.pressure+'</div>';
		html += '</div>';		
	}
	$('#dados').append(html);	
}

function fail(jqXHR, erro){
	if (jqXHR.status == 500) {
		retorno = jQuery.parseJSON(jqXHR.responseText);
		responseText = retorno.mensagem +': ' +retorno.erro;
    } else {
        resposneText = alert('Erro inesperado.\n' + jqXHR.responseText);
    }	
	$('#msg').empty();
	$('#msg').html(responseText);
	$('#msg').addClass( "alert alert-danger");
	$('#msg').show();
	showMsg();	
}

function hideMsg(){
	$('#msg').hide();
}

function showMsg(){
	$('#msg').show();
}

function showLoading(){
	$('#msg').html('<img src="loading.gif" alt="Carregando..." style="display:block">');	
	showMsg();
}