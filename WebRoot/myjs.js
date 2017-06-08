 	var xmlHttpRequest = null;
 	
 	function getXMLHttpRequest(){
 		try{
 			// ff, chrome, safari, opera, IE7+
 			xmlHttpRequest = new XMLHttpRequest();
 		} catch(e) {
 			// ie
 			try {
 				xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
 			} catch(e2){
 				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");	// IE3, IE4
 			}
 		}	// try... catch...
 	}	// getXMLHttpRequest