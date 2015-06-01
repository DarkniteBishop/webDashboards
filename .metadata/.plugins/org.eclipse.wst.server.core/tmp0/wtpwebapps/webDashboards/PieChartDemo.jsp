<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pie Chart Demo</title>

</head>
<body>
	<!-- <h1>JFreechart: Create Pie Chart Dynamically</h1>-->
	<%
	    response.setIntHeader("Refresh", 10);
	%>
	<center>
	<table border=1>
		<tr>
			<td>
				<center>
				<form id="r-anden01"><p><b>Ubicacion:</b> <input type="text" value="R-ANDEN01"
								id="r-anden01" readonly="readonly" size="10" /> 
								
			<b>OC:</b> <input
								type="text" value="" id="r-anden01" readonly="readonly" size="15" /> <b>Proveedor:</b>
							<input type="text" value="" id="r-anden01" readonly="readonly" size="15" />
						</p>

						<!--  <input type="button" onclick="refreshpage()" value="Refresh"/> -->
					</form>
					<table>
						<tr>
							<td rowspan="3"><img src="chart" border="0" /></td>
							<td><img src="img/available-on.png" width="80" height="80" /></td>
						</tr>
						<tr>
							<td><img src="img/receiving-off.png" width="80" height="80" /></td>
						</tr>
						<tr>
							<td><img src="img/received-off.png" width="80" height="80" /></td>
						</tr>
						<tr>
						 	
							<td>
								<center>
								 <table border=1 align="center">
										<tr>
											<th>Esperado</th>
											<th>Recibido</th>
											<th>Por Recibir</th>
										</tr>
										<tr>
											<td>1000</td>
											<td>100</td>
											<td>900</td>
										</tr>
									</table>
								</center>
							</td>
							<td><center><font face="Arial" size="25">01</font></center></td>

						</tr>
					</table>
				</center>
			</td>
			<td>
				<center><form id="r-anden01"><p><b>Ubicacion:</b> <input type="text" value="R-ANDEN01"
								id="r-anden01" readonly="readonly" size="10" /> <b>OC:</b> <input
								type="text" value="" id="r-anden01" readonly="readonly" size="15" /> <b>Proveedor:</b>
							<input type="text" value="" id="r-anden01" readonly="readonly" size="15" />
						</p>

						<!--  <input type="button" onclick="refreshpage()" value="Refresh"/> -->
					</form>
					<table>
						<tr>
							<td rowspan="3"><img src="chart" border="0" /></td>
							<td><img src="img/available-off.png" width="80" height="80" /></td>
						</tr>
						<tr>
							<td><img src="img/receiving-on.png" width="80" height="80" /></td>
						</tr>
						<tr>
							<td><img src="img/received-off.png" width="80" height="80" /></td>
						</tr>
						<tr>
						 	
							<td>
								<center>
								 <table border=1 align="center">
										<tr>
											<th>Esperado</th>
											<th>Recibido</th>
											<th>Por Recibir</th>
										</tr>
										<tr>
											<td>1000</td>
											<td>100</td>
											<td>900</td>
										</tr>
									</table>
								</center>
							</td>
							<td><center><font face="Arial" size="25">01</font></center></td>

						</tr>
					</table>
				</center>
			</td>
		</tr>
		<tr>
			<td>
				<center><form id="r-anden01"><p><b>Ubicacion:</b> <input type="text" value="R-ANDEN01"
								id="r-anden01" readonly="readonly" size="10" /> <b>OC:</b> <input
								type="text" value="" id="r-anden01" readonly="readonly" size="15" /> <b>Proveedor:</b>
							<input type="text" value="" id="r-anden01" readonly="readonly" size="15" />
						</p>

						<!--  <input type="button" onclick="refreshpage()" value="Refresh"/> -->
					</form>
					<table>
						<tr>
							<td rowspan="3"><img src="chart" border="0" /></td>
							<td><img src="img/available-off.png" width="80" height="80" /></td>
						</tr>
						<tr>
							<td><img src="img/receiving-off.png" width="80" height="80" /></td>
						</tr>
						<tr>
							<td><img src="img/received-on.png" width="80" height="80" /></td>
						</tr>
						<tr>
						 	
							<td>
								<center>
								 <table border=1 align="center">
										<tr>
											<th>Esperado</th>
											<th>Recibido</th>
											<th>Por Recibir</th>
										</tr>
										<tr>
											<td>1000</td>
											<td>100</td>
											<td>900</td>
										</tr>
									</table>
								</center>
							</td>
							<td><center><font face="Arial" size="25">01</font></center></td>

						</tr>
					</table>
				</center>
			</td>
			<td>
				<center><form id="r-anden01"><p><b>Ubicacion:</b> <input type="text" value="R-ANDEN01"
								id="r-anden01" readonly="readonly" size="10" /> <b>OC:</b> <input
								type="text" value="" id="r-anden01" readonly="readonly" size="15" /> <b>Proveedor:</b>
							<input type="text" value="" id="r-anden01" readonly="readonly" size="15" />
						</p>

						<!--  <input type="button" onclick="refreshpage()" value="Refresh"/> -->
					</form>
					<table>
						<tr>
							<td rowspan="3"><img src="chart" border="0" /></td>
							<td><img src="img/available-on.png" width="80" height="80" /></td>
						</tr>
						<tr>
							<td><img src="img/receiving-on.png" width="80" height="80" /></td>
						</tr>
						<tr>
							<td><img src="img/received-on.png" width="80" height="80" /></td>
						</tr>
						<tr>
						 	
							<td>
								<center>
								 <table border=1 align="center">
										<tr>
											<th>Esperado</th>
											<th>Recibido</th>
											<th>Por Recibir</th>
										</tr>
										<tr>
											<td>1000</td>
											<td>100</td>
											<td>900</td>
										</tr>
									</table>
								</center>
							</td>
							<td><center><font face="Arial" size="25">01</font></center></td>

						</tr>
					</table>
				</center>
			</td>
		</tr>
	</table>
</center>
</body>
</html>