<?php
header( 'Content-Type:text/xml' );
$dbh = new PDO('mysql:host=localhost;dbname=bd_conecta4','root','root');
$sql = 'DELETE FROM moves WHERE game=? AND x=? AND y=?';
$sth = $dbh->prepare($sql);
$sth->execute( array(
	$_REQUEST['game'],
	$_REQUEST['x'],
	$_REQUEST['y']
) );

$sql = 'INSERT INTO moves(game,x,y,color) VALUES (?, ?, ?, ?)';
$sth = $dbh->prepare($sql);
$sth->execute( array(
	$_REQUEST['game'],
	$_REQUEST['x'],
	$_REQUEST['y'],
	$_REQUEST['color']
) );

?>