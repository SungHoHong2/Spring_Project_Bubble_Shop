var httpRequest = null;

function getXMLHttpRequest() {
	if (window.ActiveXObject) {

		try {
			
			return new ActiveXObject("Msxml12.XMLHTTP");

		} catch (e1) {
			try {

				return new ActiveXObject("Microsoft.XMLHTTP");

			} catch (e2) {
				return null;
			}
		}

	} else if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else {

		return null;
	}
}

function sendRequest(url, params, callback, method) {

	httpRequest = getXMLHttpRequest();

	httpRequest.onreadystatechange = callback;

	var httpMethod = method ? method : 'GET';
	
	if(httpMethod != 'GET' && httpMethod != 'POST')
		httpMethod ='GET';
	/* 값이 없거나 이상한글자 가 입력되면 GET */
	
	var httpParams = (params==null || params=='') ? null : params;
	
	var httpUrl = url;
	
	if(httpMethod == 'GET' && httpParams != null)
		httpUrl = httpUrl + "?" + httpParams;
	
	
	httpRequest.open(httpMethod, httpUrl, true);
	

	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
	
}

function log(msg, console)
{
	
	var console = document.getElementById(console);
	
	if(console)
		console.innerHTML += msg + "<br>";
		
	
}









