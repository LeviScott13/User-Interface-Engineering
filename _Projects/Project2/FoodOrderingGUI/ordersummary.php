<?php
	$pickup = (int) $_POST['pickup'];
	$deliver = (int) $_POST['deliver'];
	//$pizzatype = (int) $_POST['pizzatype'];
	//$smallsize = (int) $_POST['small'];
	//$mediumsize = (int) $_POST['medium'];
	//$largesize = (int) $_POST['large'];
	//$toppings = (int) $_POST['toppings'];
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Order Summary</title>
	</head>
	
	<body>
		<h1>Thank You For Ordering Dominos!</h1>
		<?php 
			echo '<p>Your order: </p>';

			$totalqty = 0;
			$totalamount = 0.00;

			define('PIZZATYPE', 5);
			define('SMALLSIZE', 2);
			define('MEDIUM', 3);
			define('LARGESIZE', 4);
			define('TOPPINGS', 4);
			
			//echo "Subtotal: $".number_format($totalamount, 2)."</p>";
			
			$taxrate = 0.10;
			//$totalamount = $totalamount * (1 * $taxrate);
			//echo "<p>Address to ship to is ".htmlspecialchars($address)."</p>";

			$outputstring = "Pickup ".$pickup." \t";
		?>
	</body>
</html>
