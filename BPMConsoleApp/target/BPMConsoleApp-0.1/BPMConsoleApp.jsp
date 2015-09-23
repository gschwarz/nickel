<!doctype html>
<!-- The DOCTYPE declaration above will set the    -->
<!-- browser's rendering engine into               -->
<!-- "Standards Mode". Replacing this declaration  -->
<!-- with a "Quirks Mode" doctype may lead to some -->
<!-- differences in layout.                        -->

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="gwt:property" content="locale=<%=request.getLocale()%>">


<!-- <script src="http://localhost:8080/BPMEnterpriseApp/js/functions.js"></script>-->

<!--                                                               -->
<!-- Consider inlining CSS to reduce the number of requested files -->
<!--                                                               -->
<link type="text/css" rel="stylesheet" href="BPMConsoleApp.css">

<!--                                           -->
<!-- Any title is fine                         -->
<!--                                           -->
<title>:: RULES WEB CONSOLE ::</title>

<!--                                           -->
<!-- This script loads your compiled module.   -->
<!-- If you add any GWT meta tags, they must   -->
<!-- be added before this line.                -->
<!--                                           -->
<script type="text/javascript" language="javascript"
	src="BPMConsoleApp/BPMConsoleApp.nocache.js"></script>



<style type="text/css">
html {
	height: 100%;
	overflow: hidden;
	margin: 0;
	padding: 0;
}

#splash {
	background: #ffffff;
	cursor: wait;
	position: absolute;
	top: 0;
	left: 0;
	z-index: 1000;
}

.bpm-loader {
	background-repeat: no-repeat;
	height: 24px;
	width: 130px;
	padding-left: 26px;
	padding-top: 8px;
	font-family: Arial, sans-serif;
	font-size: 10px;
	font-weight: bold;
	color: #777;
	cursor: wait;
}
</style>


</head>


<body bgcolor="#000">
	<div id="splash" style="height: 100%; width: 100%;">
		<table width="100%" height="100%">
			<tr>
				<td width="100%" height="100%" align="center" valign="middle">
					<div id="ui_loading" class="bpm-loader"
						style="visibility: hidden; z-index: 1001;" alttext="Error">Creando
						espacio de trabajo ...</div>
					<div id="splash_loading" class="bpm-loader" alttext="Error">Cargando
						...</div>
				</td>
			</tr>
		</table>
	</div>


	<!-- OPTIONAL: include this if you want history support -->
	<iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1'
		style="position: absolute; width: 0; height: 0; border: 0"></iframe>

	<!-- RECOMMENDED if your web app will not function without JavaScript enabled -->
	<noscript>
		<div
			style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">
			Your web browser must have JavaScript enabled in order for this
			application to display correctly.</div>
	</noscript>


</body>
</html>
