<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" />
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/busslogic.js"></script>
<title>迷你店铺</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation" id="inbound_id" class="active"><a
			href="#" onclick="swPage('#inbound_id')">进货</a></li>
		<li role="presentation" id="outbound_id"><a href="#"
			onclick="swPage('#outbound_id')">提货</a></li>
		<li role="presentation" id="inbound_query_id"><a href="#"
			onclick="swPage('#inbound_query_id')">进货查询</a></li>
		<li role="presentation" id="warehouse_query_id"><a href="#"
			onclick="swPage('#warehouse_query_id')">库存查询</a></li>
	</ul>
	<br />
	<form>
		<div class="form-group">
			<label for="exampleInputEmail1">Email address</label> <input
				type="email" class="form-control" id="exampleInputEmail1"
				placeholder="Enter email">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				type="password" class="form-control" id="exampleInputPassword1"
				placeholder="Password">
		</div>
		<div class="form-group">
			<label for="exampleInputFile">File input</label> <input type="file"
				id="exampleInputFile">
			<p class="help-block">Example block-level help text here.</p>
		</div>
		<div class="checkbox">
			<label> <input type="checkbox"> Check me out
			</label>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>

	<div>
		<i><div class="btn-group">
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false">
					烟类 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">酒水类</a></li>
					<li><a href="#">烟类</a></li>
					<li><a href="#">零食类</a></li>
					<li><a href="#">生活类</a></li>
				</ul>
			</div></i>
	</div>

</body>
</html>