
function showWindow(id)
{
	document.getElementById("xx"+id).style.borderStyle = "solid";
	document.getElementById("xx"+id).style.display = "initial";
	document.getElementById("xx"+id).style.background = "white";
	document.getElementById("xx"+id).style.width = "250px";
	document.getElementById("xx"+id).style.height = "270px";
	document.getElementById("xx"+id).style.position= "absolute";
	document.getElementById("xx"+id).style.zIndex = "1";
}

function hideWindow(id)
{
  document.getElementById("xx"+id).style.display = "none";
}