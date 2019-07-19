function jsLogout() {
	Console.log("logout clicked!!!");
}
function myFunction() {
	  document.getElementById("demo").innerHTML = "Hello World";
	}
function basicAuthLogout()
{
	alert("sending get request");
	var theUrl = "http://log:out@localhost:8080/profile";
	var c = "Basic xxxuOmNhbjttMw==";
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, true ); // false for synchronous request
    xmlHttp.setRequestHeader("Authorization", c);
    xmlHttp.send( );
    window.location.replace("http://localhost:8080/");
    return xmlHttp.responseText;
}

