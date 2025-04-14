
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">

</head>
<body>
	<g:render template="/shared/leftMenu"></g:render>
	<div id="right-panel" class="right-panel">


		<header id="header" class="header">

			<div class="header-menu">

				<div class="col-sm-7">
					<a id="menuToggle" class="menutoggle pull-left"><i
						class="fa fa fa-tasks"></i></a>

				</div>

				<div class="col-sm-5">
					<g:render template="/shared/topMenu"></g:render>
				</div>
			</div>

		</header>

</div>


	

	<script src="assetss/js/lib/data-table/datatables.min.js"></script>
	<script src="assetss/js/lib/data-table/dataTables.bootstrap.min.js"></script>
	<script src="assetss/js/lib/data-table/dataTables.buttons.min.js"></script>
	<script src="assetss/js/lib/data-table/buttons.bootstrap.min.js"></script>
	<script src="assetss/js/lib/data-table/datatables-init.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#myDataTab').DataTable();
		});
	</script>
</body>
</html>

